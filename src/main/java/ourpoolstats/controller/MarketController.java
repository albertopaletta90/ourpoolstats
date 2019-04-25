package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.api.coin.ConvertCurrencyPrepare;
import ourpoolstats.api.coin.GetCurrentCoinPrepare;
import ourpoolstats.api.market.BuyExecute;
import ourpoolstats.api.market.SellExecute;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.CurrentCoinResponse;
import ourpoolstats.response.Response;
import ourpoolstats.type.CurrencyType;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class MarketController {

	@RequestMapping(value = "/buy/{quantity}/coin/{coinId}/username/{username}", method = RequestMethod.POST)
	public ResponseEntity<BalanceResponse> buy(HttpServletRequest request,@PathVariable("quantity") String quantity, @PathVariable("coinId") String coin, @PathVariable("username") String username) {		
		return new BuyExecute().buy(username,quantity,coin);
	}

	@RequestMapping(value = "/sell/{quantity}/coin/{coinId}/username/{username}", method = RequestMethod.POST)
	public ResponseEntity<BalanceResponse> sell(HttpServletRequest request,@PathVariable("quantity") String quantity, @PathVariable("coinId") String coin,@PathVariable("username") String username) {
		return new SellExecute().sell(username,quantity,coin);
	}

	@RequestMapping(value = "/getCurrentCurrency/{nameCoin}", method = RequestMethod.POST)
	public  ResponseEntity<CurrentCoinResponse> getCurrencyCoin(@PathVariable("nameCoin") String nameCoin) {		
		return new GetCurrentCoinPrepare().getCurrentCurrencyCoin(nameCoin);
	}
	
	@RequestMapping(value = "/convertToEuro/{username}", method = RequestMethod.GET)
	public ResponseEntity<BalanceResponse> convertToEuro(@PathVariable("username") String username) {
		return new ConvertCurrencyPrepare().convertToEuro(username,CurrencyType.EURO);
	}

	@RequestMapping(value = "/convertToUsd/{username}", method = RequestMethod.GET)
	public ResponseEntity<BalanceResponse> convertToUsd(@PathVariable("username") String username) {
		return new ConvertCurrencyPrepare().convertToEuro(username,CurrencyType.USD);
	}

	@RequestMapping(value = "/convertToBtc", method = RequestMethod.GET)
	public ResponseEntity<Response> convertToBtc() {
		return null;
	}

}