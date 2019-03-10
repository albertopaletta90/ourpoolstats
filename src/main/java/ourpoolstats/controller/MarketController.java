package ourpoolstats.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.Response;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class MarketController {

	@RequestMapping(value = "/buy/{quantity}/coin/{coinId}", method = RequestMethod.POST)
	public ResponseEntity<BalanceResponse> buy(HttpServletRequest request,@PathVariable("quantity") String quantity, @PathVariable("coinId") String coin) {		
		String username = (String) request.getSession().getAttribute("username");
		return ManagerCoin.getInstance().getMarketService().buy(username,quantity,coin);
	}

	@RequestMapping(value = "/sell/{quantity}/coin/{coinId}", method = RequestMethod.POST)
	public ResponseEntity<BalanceResponse> sell(HttpServletRequest request,@PathVariable("quantity") String quantity, @PathVariable("coinId") String coin) {
		String username = (String) request.getSession().getAttribute("username");
		return ManagerCoin.getInstance().getMarketService().sell(username,quantity,coin);
	}

	@RequestMapping(value = "/getCurrentCurrency/{nameCoin}", method = RequestMethod.POST)
	public BigDecimal getCurrencyCoin(@PathVariable("nameCoin") String nameCoin) {		
		return ManagerCoin.getInstance().getMarketService().getCurrentCurrencyCoin(nameCoin);
	}

	
	@RequestMapping(value = "/convertToEuro", method = RequestMethod.GET)
	public ResponseEntity<Response> convertToEuro(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		return ManagerCoin.getInstance().getMarketService().convertToEuro(username);
	}


	@RequestMapping(value = "/convertToUsd", method = RequestMethod.GET)
	public ResponseEntity<Response> convertToUsd(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		return ManagerCoin.getInstance().getMarketService().convertToUsd(username);
	}

	@RequestMapping(value = "/convertToBtc", method = RequestMethod.GET)
	public ResponseEntity<Response> convertToBtc() {
		return ManagerCoin.getInstance().getMarketService().convertToUsd("");
	}

}

