package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.CoinGekoListResponse;
import ourpoolstats.response.CoinGekoResponse;
import ourpoolstats.response.CoinMarketListResponse;
import ourpoolstats.response.CoinMarketResponse;
import ourpoolstats.response.Response;
import ourpoolstats.service.coin.CoinGekoService;
import ourpoolstats.service.coin.CoinMarketService;
import ourpoolstats.service.language.LanguageService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DashboardController {



	@RequestMapping(value = "/getListMarket", method = RequestMethod.GET)
	public ResponseEntity<BalanceResponse> goToMarket(HttpServletRequest request) {
		String username = (String)request.getSession().getAttribute("username");
		return ManagerCoin.getInstance().getMarketService().getListMarket(username);
	}
	
	@RequestMapping(value = "/coinMarketInfo/{id}", method = RequestMethod.POST)
	public ResponseEntity<CoinMarketResponse> goToInfoCoin(@PathVariable("id") String id){
		return new CoinMarketService().getCoinInfo(id);
	}

	@RequestMapping(value = "/coinGekoInfo/{id}", method = RequestMethod.POST)
	public ResponseEntity<CoinGekoResponse> goToInfoGekoCoin(@PathVariable("id") String id){
		return new CoinGekoService().getCoinInfo(id);
	}

	@RequestMapping(value = "/getCoinGekoList", method = RequestMethod.GET)
	public ResponseEntity<CoinGekoListResponse> getCoinGekoList(){
		CoinGekoListResponse coinGekoList = new CoinGekoListResponse();
		coinGekoList.setCoingekoList(ManagerCoin.getInstance().getCoingekoCoin());
		return new ResponseEntity<CoinGekoListResponse>(coinGekoList,HttpStatus.OK);

	}

	@RequestMapping(value = "/getCoinMarketList", method = RequestMethod.GET)
	public ResponseEntity<CoinMarketListResponse> getCoinMarketList(){
		CoinMarketListResponse coinMarketResponse = new CoinMarketListResponse();
		coinMarketResponse.setCoinMarketList(ManagerCoin.getInstance().getListCoin());
		return new ResponseEntity<CoinMarketListResponse>(coinMarketResponse,HttpStatus.OK);

	}

	
	@RequestMapping(value = "/changeLanguage/{type}", method = RequestMethod.GET)
	public ResponseEntity<Response> chageLanguage(@PathVariable("type")String type,HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		return new LanguageService().changeLanguage(username, type);
	}
	
}
