package ourpoolstats.api.market;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperationCoin;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.model.Balance;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.status.BalanceResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.SetConnection;

public class BuyExecute {
	private CommonOperationCoin commonOperationCoin;
	
	public ResponseEntity<BalanceResponse> buy(String username,String quantityS,String coinS) {
		this.commonOperationCoin = new CommonOperationCoin();
		BalanceResponse balanceResponse = new BalanceResponse();
		List<Balance>listMarket = new ArrayList<>();
		try {
			BigDecimal quantity = new BigDecimal(quantityS);
			int  index =Integer.parseInt(coinS);
			String coin = ManagerCoin.getInstance().getListCoin().get(index).getName();
			BigDecimal initialCurrency =ManagerCoin.getInstance().getListCoin().get(index).getPriceUsd();
			BigDecimal totalCurrency = ManagerCoin.getInstance().getListCoin().get(index).getPriceUsd(); 
			try {
				SetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getBuyCoin(),username,coin,initialCurrency,totalCurrency.multiply(quantity),quantity);
				listMarket =commonOperationCoin.getListCoinUser(username);
				return new BalanceResponseStatus().success(username, balanceResponse,LogOperation.BUY,listMarket);
			}
			catch (Exception e) {
				return new BalanceResponseStatus().error(balanceResponse,LogOperation.BUY, username);
			}	
		}catch (Exception e) {
			return new BalanceResponseStatus().badRequestError(balanceResponse,LogOperation.BUY,username);
		}
	}
}
