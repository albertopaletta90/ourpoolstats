package ourpoolstats.response.status;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.response.CurrentCoinResponse;

public class CurrentCoinResponseStatus {

	public ResponseEntity<CurrentCoinResponse> success(CurrentCoinResponse response, BigDecimal priceCurrent) {
		response.setStatus(HttpStatus.OK.toString());
		response.setError("Nessun Errore");
		response.setValue(priceCurrent);
		return new ResponseEntity<CurrentCoinResponse>(response,HttpStatus.OK);
	}

	public ResponseEntity<CurrentCoinResponse> error(CurrentCoinResponse response, Exception e) {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		response.setError("Errore Tecnico" + e.getMessage());
		return new ResponseEntity<CurrentCoinResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}
