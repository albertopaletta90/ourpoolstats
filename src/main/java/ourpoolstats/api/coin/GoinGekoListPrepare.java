package ourpoolstats.api.coin;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.response.CoinGekoListResponse;
import ourpoolstats.response.status.CoinGekoResponseStatus;
import ourpoolstats.type.LogOperation;

public class GoinGekoListPrepare {
	
	public ResponseEntity<CoinGekoListResponse> getCoinGekoList(){
		
		CoinGekoListResponse coinGekoListResponse = new CoinGekoListResponse();
		try {
			List<Market>coinGekoList = ManagerCoin.getInstance().getCoingekoCoin();
			return new CoinGekoResponseStatus().successList(coinGekoListResponse, coinGekoList,LogOperation.INFOCOIN);
		} catch (Exception e) {
			return new CoinGekoResponseStatus().errorList(coinGekoListResponse, e, LogOperation.INFOCOIN);
		}

	}

}
