package ourpoolstats.service.market;

import org.springframework.http.ResponseEntity;

import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.CurrentCoinResponse;
import ourpoolstats.response.Response;

public interface IMarketService {
	
	public ResponseEntity<BalanceResponse> buy(String username,String quantity,String coin);
	public ResponseEntity<BalanceResponse> sell(String username,String quantity,String coin);
	public ResponseEntity<CurrentCoinResponse> getCurrentCurrencyCoin(String nameCoin);
	public ResponseEntity<Response> convertToEuro(String username);
	public ResponseEntity<Response> convertToUsd(String username);
	public ResponseEntity<Response> convertToBtc();
	public ResponseEntity<BalanceResponse>getListMarket(String username);
}
