package ourpoolstats.controller.Coin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.type.CryptoCurrency;

@Controller
public class CoinMarketController {

	@RequestMapping(value = "/goToApiCoinMarket", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.COINMARKET);
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
	 
	
}
