package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.api.coingeko.data.Market;
import oupoolstats.api.coinmarket.Coin;
import oupoolstats.service.coin.CoinGekoService;
import oupoolstats.service.coin.CoinMarketService;
import ourpoolstats.manager.ManagerCoin;


@Controller
public class DashboardController {

	private CoinMarketService coinMarket = new CoinMarketService();


	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView goToDashboard() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
	
	@RequestMapping(value = "/goToAccount", method = RequestMethod.GET)
	public ModelAndView goToAccount() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/ourpoolstats/account");
		return model;
	}
	
	@RequestMapping(value = "/goToMarket", method = RequestMethod.GET)
	public ModelAndView goToMarket(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		ManagerCoin.getInstance().setListUserCoinMarket(ManagerCoin.getInstance().getCoinService().getListCoinUser((String)request.getSession().getAttribute("username")));
		model.setViewName("/ourpoolstats/market");
		return model;

	}

	@RequestMapping(value = "/goToForum", method = RequestMethod.GET)
	public ModelAndView goToForum() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/forum/forum");
		return model;
	}

	@RequestMapping(value = "/coinMarketInfo", method = RequestMethod.GET)
	public String goToInfoCoin(@RequestParam("idCoin") String id,HttpServletRequest request) throws Exception{

		Coin coinInfo = coinMarket.getCoinInfo(id);
		request.getSession().setAttribute("infoCoin", coinInfo);

		return "/ourpoolstats/coin/coinMarketInfo";
	}
	
	@RequestMapping(value = "/coinGekoInfo", method = RequestMethod.GET)
	public String goToInfoGekoCoin(@RequestParam("idCoin") String id,HttpServletRequest request) throws Exception{

		Market coingeko = CoinGekoService.getInstance().getCoinInfo(id);
		request.getSession().setAttribute("infoCoinGeko", coingeko);

		return "/ourpoolstats/coin/coinGekoInfo";
	}


}
