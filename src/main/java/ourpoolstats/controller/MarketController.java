package ourpoolstats.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.model.Balance;
import ourpoolstats.type.CurrencyType;
import ourpoolstats.type.DataBaseOperation;
import ourpoolstats.utility.ConvertCurrency;

@Controller
public class MarketController {

	@RequestMapping(value = "/goToSell", method = RequestMethod.GET)
	public ModelAndView goToSell() {
		ModelAndView model = new ModelAndView();
		model.setViewName("market/market");
		return model;

	}

	@RequestMapping(value = "/goToBuy", method = RequestMethod.GET)
	public ModelAndView goToBuy() {
		ModelAndView model = new ModelAndView();
		model.setViewName("market/buy");
		return model;
	}


	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public String buy(HttpServletRequest request) {
		BigDecimal quantity = new BigDecimal(request.getParameter("quantity"));
		int  index =Integer.parseInt(request.getParameter("coin"));
		String coin = ManagerCoin.getInstance().getListCoin().get(index).getName();
		BigDecimal initialCurrency =ManagerCoin.getInstance().getListCoin().get(index).getPriceUsd();
		BigDecimal TotalCurrency = ManagerCoin.getInstance().getListCoin().get(index).getPriceUsd(); 
		if(ManagerCoin.getInstance().getMarketService().buy((String)request.getSession().getAttribute("username"), coin, initialCurrency,TotalCurrency.multiply(quantity),quantity)) {
			ManagerCoin.getInstance().deleteList();
			ManagerCoin.getInstance().setListUserBalance(ManagerCoin.getInstance().getCoinService().getListCoinUser((String)request.getSession().getAttribute("username")));
			return "market/market";
		}
		else
			return "";
	}

	@RequestMapping(value = "/sell", method = RequestMethod.POST)
	public String sell(HttpServletRequest request) {
		try {
			int  index =Integer.parseInt(request.getParameter("coin"));
			Balance balance = ManagerCoin.getInstance().getListUserBalance().get(index);
			int indexCoin = balance.getId();
			BigDecimal quantityCoin = balance.getQuantity();
			BigDecimal quantity = new BigDecimal(request.getParameter("quantity"));

			if(quantity.compareTo(quantityCoin)==0) {
				if(ManagerCoin.getInstance().getMarketService().sell(indexCoin,DataBaseOperation.DELETEBALANCE,quantity)) {
					ManagerCoin.getInstance().deleteList();
					ManagerCoin.getInstance().setListUserBalance(ManagerCoin.getInstance().getCoinService().getListCoinUser((String)request.getSession().getAttribute("username")));
					return "market/market";
				}
				else {
					ManagerCoin.getInstance().setListUserBalance(ManagerCoin.getInstance().getCoinService().getListCoinUser((String)request.getSession().getAttribute("username")));		
					return "";
				}
			}
			else {
				if(ManagerCoin.getInstance().getMarketService().sell(indexCoin,DataBaseOperation.UPDATEBALANCE,quantity)) {
					ManagerCoin.getInstance().deleteList();
					ManagerCoin.getInstance().setListUserBalance(ManagerCoin.getInstance().getCoinService().getListCoinUser((String)request.getSession().getAttribute("username")));
					return "market/market";
				}
				else {
					ManagerCoin.getInstance().setListUserBalance(ManagerCoin.getInstance().getCoinService().getListCoinUser((String)request.getSession().getAttribute("username")));		
					return "";
				}

			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "market/errorChoiche";
		}

	}
	
	@RequestMapping(value = "/convertToEuro", method = RequestMethod.GET)
	public ModelAndView convertToEuro() {
		ModelAndView model = new ModelAndView();
		ManagerImage.getInstance().setImageMarketCurrency(CurrencyType.EURO);		
		for(int i = 0; i<ManagerCoin.getInstance().getListUserBalance().size(); i++) {
			BigDecimal tmp = ConvertCurrency.getInstace().convertTo(CurrencyType.EURO, ManagerCoin.getInstance().getListUserBalance().get(i).getTotalCurrency());
			ManagerCoin.getInstance().getListUserBalance().get(i).setTotalCurrency(tmp);
		}
		model.setViewName("market/market");
		return model;
	}
	@RequestMapping(value = "/convertToUsd", method = RequestMethod.GET)
	public ModelAndView convertToUsd() {
		ModelAndView model = new ModelAndView();
		ManagerImage.getInstance().setImageMarketCurrency(CurrencyType.USD);
		for(int i = 0; i<ManagerCoin.getInstance().getListUserBalance().size(); i++) {
			BigDecimal tmp = ConvertCurrency.getInstace().convertTo(CurrencyType.USD, ManagerCoin.getInstance().getListUserBalance().get(i).getTotalCurrency());
			ManagerCoin.getInstance().getListUserBalance().get(i).setTotalCurrency(tmp);
		}
		model.setViewName("market/market");
		return model;
	}
	@RequestMapping(value = "/convertToBtc", method = RequestMethod.GET)
	public ModelAndView convertToBtc() {
		ModelAndView model = new ModelAndView();
		ManagerImage.getInstance().setImageMarketCurrency(CurrencyType.BTC);
		for(int i = 0; i<ManagerCoin.getInstance().getListUserBalance().size(); i++) {
			BigDecimal tmp = ConvertCurrency.getInstace().convertTo(CurrencyType.BTC, ManagerCoin.getInstance().getListUserBalance().get(i).getTotalCurrency());
			ManagerCoin.getInstance().getListUserBalance().get(i).setTotalCurrency(tmp);
		}
		model.setViewName("market/market");
		return model;
	}

}

