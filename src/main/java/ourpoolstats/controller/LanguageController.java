package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.service.language.LanguageService;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.multilingual.MultiLilingualDashboardController;
import ourpoolstats.multilingual.MultilingualHomeController;
import ourpoolstats.myenum.LenguageType;

@Controller
public class LanguageController {

	@RequestMapping(value = "/changeToItalian", method = RequestMethod.GET)
	public ModelAndView changeToItalian() {
		ModelAndView model = new ModelAndView();
		MultilingualHomeController.getInstance().setLenguageItalian();
		ManagerImage.getInstance().setImageDefault(LenguageType.ITALIAN);
		model.setViewName("/home/index");
		return model;
	}
	
	@RequestMapping(value = "/changeToEnglish", method = RequestMethod.GET)
	public ModelAndView changeToEnglish() {
		ModelAndView model = new ModelAndView();
		MultilingualHomeController.getInstance().setLenguageEnglish();
		ManagerImage.getInstance().setImageDefault(LenguageType.ENGLISH);
		model.setViewName("/home/index");
		return model;
	}
	@RequestMapping(value = "/changeToItalianDasboard", method = RequestMethod.GET)
	public ModelAndView changeToItalianD(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		MultiLilingualDashboardController.getInstance().setLenguageItalian();
		ManagerImage.getInstance().setImageDefault(LenguageType.ITALIAN);
		LanguageService languageService = new LanguageService();
		languageService.setLenguace("italiano", (String) request.getSession().getAttribute("username"));
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
	
	@RequestMapping(value = "/changeToEnglishDashboard", method = RequestMethod.GET)
	public ModelAndView changeToEnglishD(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		MultiLilingualDashboardController.getInstance().setLenguageEnglish();
		ManagerImage.getInstance().setImageDefault(LenguageType.ENGLISH);
		LanguageService languageService = new LanguageService();
		languageService.setLenguace("inglese", (String) request.getSession().getAttribute("username"));
		model.setViewName("/ourpoolstats/ourpoolstats");
		return model;
	}
	
}