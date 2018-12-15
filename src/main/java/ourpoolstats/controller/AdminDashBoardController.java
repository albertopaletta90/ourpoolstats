package ourpoolstats.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oupoolstats.api.coinmarket.GetCoin;
import oupoolstats.service.admin.AdminDasboradService;
import ourpoolstats.manager.ManagerDashboard;
import ourpoolstats.model.User;
import ourpoolstats.model.UserLog;
import ourpoolstats.myenum.UserType;


@Controller
public class AdminDashBoardController {

	private AdminDasboradService adminDadshboardService = new AdminDasboradService();

	@RequestMapping(value = "/goToCreateUser", method = RequestMethod.GET)
	public ModelAndView goToCreateUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("ourpoolstats/userOption/createUserAdmin");
		ManagerDashboard.getInstance().setCreateUser(true);
		ManagerDashboard.getInstance().setDivOption(true);
		return model;

	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("SpringWeb")User u,ModelMap model,HttpServletRequest request) {
		model.addAttribute("userId", u.getUserId());
		model.addAttribute("userName", u.getUserName());
		model.addAttribute("userSurname", u.getUserSurname());
		model.addAttribute("username",u.getUsername());
		model.addAttribute("password",u.getPassword());
		model.addAttribute("email",u.getEmail());
		model.addAttribute("userType",UserType.USER);
		User tmp = new User();
		tmp.setAllParameter(model);
		System.out.println("sdfbuewfbuwebgfuiweb");

		if(adminDadshboardService.createUser(tmp)) {
			ManagerDashboard.getInstance().setSigninAdminSuccess(true);
			ManagerDashboard.getInstance().setOptionAdmin(false);
			return "ourpoolstats/succes";
		}
		else {
			ManagerDashboard.getInstance().setOptionAdmin(true);
			ManagerDashboard.getInstance().setCreateUser(true);
			ManagerDashboard.getInstance().setSigninAdminSuccess(false);
		//	Controllerutility.ERRORESIGNIN = true;
			return "ourpoolstats/error";
		}
	}



	@RequestMapping(value = "/goToDeleteUser", method = RequestMethod.GET)
	public ModelAndView goToDeleteUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("ourpoolstats/userOption/deleteUser");
		return model;

	}


	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if(adminDadshboardService.deleteUser(request.getParameter("username"))) {
			model.setViewName("ourpoolstats/succes");
			return model;
		}
		else {
			ManagerDashboard.getInstance().setDeleteUserSucces(false);
			ManagerDashboard.getInstance().setOptionAdmin(true);
		}

		model.setViewName("ourpoolstats/error");
		return model;

	}

	@RequestMapping(value = "/goToChangeTypeUser", method = RequestMethod.GET)
	public ModelAndView goToChangeTypeUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("ourpoolstats/userOption/changeUserType");
		return model;

	}

	
	@RequestMapping(value = "/changeTypeUser", method = RequestMethod.POST)
	public ModelAndView changeTypeUser(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if(adminDadshboardService.cangeTypeUser(request.getParameter("userType"),request.getParameter("username"))) {
			model.setViewName("ourpoolstats/succes");
		}
		else {
			ManagerDashboard.getInstance().setChangeUserSuccess(false);
			ManagerDashboard.getInstance().setOptionAdmin(true);
		}

		model.setViewName("ourpoolstats/error");
		return model;

	}

	@RequestMapping(value = "/logUser", method = RequestMethod.GET)
	public ModelAndView logUser(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		List<UserLog>list=adminDadshboardService.logUser();
		request.setAttribute("userLog", list);
		model.setViewName("ourpoolstats/userOption/userLog");
		return model;
	}


	@RequestMapping(value = "/logSingleUser", method = RequestMethod.GET)
	public ModelAndView logSingleUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("ourpoolstats/ourpoolstats");
		return model;
	}

	@RequestMapping(value = "/userOnline", method = RequestMethod.GET)
	public ModelAndView userOnline(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		List<User>list=adminDadshboardService.userOnline((String)request.getSession().getAttribute("user"));
		request.setAttribute("userOnline", list);
		model.setViewName("ourpoolstats/userOption/userOnline");
		return model;
	}

	@RequestMapping(value = "/addCoin", method = RequestMethod.GET)
	public ModelAndView addCoin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("ourpoolstats/ourpoolstats");
		GetCoin getCoin = new GetCoin();
		getCoin.getCoin("Litecoin");
		return model;
	}

}
