package ourpoolstats.controller.Coin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.myenum.CryptoCurrency;

@Controller
public class CoinGekoController {
	
	@RequestMapping(value = "/goToApiCoinGeko", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.COINGEKO);
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
}
