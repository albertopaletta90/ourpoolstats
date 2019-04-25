package ourpoolstats.api.coin;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coinmarket.Coin;
import ourpoolstats.client.coinmarket.CoinMarketClient;
import ourpoolstats.response.CoinMarketResponse;
import ourpoolstats.response.status.CoinMarketResponseStatus;
import ourpoolstats.type.LogOperation;

public class CoinMarketInfoPrepare {

	public ResponseEntity<CoinMarketResponse> getCoinInfo(String name) {
		CoinMarketResponse coinMarketResponse = new CoinMarketResponse();
		try {
			CoinMarketClient client = new CoinMarketClient();
			Coin coinInfo = client.getCoinInfo(name);		
			return new CoinMarketResponseStatus().success(coinMarketResponse,coinInfo,LogOperation.INFOCOIN);			
		} catch (Exception e) {
			return new CoinMarketResponseStatus().error(coinMarketResponse,LogOperation.INFOCOIN,e);
		}
	}
}
