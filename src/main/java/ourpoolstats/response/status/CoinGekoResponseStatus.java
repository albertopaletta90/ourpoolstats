package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.response.CoinGekoListResponse;
import ourpoolstats.response.CoinGekoResponse;
import ourpoolstats.type.LogOperation;

public class CoinGekoResponseStatus {

	public ResponseEntity<CoinGekoResponse> success(CoinGekoResponse coinGekoResponse, Market coingeko, LogOperation infocoin) {
		coinGekoResponse.setStatus(HttpStatus.OK.toString());
		coinGekoResponse.setCoinInfo(coingeko);
		return new ResponseEntity<CoinGekoResponse>(coinGekoResponse,HttpStatus.OK);				
	}

	public ResponseEntity<CoinGekoResponse> error(CoinGekoResponse coinGekoResponse, Exception e,LogOperation insertcoin) {
		coinGekoResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		coinGekoResponse.setCoinInfo(null);
		coinGekoResponse.setError(e.getMessage());		
		return new ResponseEntity<CoinGekoResponse>(coinGekoResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<CoinGekoListResponse> successList(CoinGekoListResponse coinGekoResponse, List<Market> coingekoList, LogOperation infocoin) {
		coinGekoResponse.setStatus(HttpStatus.OK.toString());
		coinGekoResponse.setCoingekoList(coingekoList);
		return new ResponseEntity<CoinGekoListResponse>(coinGekoResponse,HttpStatus.OK);				
	}

	public ResponseEntity<CoinGekoListResponse> errorList(CoinGekoListResponse coinGekoResponse, Exception e,LogOperation insertcoin) {
		coinGekoResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		coinGekoResponse.setCoingekoList(null);
		coinGekoResponse.setError(e.getMessage());		
		return new ResponseEntity<CoinGekoListResponse>(coinGekoResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
