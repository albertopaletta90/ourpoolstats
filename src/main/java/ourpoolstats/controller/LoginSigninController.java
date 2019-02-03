package ourpoolstats.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oupoolstats.service.coin.CoinGekoService;
import oupoolstats.service.language.LanguageService;
import ourpoolstats.log.LoginSigninLogger;
import ourpoolstats.log.OperationDBLogger;
import ourpoolstats.manager.ManagerAccount;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.manager.ManagerDashboard;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.manager.ManagerLoginSignin;
import ourpoolstats.model.Login;
import ourpoolstats.multilingual.MultiLilingualDashboardController;
import ourpoolstats.type.CryptoCurrency;
import ourpoolstats.type.DataBaseOperation;
import ourpoolstats.type.LenguageType;

@Controller
public class LoginSigninController {

	private LanguageService languageService = new LanguageService();
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("SpringWeb")Login l,ModelMap model,HttpServletRequest request) {
		model.addAttribute("username", l.getUsername());
		model.addAttribute("password", l.getPassword());
		ManagerLoginSignin.getInstance().setErrorLogin(false);
		l.setAllParameter(model);
		
		if(ManagerAccount.getInstance().getInstance().getUserOperration().loginUser(l.getUsername(), l.getPassword())) {
			String userType = ManagerAccount.getInstance().getUserOperration().searchUserType(l.getUsername()).toString();
			request.getSession().setAttribute("userType", userType);
			request.getSession().setAttribute("username", l.getUsername());
			ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.COINMARKET);
			LoginSigninLogger.getInstance().logger(l.getUsername(),true);

			if(ManagerAccount.getInstance().getUserOperration().isFirstLoginDay(l.getUsername())) {
				ManagerAccount.getInstance().getUserOperration().setFirstLoginDay(l.getUsername(), 0);
				ManagerAccount.getInstance().getUserOperration().insertToUserLogin(l);
				ManagerAccount.getInstance().getUserOperration().insertToUserOnline(l);
				OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTLOGUSER);
			}else {
				OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTLOGUSER);
			}

			if(ManagerAccount.getInstance().getUserOperration().isFirstLogin(l.getUsername())){
				ManagerAccount.getInstance().getUserOperration().setFirstLogin(l.getUsername());
				try {
					ManagerAccount.getInstance().getUserOperration().setImageProfile(l.getUsername(), ManagerImage.getInstance().getLinkImageProfile(), "insert");
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTIMAGEPROFILE);
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTLOGUSER);
				} catch (Exception e) {
					e.printStackTrace();
					OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTIMAGEPROFILE);
					OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTLOGUSER);
				}

				try {
					languageService.insertLenguace(l.getUsername(), "italiano");
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTLANGUAGE);
				} catch (Exception e) {
					e.printStackTrace();
					OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTLANGUAGE);
				}

				return "ourpoolstats/userOption/setPassword";
			}else{
				ManagerImage.getInstance().setLinkImageProfile(ManagerAccount.getInstance().getUserOperration().getImageProfile(l.getUsername()));
				if(languageService.getLenguace(l.getUsername())==LenguageType.ITALIAN) {
					MultiLilingualDashboardController.getInstance().setLenguageItalian();
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.UPDATELANGUAGE);

				}else {
					MultiLilingualDashboardController.getInstance().setLenguageEnglish();
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.UPDATELANGUAGE);
				}
				try {
					ManagerCoin.getInstance().setCoinListDefault(ManagerCoin.getInstance().getCoinService().getListCoinDefault());

					if(!ManagerCoin.getInstance().getCoinListDefault().isEmpty()) {
						ManagerCoin.getInstance().getCoinListDefault().clear();
						ManagerCoin.getInstance().getGetCoin().deleteList();
						ManagerCoin.getInstance().setCoinListDefault(ManagerCoin.getInstance().getCoinService().getListCoinDefault());
					}

					ManagerCoin.getInstance().setMoneyListCoinGeko();
					ManagerCoin.getInstance().setMoneyListCoinMarket();
					ManagerDashboard.getInstance().setListCoin(ManagerCoin.getInstance().getGetCoin().getList());//controllare
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
			LoginSigninLogger.getInstance().logger(l.getUsername(),false);
			ManagerLoginSignin.getInstance().setErrorLogin(true);
			return "/home/index";
		}

	}

}
