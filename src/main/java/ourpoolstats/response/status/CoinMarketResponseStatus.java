package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coinmarket.Coin;
import ourpoolstats.model.CoinDB;
import ourpoolstats.response.CoinMarketListResponse;
import ourpoolstats.response.CoinMarketResponse;
import ourpoolstats.type.LogOperation;

public class CoinMarketResponseStatus {

	public ResponseEntity<CoinMarketResponse> success(CoinMarketResponse coinMarketResponse, Coin coinInfo,LogOperation infocoin) {

		coinMarketResponse.setStatus(HttpStatus.OK.toString());
		coinMarketResponse.setCoinInfo(coinInfo);
		return new ResponseEntity<CoinMarketResponse>(coinMarketResponse,HttpStatus.OK);
	}

	public ResponseEntity<CoinMarketResponse> error(CoinMarketResponse coinMarketResponse, LogOperation infocoin,Exception e) {
		coinMarketResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		coinMarketResponse.setCoinInfo(null);
		coinMarketResponse.setError(e.getMessage());
		return new ResponseEntity<CoinMarketResponse>(coinMarketResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<CoinMarketListResponse> successList(CoinMarketListResponse coinMarketResponse, List<CoinDB> list,LogOperation infocoin) {
		coinMarketResponse.setStatus(HttpStatus.OK.toString());
		coinMarketResponse.setCoinMarketList(list);
		return new ResponseEntity<CoinMarketListResponse>(coinMarketResponse,HttpStatus.OK);
	}

	public ResponseEntity<CoinMarketListResponse> errorList(CoinMarketListResponse coinMarketResponse, LogOperation infocoin,Exception e) {
		coinMarketResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		coinMarketResponse.setCoinMarketList(null);
		coinMarketResponse.setError(e.getMessage());
		return new ResponseEntity<CoinMarketListResponse>(coinMarketResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
