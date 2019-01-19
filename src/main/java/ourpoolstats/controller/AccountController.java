package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.service.user.UserOperration;




@Controller
public class AccountController {

	private UserOperration userService = new UserOperration();

	@RequestMapping(value = "/goToAddImage", method = RequestMethod.GET)
	public String goToAddImage(HttpServletRequest request){
		return "ourpoolstats/userOption/addImage";
	}


	@RequestMapping(value = "/addImage", method = RequestMethod.POST)
	public String addImage(HttpServletRequest request){
		userService.setImageProfile((String) request.getSession().getAttribute("username"), request.getParameter("url"),"update");
		userService.getImageProfile((String) request.getSession().getAttribute("username"));
		return "/ourpoolstats/account";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		userService.deleteToUserOnline((String)request.getSession().getAttribute("username"));
		request.getSession().removeAttribute("username");
		return "/home/index";
	}


	@RequestMapping(value = "/goToChangePassword", method = RequestMethod.GET)
	public String goToChangePassword(HttpServletRequest request){
		return "ourpoolstats/userOption/changePassword";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest request){
		
		if(userService.changePassword((String) request.getSession().getAttribute("username"), request.getParameter("password"))) {
			return "ourpoolstats/succesUser";
		}
		else {
			return "/ourpoolstats/errorUser";
		}
	}


	@RequestMapping(value = "/goToChangeEmail", method = RequestMethod.GET)
	public String goToChangeEmail(HttpServletRequest request){
		return "ourpoolstats/userOption/changeEmail";

	}

	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST)
	public String changeEmail(HttpServletRequest request){

		if(userService.changeEmail((String) request.getSession().getAttribute("username"), request.getParameter("email"))) {
			return "ourpoolstats/succesUser";
		}
		else {
			return "/ourpoolstats/errorUser";
		}

	}

	@RequestMapping(value = "/goToDeleteUserAction", method = RequestMethod.GET)
	public String goToDeleteUserAction(HttpServletRequest request) {
		return "ourpoolstats/userOption/delete";

	}

	@RequestMapping(value = "/deleteUserAction", method = RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if(userService.deleteUser((String)request.getSession().getAttribute("username"))) {
			model.setViewName("ourpoolstats/succesUser");
		}
		else {
			model.setViewName("ourpoolstats/errorUser");
		}
		return model;

	}


}
