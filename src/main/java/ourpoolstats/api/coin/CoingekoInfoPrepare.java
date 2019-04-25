package ourpoolstats.api.coin;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coingeko.CoinGekoClient;
import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.response.CoinGekoResponse;
import ourpoolstats.response.status.CoinGekoResponseStatus;
import ourpoolstats.type.LogOperation;

public class CoingekoInfoPrepare {
	public ResponseEntity<CoinGekoResponse> getCoinInfo(String name) {
		CoinGekoResponse coinGekoResponse = new CoinGekoResponse();
		try {
			Market coingeko = CoinGekoClient.GetInstance().getInfoCoin(name);
			return new CoinGekoResponseStatus().success(coinGekoResponse,coingeko,LogOperation.INFOCOIN);		
		} catch (Exception e) {
			return new CoinGekoResponseStatus().error(coinGekoResponse,e,LogOperation.INSERTCOIN);
		}
	}

}
