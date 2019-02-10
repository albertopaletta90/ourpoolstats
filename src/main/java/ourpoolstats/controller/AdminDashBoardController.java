package ourpoolstats.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ourpoolstats.api.coinmarket.CoinMarketClient;
import ourpoolstats.log.AdminOperationLogger;
import ourpoolstats.manager.ManagerDashboard;
import ourpoolstats.model.User;
import ourpoolstats.model.UserLog;
import ourpoolstats.service.admin.AdminDasboradService;
import ourpoolstats.service.language.LanguageService;
import ourpoolstats.type.AdminOperation;
import ourpoolstats.type.UserType;


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

		if(adminDadshboardService.createUser(tmp)) {
			ManagerDashboard.getInstance().setSigninAdminSuccess(true);
			ManagerDashboard.getInstance().setOptionAdmin(false);
			LanguageService languageService = new LanguageService();
			languageService.setLenguace("italiano", u.getUsername());
			AdminOperationLogger.getInstance().logger(u.getUsername(), true, AdminOperation.INSERTUSER);
			return "ourpoolstats/succes";
		}
		else {
			ManagerDashboard.getInstance().setOptionAdmin(true);
			ManagerDashboard.getInstance().setCreateUser(true);
			ManagerDashboard.getInstance().setSigninAdminSuccess(false);
			AdminOperationLogger.getInstance().logger(u.getUsername(), false, AdminOperation.INSERTUSER);

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
			AdminOperationLogger.getInstance().logger(request.getParameter("username"), true, AdminOperation.DELETE);
			return model;
		}
		else {
			ManagerDashboard.getInstance().setDeleteUserSucces(false);
			ManagerDashboard.getInstance().setOptionAdmin(true);
			AdminOperationLogger.getInstance().logger(request.getParameter("username"), false, AdminOperation.DELETE);
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
			AdminOperationLogger.getInstance().logger(request.getParameter("username"), true, AdminOperation.CHANGETYPE);
			model.setViewName("ourpoolstats/succes");
		}
		else {
			ManagerDashboard.getInstance().setChangeUserSuccess(false);
			ManagerDashboard.getInstance().setOptionAdmin(true);
			AdminOperationLogger.getInstance().logger(request.getParameter("username"), false, AdminOperation.CHANGETYPE);
			model.setViewName("ourpoolstats/error");
		}

		return model;

	}

	@RequestMapping(value = "/logUser", method = RequestMethod.GET)
	public ModelAndView logUser(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		List<UserLog>list=adminDadshboardService.logUser();
		if(list != null) {
			request.setAttribute("userLog", list);
			model.setViewName("ourpoolstats/userOption/userLog");
			AdminOperationLogger.getInstance().logger("", true, AdminOperation.VIEWLOGUSER);
		}
		else {
			AdminOperationLogger.getInstance().logger("", false, AdminOperation.VIEWLOGUSER);
		}
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
		CoinMarketClient getCoin = new CoinMarketClient();
		getCoin.getCoin("Litecoin");
		return model;
	}

}
