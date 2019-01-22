package ourpoolstats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.api.coinmarket.Coin;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.multilingual.MultiLilingualDashboardController;
import ourpoolstats.myenum.LenguageType;


@Controller
public class DashboardController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
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

	@RequestMapping(value = "/viewDashboard", method = RequestMethod.GET)
	public String goToInfoCoin(@RequestParam("idBook") String id) {
	
		System.out.println("fenkrnkingri + " + id);
		return "/ourpoolstats/viewDashboard";
	}
	
	
}
