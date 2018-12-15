package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.service.user.UserOperration;
import ourpoolstats.manager.ManagerHome;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.multilingual.MultilingualHomeController;
import ourpoolstats.myenum.Lenguage;
import ourpoolstats.utility.SendEmail;


@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		ManagerHome.getInstance().setLogin(false);
		ManagerHome.getInstance().setNews(true);
		model.setViewName("/home/index");
		return model;
	}
	
	@RequestMapping(value = "/goToMarket", method = RequestMethod.GET)
	public ModelAndView goToMarket() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/ourpoolstats/market");
		return model;

	}
	
	@RequestMapping(value = "/goToForum", method = RequestMethod.GET)
	public ModelAndView goToForum() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/forum/forum");
		return model;
	}
	
	@RequestMapping(value = "/goToLoginSignin", method = RequestMethod.GET)
	public ModelAndView goToLoginSignin() {
		ModelAndView model = new ModelAndView();
		ManagerHome.getInstance().setLogin(true);
		model.setViewName("/home/index");
		return model;
	}
	
	@RequestMapping(value = "/changeToItalian", method = RequestMethod.GET)
	public ModelAndView changeToItalian() {
		ModelAndView model = new ModelAndView();
		MultilingualHomeController.getInstance().setLenguageItalian();
		ManagerImage.getInstance().setImageDefault(Lenguage.ITALIAN);
		model.setViewName("/home/index");
		return model;
	}
	
	@RequestMapping(value = "/changeToEnglish", method = RequestMethod.GET)
	public ModelAndView changeToEnglish() {
		ModelAndView model = new ModelAndView();
		MultilingualHomeController.getInstance().setLenguageEnglish();
		ManagerImage.getInstance().setImageDefault(Lenguage.ENGLISH);
		model.setViewName("/home/index");
		return model;
	}
	
	
	@RequestMapping(value = "/goToSignin", method = RequestMethod.GET)
	public ModelAndView goToSignin() {
		ModelAndView model = new ModelAndView();
		ManagerHome.getInstance().setLogin(false);
		ManagerHome.getInstance().setSignin(true);
		model.setViewName("/loginSignin/signin");
		return model;
	}
	
	@RequestMapping(value = "/goToForGotPassword", method = RequestMethod.GET)
	public ModelAndView goToForgotPassword() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/loginSignin/forGotPassword");
		return model;
	}
	
	@RequestMapping(value = "/forGotPassword", method = RequestMethod.GET)
	public ModelAndView forGotPassword(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		SendEmail send = new SendEmail();
		
		send.sendEmail(request.getParameter("email"));
		model.setViewName("loginSignin/changePasswordTemporany");
		return model;
	}
	
	@RequestMapping(value = "/chagePasswordTemporany", method = RequestMethod.POST)
	public ModelAndView chagePasswordTemporany(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		UserOperration userOperration = new UserOperration();
		
		String user = userOperration.findUsernameToEmail(UserOperration.emailTemporaney);
		userOperration.changePassword(user,request.getParameter("newPass"));
		System.out.println("cambio  " + user +" " + UserOperration.emailTemporaney + " " +request.getParameter("newPass") );
		model.setViewName("home/index");
		
		return model;
	}
}
