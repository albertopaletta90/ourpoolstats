package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.service.user.UserOperration;
import ourpoolstats.manager.ManagerHome;
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
	
	
}
