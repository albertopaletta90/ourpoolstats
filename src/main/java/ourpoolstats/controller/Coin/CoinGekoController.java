package ourpoolstats.controller.Coin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ourpoolstats.client.coingeko.CoinGekoClient;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.type.CryptoCurrency;
import ourpoolstats.type.CurrencyType;

@Controller
public class CoinGekoController {
	
	@RequestMapping(value = "/goToApiCoinGekoEuro", method = RequestMethod.GET)
	public ModelAndView getCoinEuro() {
		ModelAndView model = new ModelAndView();
		ManagerCoin.getInstance().setCurrencyType(CurrencyType.EURO);
		ManagerImage.getInstance().setImageCurrency(CurrencyType.EURO);
		CoinGekoClient.GetInstance().setCurrency("eur");
		ManagerCoin.getInstance().setMoneyListCoinGeko();
		ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.COINGEKO);
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
	
	@RequestMapping(value = "/goToApiCoinGekoUsd", method = RequestMethod.GET)
	public ModelAndView getCoinUsd() {
		ModelAndView model = new ModelAndView();
		ManagerCoin.getInstance().setCurrencyType(CurrencyType.USD);
		ManagerImage.getInstance().setImageCurrency(CurrencyType.USD);
		CoinGekoClient.GetInstance().setCurrency("usd");
		ManagerCoin.getInstance().setMoneyListCoinGeko();
		ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.COINGEKO);
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
}
