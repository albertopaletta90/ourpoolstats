package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.model.Portfolio;
import ourpoolstats.response.ResponsePortfolio;

public class PortofolioResponseStatus {
	
	public ResponseEntity<ResponsePortfolio> succes(ResponsePortfolio responsePortfolio, List<Portfolio> list,List<Portfolio> listPartecipant) {
		responsePortfolio.setStatus(HttpStatus.OK.toString());
		responsePortfolio.setPortfolio(list);
		responsePortfolio.setListPartecipant(listPartecipant);
		return new ResponseEntity<ResponsePortfolio>(responsePortfolio,HttpStatus.OK);
	}

	public ResponseEntity<ResponsePortfolio> listNotFound(ResponsePortfolio responsePortfolio) {
		responsePortfolio.setStatus(HttpStatus.NOT_FOUND.toString());
		responsePortfolio.setPortfolio(null);
		responsePortfolio.setError("Lista Non Trovata");
		return new ResponseEntity<ResponsePortfolio>(responsePortfolio,HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponsePortfolio> error(ResponsePortfolio portfolio, Exception e) {
		portfolio.setPortfolio(null);
		portfolio.setError(e.getMessage());
		portfolio.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<ResponsePortfolio>(portfolio,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
