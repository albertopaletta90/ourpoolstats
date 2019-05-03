package ourpoolstats.api.coin;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperationCoin;
import ourpoolstats.model.Balance;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.status.BalanceResponseStatus;
import ourpoolstats.type.CurrencyType;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.ConvertCurrency;
import ourpoolstats.utility.connection.GetConnection;

public class ConvertCurrencyPrepare {
	private CommonOperationCoin commonOperationCoin;
	public ResponseEntity<BalanceResponse> convertToEuro(String username,CurrencyType currency) {
		this.commonOperationCoin = new CommonOperationCoin();
		BalanceResponse balanceResponse = new BalanceResponse();
		List<Balance>listMarket = commonOperationCoin.getListCoinUser(username);
		try {	
			if(listMarket.isEmpty()) {
				return new BalanceResponseStatus().notFound(balanceResponse, username, LogOperation.CONVERTCOIN, listMarket);
			}
			for(int i = 0; i<listMarket.size(); i++) {
				BigDecimal total = ConvertCurrency.getInstace().convertTo(currency, listMarket.get(i).getTotalCurrency());
				BigDecimal initial = ConvertCurrency.getInstace().convertTo(currency, listMarket.get(i).getInitialCurrency());
				listMarket.get(i).setTotalCurrency(total);
				listMarket.get(i).setInitialCurrency(initial);
				GetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getUpdateListMarketPersonal(),listMarket.get(i).getTotalCurrency(),listMarket.get(i).getInitialCurrency(),listMarket.get(i).getId());					
			}
			return new BalanceResponseStatus().success(username, balanceResponse,LogOperation.GETLISTMARKETPERSONAL, listMarket);
		}
		catch (Exception e) {
			return new BalanceResponseStatus().error(balanceResponse,LogOperation.GETLISTMARKETPERSONAL, username);
		}

	}

}
