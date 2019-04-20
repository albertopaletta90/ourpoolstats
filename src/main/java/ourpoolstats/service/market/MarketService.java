package ourpoolstats.service.market;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.client.coinmarket.Coin;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.model.Balance;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.CurrentCoinResponse;
import ourpoolstats.response.Response;
import ourpoolstats.type.CurrencyType;
import ourpoolstats.type.DataBaseOperation;
import ourpoolstats.utility.ConvertCurrency;
import ourpoolstats.utility.GetConnection;

public class MarketService implements IMarketService {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;
	public MarketService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}


	@Override
	public ResponseEntity<BalanceResponse> buy(String username,String quantityS,String coinS) {
		BalanceResponse balanceResponse = new BalanceResponse();
		List<Balance>listMarket = new ArrayList<>();
		try {
			BigDecimal quantity = new BigDecimal(quantityS);
			int  index =Integer.parseInt(coinS);
			String coin = ManagerCoin.getInstance().getListCoin().get(index).getName();
			BigDecimal initialCurrency =ManagerCoin.getInstance().getListCoin().get(index).getPriceUsd();
			BigDecimal totalCurrency = ManagerCoin.getInstance().getListCoin().get(index).getPriceUsd(); 
			try {
				jdbcTemplate.update(QueryCoin.getInstance().getBuyCoin(),username,coin,initialCurrency,totalCurrency.multiply(quantity),quantity);
				listMarket =ManagerCoin.getInstance().getCoinService().getListCoinUser(username);
				balanceResponse.setStatus(HttpStatus.OK.toString());
				balanceResponse.setBalance(listMarket);
				return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.OK);
			}
			catch (Exception e) {
				operationKo(balanceResponse);
				return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.INTERNAL_SERVER_ERROR);
			}	

		}catch (Exception e) {
			e.getMessage();
			setBadRequestError(balanceResponse);
			return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.BAD_REQUEST);
		}
	}


	@Override
	public ResponseEntity<BalanceResponse> sell(String username,String quantityS,String coinS) {
		BalanceResponse balanceResponse = new BalanceResponse();
		List<Balance>listMarket = ManagerCoin.getInstance().getCoinService().getListCoinUser(username);
		try {
			int  index =Integer.parseInt(coinS);
			Balance balance = listMarket.get(index);
			int indexCoin = balance.getId();
			BigDecimal quantityCoin = balance.getQuantity();
			BigDecimal quantity = new BigDecimal(quantityS);
			if(quantity.compareTo(quantityCoin)==0) {
				if(ManagerCoin.getInstance().getMarketService().sell(indexCoin,DataBaseOperation.DELETEBALANCE,quantity)) {
					sellSuccess(username,balanceResponse);
					return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.OK);
				}
				else {
					operationKo(balanceResponse);
					return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			else {
				if(ManagerCoin.getInstance().getMarketService().sell(indexCoin,DataBaseOperation.UPDATEBALANCE,quantity)) {
					sellSuccess(username,balanceResponse);
					return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.OK);
				}
				else {
					operationKo(balanceResponse);
					return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}
		}
		catch (Exception e) {
			setBadRequestError(balanceResponse);
			return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.BAD_REQUEST);
		}

	}


	@Override
	public  ResponseEntity<CurrentCoinResponse> getCurrentCurrencyCoin(String nameCoin) {
		Coin coin = ManagerCoin.getInstance().getGetCoin().getCoinInfo(nameCoin);
		BigDecimal priceCurrent = BigDecimal.valueOf(coin.getPrice_usd());
		CurrentCoinResponse response = new CurrentCoinResponse();
		response.setStatus(HttpStatus.OK.toString());
		priceCurrent = priceCurrent.setScale(7, RoundingMode.CEILING);
		response.setValue(priceCurrent);
		return new ResponseEntity<CurrentCoinResponse>(response,HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Response> convertToEuro(String username) {
		Response response = new Response();
		List<Balance>listMarket = ManagerCoin.getInstance().getCoinService().getListCoinUser(username);
		try {
			ManagerImage.getInstance().setImageMarketCurrency(CurrencyType.EURO);		
			if(listMarket.isEmpty()) {
				response.setStatus(HttpStatus.NOT_FOUND.toString());
				response.setError("Lista Vuota");
				return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
			}
			for(int i = 0; i<listMarket.size(); i++) {
				BigDecimal total = ConvertCurrency.getInstace().convertTo(CurrencyType.EURO, listMarket.get(i).getTotalCurrency());
				BigDecimal initial = ConvertCurrency.getInstace().convertTo(CurrencyType.EURO, listMarket.get(i).getInitialCurrency());
				listMarket.get(i).setTotalCurrency(total);
				listMarket.get(i).setInitialCurrency(initial);
				jdbcTemplate.update(QueryCoin.getInstance().getUpdateListMarketPersonal(),listMarket.get(i).getTotalCurrency(),listMarket.get(i).getInitialCurrency(),listMarket.get(i).getId());					
			}
			response.setStatus(HttpStatus.OK.toString());
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		catch (Exception e) {
			response.setError(e.getMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Response> convertToUsd(String username) {
		Response response = new Response();
		List<Balance>listMarket = ManagerCoin.getInstance().getCoinService().getListCoinUser(username);
		try {
			ManagerImage.getInstance().setImageMarketCurrency(CurrencyType.USD);
			if(listMarket.isEmpty()) {
				response.setStatus(HttpStatus.NOT_FOUND.toString());
				response.setError("Lista Vuota");
				return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
			}

			for(int i = 0; i<listMarket.size(); i++) {
				BigDecimal total = ConvertCurrency.getInstace().convertTo(CurrencyType.USD, listMarket.get(i).getTotalCurrency());
				BigDecimal initial = ConvertCurrency.getInstace().convertTo(CurrencyType.USD, listMarket.get(i).getInitialCurrency());
				listMarket.get(i).setTotalCurrency(total);
				listMarket.get(i).setInitialCurrency(initial);
				jdbcTemplate.update(QueryCoin.getInstance().getUpdateListMarketPersonal(),listMarket.get(i).getTotalCurrency(),listMarket.get(i).getInitialCurrency(),listMarket.get(i).getId());					
			}
			response.setStatus(HttpStatus.OK.toString());
			return new ResponseEntity<Response>(response,HttpStatus.OK);

		} catch (Exception e) {
			response.setError(e.getMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}


	@Override
	public ResponseEntity<Response> convertToBtc() {
		// TODO Auto-generated method stub
		return null;
	}



	public boolean sell(int index,DataBaseOperation operation,BigDecimal quantity ){
		switch (operation) {
		case DELETEBALANCE:
			try {
				jdbcTemplate.update(QueryCoin.getInstance().getDeleteCoinBalance(),index);
				System.out.println(QueryCoin.getInstance().getDeleteCoinBalance());
				return true;
			}catch (Exception e) {
				System.out.println(e.getMessage());			
				return false;
			}
		case UPDATEBALANCE:
			try {
				jdbcTemplate.update(QueryCoin.getInstance().getUpdateQuantityCoinBalance(),quantity,index);
				return true;
			}catch (Exception e) {
				System.out.println(e.getMessage());			
				return false;
			}
		default:
			break;

		}
		return false;
	}

	private void sellSuccess(String username, BalanceResponse balanceResponse) {
		List<Balance>listMarket = ManagerCoin.getInstance().getCoinService().getListCoinUser(username);
		balanceResponse.setStatus(HttpStatus.OK.toString());
		balanceResponse.setBalance(listMarket);
	}

	private void operationKo(BalanceResponse balanceResponse) {	
		List<Balance>listMarket = ManagerCoin.getInstance().getCoinService().getListCoinUser("alberone");
		balanceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		balanceResponse.setBalance(listMarket);

	}


	private void setBadRequestError(BalanceResponse balanceResponse) {
		List<Balance>listMarket = ManagerCoin.getInstance().getCoinService().getListCoinUser("alberone");
		balanceResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
		balanceResponse.setBalance(listMarket);
		balanceResponse.setEroor("Monete/Quantita sono obbligatori");

	}


	@Override
	public ResponseEntity<BalanceResponse> getListMarket(String username) {
		List<Balance>listMarket = ManagerCoin.getInstance().getCoinService().getListCoinUser(username);
		BalanceResponse balanceResponse = new BalanceResponse();
		balanceResponse.setStatus(HttpStatus.OK.toString());
		balanceResponse.setBalance(listMarket);
		return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.OK);
	}

}
