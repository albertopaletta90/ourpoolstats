package ourpoolstats.api.coin;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coinmarket.Coin;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.response.CurrentCoinResponse;
import ourpoolstats.response.status.CurrentCoinResponseStatus;

public class GetCurrentCoinPrepare {

	public  ResponseEntity<CurrentCoinResponse> getCurrentCurrencyCoin(String nameCoin) {
		CurrentCoinResponse response = new CurrentCoinResponse();
		try {
			Coin coin = ManagerCoin.getInstance().getGetCoin().getCoinInfo(nameCoin);
			BigDecimal priceCurrent = BigDecimal.valueOf(coin.getPrice_usd());
			priceCurrent = priceCurrent.setScale(7, RoundingMode.CEILING);
			return new CurrentCoinResponseStatus().success(response,priceCurrent);
		}catch (Exception e) {
			return new CurrentCoinResponseStatus().error(response,e);
		}
		
	}
}
