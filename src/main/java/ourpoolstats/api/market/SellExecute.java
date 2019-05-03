package ourpoolstats.api.market;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperationCoin;
import ourpoolstats.model.Balance;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.status.BalanceResponseStatus;
import ourpoolstats.type.DataBaseOperation;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.GetConnection;

public class SellExecute {

	private CommonOperationCoin commonOperationCoin;


	public ResponseEntity<BalanceResponse> sell(String username,String quantityS,String coinS) {
		this.commonOperationCoin = new CommonOperationCoin();
		BalanceResponse balanceResponse = new BalanceResponse();
		List<Balance>listMarket = commonOperationCoin.getListCoinUser(username);
		try {
			int  index =Integer.parseInt(coinS);
			Balance balance = listMarket.get(index);
			int indexCoin = balance.getId();
			BigDecimal quantityCoin = balance.getQuantity();
			BigDecimal quantity = new BigDecimal(quantityS);
			if(quantity.compareTo(quantityCoin)==0) {
				if(sell(indexCoin,DataBaseOperation.DELETEBALANCE,quantity)) {
					reloadList(listMarket,username);
					return new BalanceResponseStatus().success(username, balanceResponse,LogOperation.SELl,listMarket);
				}
				else {
					reloadList(listMarket,username);
					return new BalanceResponseStatus().error(balanceResponse,LogOperation.SELl,username);
				}
			}
			else {
				if(sell(indexCoin,DataBaseOperation.UPDATEBALANCE,quantity)) {
					reloadList(listMarket,username);
					return new BalanceResponseStatus().success(username, balanceResponse,LogOperation.SELl,listMarket);
				}
				else {
					reloadList(listMarket,username);
					return new BalanceResponseStatus().error(balanceResponse,LogOperation.SELl,username);
				}
			}
		}
		catch (Exception e) {
			return new BalanceResponseStatus().badRequestError(balanceResponse,LogOperation.SELl,username);
		}

	}
	
	private void  reloadList(List<Balance>listMarket,String username) {
		listMarket = commonOperationCoin.getListCoinUser(username);
	}
	
	
	public boolean sell(int index,DataBaseOperation operation,BigDecimal quantity ){
		switch (operation) {
		case DELETEBALANCE:
			try {
				GetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getDeleteCoinBalance(),index);
				System.out.println(QueryCoin.getInstance().getDeleteCoinBalance());
				return true;
			}catch (Exception e) {
				return false;
			}
		case UPDATEBALANCE:
			try {
				GetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getUpdateQuantityCoinBalance(),quantity,index);
				return true;
			}catch (Exception e) {	
				return false;
			}
		default:
			break;
		}
		return false;
	}
}
