package ourpoolstats.service.portfolio;

import org.springframework.http.ResponseEntity;

import ourpoolstats.model.Portfolio;
import ourpoolstats.response.ResponsePortfolio;

public interface IportfolioService {
	
	public ResponseEntity<ResponsePortfolio> insertToPortfolio(Portfolio portfolio);
	public ResponseEntity<ResponsePortfolio> deleteCoinToPortfolio(String name,String username);
	public ResponseEntity<ResponsePortfolio> getCoinToPortfolio(String username);
	

}
