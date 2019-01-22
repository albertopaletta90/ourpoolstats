package ourpoolstats.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oupoolstats.api.coingeko.CoinGekoClient;
import oupoolstats.api.coinmarket.CoinMarketClient;
import oupoolstats.service.coin.CoinGekoService;
import oupoolstats.service.coin.CoinMarketService;
import oupoolstats.service.coin.CryptopiaService;
import oupoolstats.service.language.LanguageService;
import oupoolstats.service.user.UserOperration;
import ourpoolstats.log.LoginSigninLogger;
import ourpoolstats.log.OperationDBLogger;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.manager.ManagerDashboard;
import ourpoolstats.manager.ManagerHome;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.manager.ManagerLoginSignin;
import ourpoolstats.model.Login;
import ourpoolstats.model.User;
import ourpoolstats.multilingual.MultiLilingualDashboardController;
import ourpoolstats.myenum.CryptoCurrency;
import ourpoolstats.myenum.DataBaseOperation;
import ourpoolstats.myenum.LenguageType;

@Controller
public class LoginSigninController {

	private UserOperration userOperration = new UserOperration();
	private CoinMarketClient getCoin = new CoinMarketClient();
	private CoinMarketService coinService = new CoinMarketService();
	private LanguageService languageService = new LanguageService();

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("SpringWeb")Login l,ModelMap model,HttpServletRequest request) {
		model.addAttribute("username", l.getUsername());
		model.addAttribute("password", l.getPassword());
		ManagerLoginSignin.getInstance().setErrorLogin(false);
		Login login = new Login();
		login.setAllParameter(model);
		if(userOperration.loginUser(login.getUsername(), login.getPassword())) {
			String userType = userOperration.searchUserType(login.getUsername()).toString();
			request.getSession().setAttribute("userType", userType);
			request.getSession().setAttribute("username", login.getUsername());
			ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.COINMARKET);
			LoginSigninLogger.getInstance().logger(login.getUsername(),true);

			if(userOperration.isFirstLoginDay(login.getUsername())) {
				userOperration.setFirstLoginDay(login.getUsername(), 0);
				userOperration.insertToUserLogin(login);
				userOperration.insertToUserOnline(login);
				OperationDBLogger.getInstance().logger(login.getUsername(), true, DataBaseOperation.INSERTLOGUSER);
			}else {
				OperationDBLogger.getInstance().logger(login.getUsername(), false, DataBaseOperation.INSERTLOGUSER);
			}

			if(userOperration.isFirstLogin(l.getUsername())){
				userOperration.setFirstLogin(l.getUsername());
				try {
					userOperration.setImageProfile(l.getUsername(), ManagerImage.getInstance().getLinkImageProfile(), "insert");
					OperationDBLogger.getInstance().logger(login.getUsername(), true, DataBaseOperation.INSERTIMAGEPROFILE);
					OperationDBLogger.getInstance().logger(login.getUsername(), true, DataBaseOperation.INSERTLOGUSER);
				} catch (Exception e) {
					e.printStackTrace();
					OperationDBLogger.getInstance().logger(login.getUsername(), false, DataBaseOperation.INSERTIMAGEPROFILE);
					OperationDBLogger.getInstance().logger(login.getUsername(), false, DataBaseOperation.INSERTLOGUSER);
				}

				try {
					languageService.insertLenguace(l.getUsername(), "italiano");
					OperationDBLogger.getInstance().logger(login.getUsername(), true, DataBaseOperation.INSERTLANGUAGE);
				} catch (Exception e) {
					e.printStackTrace();
					OperationDBLogger.getInstance().logger(login.getUsername(), false, DataBaseOperation.INSERTLANGUAGE);
				}

				return "ourpoolstats/userOption/setPassword";
			}else{
				ManagerImage.getInstance().setLinkImageProfile(userOperration.getImageProfile(l.getUsername()));
				if(languageService.getLenguace(l.getUsername())==LenguageType.ITALIAN) {
					MultiLilingualDashboardController.getInstance().setLenguageItalian();
					OperationDBLogger.getInstance().logger(login.getUsername(), true, DataBaseOperation.UPDATELANGUAGE);

				}else {
					MultiLilingualDashboardController.getInstance().setLenguageEnglish();
					OperationDBLogger.getInstance().logger(login.getUsername(), true, DataBaseOperation.UPDATELANGUAGE);
				}


				//			try {
				//				ManagerCoin.getInstance().setCryptopiaCoin(CryptopiaService.getInstance().initCoin());
				//			}catch (Exception e) {
				//				return "ourpoolstats/withOutInternet";
				//			}


				try {
					List<String>coinList = coinService.getListCoinDefault();

					if(!coinList.isEmpty()) {
						coinList.clear();
						getCoin.deleteList();
						coinList = coinService.getListCoinDefault();

					}

					for (String element : coinList) {
						getCoin.getCoin(element);
						CoinGekoClient.GetInstance().getMarket(element);

					}

					ManagerDashboard.getInstance().setListCoin(getCoin.getList());
					ManagerCoin.getInstance().setCoingekoCoin(CoinGekoService.getInstance().getList());
					OperationDBLogger.getInstance().logger("", true, DataBaseOperation.GETLISTCOIN);
				}
				catch (Exception e) {
					OperationDBLogger.getInstance().logger("", false, DataBaseOperation.GETLISTCOIN);
					return "ourPoolStats/withOutInternet";
				}
				return "/ourpoolstats/ourpoolstats";
			}


		}
		else {
			LoginSigninLogger.getInstance().logger(login.getUsername(),false);
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
