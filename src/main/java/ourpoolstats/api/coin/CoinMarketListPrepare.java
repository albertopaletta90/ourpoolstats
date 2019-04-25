package ourpoolstats.api.coin;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.model.CoinDB;
import ourpoolstats.response.CoinMarketListResponse;
import ourpoolstats.response.status.CoinMarketResponseStatus;
import ourpoolstats.type.LogOperation;

public class CoinMarketListPrepare {

	public ResponseEntity<CoinMarketListResponse> getCoinMarketList(){
		CoinMarketListResponse coinMarketResponse = new CoinMarketListResponse();
		try {
			List<CoinDB> list = ManagerCoin.getInstance().getListCoin();
			return new CoinMarketResponseStatus().successList(coinMarketResponse, list, LogOperation.INFOCOIN);
		} catch (Exception e) {
			return new CoinMarketResponseStatus().errorList(coinMarketResponse, LogOperation.INFOCOIN, e);
		}
	}
}
