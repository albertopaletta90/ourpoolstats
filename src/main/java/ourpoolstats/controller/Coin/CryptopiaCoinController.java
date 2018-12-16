package ourpoolstats.controller.Coin;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.service.coin.CoinMarketService;
import oupoolstats.service.coin.CryptopiaService;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.myenum.CryptoCurrency;

@Controller
public class CryptopiaCoinController {
		
	
	private CoinMarketService coinService = new CoinMarketService();
	
	
	@RequestMapping(value = "/goToApiCryptopia", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.CRYPTOPIA);
		CryptopiaService.getInstance().setMapCoin();
		List<String>coinList = coinService.getListCoinDefault();
		//ManagerCoin.getInstance().setCryptopiaCoin(CryptopiaService.getInstance().getListSelectecd(coinList));
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
}
