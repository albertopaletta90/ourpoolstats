package ourpoolstats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.api.coinmarket.Coin;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.multilingual.MultiLilingualDashboardController;
import ourpoolstats.myenum.Lenguage;


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
	
	
	@RequestMapping(value = "/changeToItalianDasboard", method = RequestMethod.GET)
	public ModelAndView changeToItalian() {
		ModelAndView model = new ModelAndView();
		MultiLilingualDashboardController.getInstance().setLenguageItalian();
		ManagerImage.getInstance().setImageDefault(Lenguage.ITALIAN);
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
	
	@RequestMapping(value = "/changeToEnglishDashboard", method = RequestMethod.GET)
	public ModelAndView changeToEnglish() {
		ModelAndView model = new ModelAndView();
		MultiLilingualDashboardController.getInstance().setLenguageEnglish();
		ManagerImage.getInstance().setImageDefault(Lenguage.ENGLISH);
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
	
	
	@RequestMapping(value = "/goToInfoCoin", method = RequestMethod.POST)
	public String goToInfoCoin(@ModelAttribute("SpringWeb")Coin c,ModelMap model) {
		model.addAttribute("name", c.getName());
		System.out.println("fenkrnkingri + " +c.getName());
		return "";
	}
}
