package ourpoolstats.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.api.coin.CoinMarketInfoPrepare;
import ourpoolstats.api.coin.CoingekoInfoPrepare;
import ourpoolstats.api.coin.GetListMarketPersonalPrepare;
import ourpoolstats.api.coin.GoinGekoListPrepare;
import ourpoolstats.api.coin.ImageCoinPrepare;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.response.CoinGekoListResponse;
import ourpoolstats.response.CoinGekoResponse;
import ourpoolstats.response.CoinMarketListResponse;
import ourpoolstats.response.CoinMarketResponse;
import ourpoolstats.response.Response;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CoinController {



	@RequestMapping(value = "/getListMarket/{username}", method = RequestMethod.GET)
	public ResponseEntity<BalanceResponse> goToMarket(@PathVariable("username") String username) {
		return new GetListMarketPersonalPrepare().getListMarket(username);
	}
	
	@RequestMapping(value = "/coinMarketInfo/{id}", method = RequestMethod.POST)
	public ResponseEntity<CoinMarketResponse> goToInfoCoin(@PathVariable("id") String id){
		return new CoinMarketInfoPrepare().getCoinInfo(id);
	}

	@RequestMapping(value = "/coinGekoInfo/{id}", method = RequestMethod.POST)
	public ResponseEntity<CoinGekoResponse> goToInfoGekoCoin(@PathVariable("id") String id){
		return new CoingekoInfoPrepare().getCoinInfo(id);
	}

	@RequestMapping(value = "/getCoinGekoList", method = RequestMethod.GET)
	public ResponseEntity<CoinGekoListResponse> getCoinGekoList(){
		return new GoinGekoListPrepare().getCoinGekoList();
	}

	@RequestMapping(value = "/getCoinMarketList", method = RequestMethod.GET)
	public ResponseEntity<CoinMarketListResponse> getCoinMarketList(){
		CoinMarketListResponse coinMarketResponse = new CoinMarketListResponse();
		coinMarketResponse.setCoinMarketList(ManagerCoin.getInstance().getListCoin());
		return new ResponseEntity<CoinMarketListResponse>(coinMarketResponse,HttpStatus.OK);

	}
	
	@RequestMapping(value = "/imageCoin/{name}", method = RequestMethod.GET)
	public  ResponseEntity<Response> getImageCoin(@PathVariable("name") String name) {
		return new ImageCoinPrepare().getImageCoin(name);
	}
}
