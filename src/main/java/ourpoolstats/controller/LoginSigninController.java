package ourpoolstats.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oupoolstats.api.coinmarket.GetCoin;
import oupoolstats.service.coin.CoinMarketService;
import oupoolstats.service.user.UserOperration;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.manager.ManagerDashboard;
import ourpoolstats.manager.ManagerHome;
import ourpoolstats.manager.ManagerLoginSignin;
import ourpoolstats.model.Login;
import ourpoolstats.model.User;
import ourpoolstats.myenum.CryptoCurrency;

@Controller
public class LoginSigninController {

	private UserOperration userOperration = new UserOperration();
	private GetCoin getCoin = new GetCoin();
	private CoinMarketService coinService = new CoinMarketService();
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("SpringWeb")Login l,ModelMap model,HttpServletRequest request) {
		model.addAttribute("username", l.getUsername());
		model.addAttribute("password", l.getPassword());
		ManagerLoginSignin.getInstance().setErrorLogin(false);
		Login login = new Login();
		login.setAllParameter(model);
		if(userOperration.loginUser(login.getUsername(), login.getPassword())) {
			ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.COINMARKET);

			if(ManagerLoginSignin.getInstance().isFirstLogin()) {
				ManagerLoginSignin.getInstance().setFirstLogin(false);
				userOperration.insertToUserLogin(login);
				userOperration.insertToUserOnline(login);
			}
			ManagerHome.getInstance().setLogin(false);
			ManagerHome.getInstance().setNews(true);
			String userType = userOperration.searchUserType(login.getUsername()).toString();
			request.getSession().setAttribute("userType", userType);
			request.getSession().setAttribute("username", login.getUsername());
			try {
				List<String>coinList = coinService.getListCoinDefault();
				if(!coinList.isEmpty()) {
					coinList.clear();
					getCoin.deleteList();
					coinList = coinService.getListCoinDefault();
				}
				for (String element : coinList) {
					getCoin.getCoin(element);
				}

				 ManagerDashboard.getInstance().setListCoin(getCoin.getList());
				
			}
			catch (Exception e) {
				return "ourPoolStats/withOutInternet";
			}
			return "/ourpoolstats/ourpoolstats";
		}
		else {
			ManagerLoginSignin.getInstance().setErrorLogin(true);
			return "/home/index";
		}

	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String creaUtente(@ModelAttribute("SpringWeb")User u,ModelMap model,HttpServletRequest request) {
		model.addAttribute("userId", u.getUserId());
		model.addAttribute("userName", u.getUserName());
		model.addAttribute("userSurname", u.getUserSurname());
		model.addAttribute("username",u.getUsername());
		model.addAttribute("password",u.getPassword());
		model.addAttribute("email",u.getEmail());
		model.addAttribute("userType",u.getUserType());
		User tmp = new User();
		tmp.setAllParameter(model);

		if(userOperration.signinUser(tmp)) {
			ManagerLoginSignin.getInstance().setErrorRegistration(false);
			return "/home/succes";
		}
		else {
			ManagerHome.getInstance().setLogin(false);
			ManagerHome.getInstance().setSignin(true);
			ManagerLoginSignin.getInstance().setErrorRegistration(true);
			return "/home/error";
		}
	}
}
