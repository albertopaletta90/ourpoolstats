package ourpoolstats.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.api.portfolio.DeleteCoinToPortofolioPrepare;
import ourpoolstats.api.portfolio.GetCoinToPortfolioPrepare;
import ourpoolstats.api.portfolio.InsertToPortfolioPrepare;
import ourpoolstats.model.Portfolio;
import ourpoolstats.response.ResponsePortfolio;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PortfolioController {
	
	@RequestMapping(value = "/insertToPortfolio/{username}/type/{type}/name/{name}/quantity/{quantity}/priceI/{priceI}/priceC/{priceC}", method = RequestMethod.POST)
	public ResponseEntity<ResponsePortfolio> insertToPortofolio(@PathVariable("username")String username,@PathVariable("type")String type,@PathVariable("name")String name,@PathVariable("quantity")BigDecimal quantity,@PathVariable("PriceI")BigDecimal priceI,@PathVariable("PriceC")BigDecimal priceC) {		
		Portfolio portfolio = new Portfolio(username,type,name,quantity,priceI,priceC);
		return new InsertToPortfolioPrepare().insertToPortfolio(portfolio);
	}
	
	@RequestMapping(value = "/deleteToPortfolio/{name}/username/{username}", method = RequestMethod.POST)
	public ResponseEntity<ResponsePortfolio> deleteToPortofolio(@PathVariable("name")String name,@PathVariable("username")String username) {
		return new DeleteCoinToPortofolioPrepare().deleteCoinToPortfolio(name,username);
	}
	
	@RequestMapping(value = "/getCoinToPortfolio/{username}", method = RequestMethod.POST)
	public ResponseEntity<ResponsePortfolio> getCoinToPortofolio(@PathVariable("username")String username) {
		return new GetCoinToPortfolioPrepare().getCoinToPortfolio(username);
	}

}
