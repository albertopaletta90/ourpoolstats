package ourpoolstats.api.coin;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperationCoin;
import ourpoolstats.model.Balance;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.status.BalanceResponseStatus;
import ourpoolstats.type.LogOperation;

public class GetListMarketPersonalPrepare {

	private CommonOperationCoin commonOperationCoin;

	public ResponseEntity<BalanceResponse> getListMarket(String username) {
		this.commonOperationCoin = new CommonOperationCoin();
		BalanceResponse balanceResponse = new BalanceResponse();
		try {
			List<Balance>listMarket = commonOperationCoin.getListCoinUser(username);
			return new BalanceResponseStatus().success(username, balanceResponse,LogOperation.GETLISTMARKETPERSONAL, listMarket);
		} catch (Exception e) {
			List<Balance>listMarket = commonOperationCoin.getListCoinUser(username);
			return new BalanceResponseStatus().notFound(balanceResponse, username, LogOperation.GETLISTMARKETPERSONAL,listMarket);
		}
	}
}
