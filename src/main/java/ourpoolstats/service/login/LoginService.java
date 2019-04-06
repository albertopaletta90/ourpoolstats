package ourpoolstats.service.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.log.LoginSigninLogger;
import ourpoolstats.log.OperationDBLogger;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.manager.ManagerDashboard;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard;
import ourpoolstats.model.Login;
import ourpoolstats.response.LogResponse;
import ourpoolstats.response.LoginResponse;
import ourpoolstats.service.coin.CoinGekoService;
import ourpoolstats.service.language.LanguageService;
import ourpoolstats.service.user.UserOperration;
import ourpoolstats.type.CryptoCurrency;
import ourpoolstats.type.DataBaseOperation;
import ourpoolstats.type.LenguageType;
import ourpoolstats.utility.GetConnection;

public class LoginService implements ILoginService{

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;
	private static final int LoginResponse = 0;
	private LanguageService languageService = new LanguageService();
	private LoginResponse loginResponse = new LoginResponse();
	private LogResponse logResponse = new LogResponse();

	public LoginService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}

	@Override
	public ResponseEntity<LoginResponse> login(Login l, HttpServletRequest request) {
		UserOperration userOperation = new UserOperration();
		
	
		if(userOperation.loginUser(l.getUsername(), l.getPassword())) {
			String userType = new UserOperration().searchUserType(l.getUsername()).toString();
			request.getSession().setAttribute("userType", userType);
			request.getSession().setAttribute("username",l.getUsername());
			ManagerCoin.getInstance().setCryptoCurrency(CryptoCurrency.COINMARKET);
			LoginSigninLogger.getInstance().logger(l.getUsername(),true,logResponse);

			if(userOperation.isFirstLoginDay(l.getUsername())) {
				userOperation.setFirstLoginDay(l.getUsername(), 0);
				userOperation.insertToUserLogin(l);
				userOperation.insertToUserOnline(l);
				OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTLOGUSER,logResponse);
			}else {
				OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTLOGUSER,logResponse);
			}

			if(userOperation.isFirstLogin(l.getUsername())){
				userOperation.setFirstLogin(l.getUsername());
				try {
					userOperation.setImageProfile(l.getUsername(), ManagerImage.getInstance().getLinkImageProfile(), "insert");
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTIMAGEPROFILE,logResponse);
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTLOGUSER,logResponse);
				} catch (Exception e) {
					e.printStackTrace();
					OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTIMAGEPROFILE,logResponse);
					OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTLOGUSER,logResponse);
				}

				try {
					languageService.insertLenguace(l.getUsername(), "italiano");
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTLANGUAGE,logResponse);
				} catch (Exception e) {
					e.printStackTrace();
					OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTLANGUAGE,logResponse);
				}
				setCoin();
				return success(userType, HttpStatus.CREATED);
				
				}else{
				if(languageService.getLenguace(l.getUsername())==LenguageType.ITALIAN) {
					ManagerMultiLilingualDashboard.getInstance().setLenguageItalian();
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.UPDATELANGUAGE,logResponse);

				}else {
					ManagerMultiLilingualDashboard.getInstance().setLenguageEnglish();
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.UPDATELANGUAGE,logResponse);
				}
				try {
					setCoin();		
					return success(userType,HttpStatus.OK);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					OperationDBLogger.getInstance().logger("", false, DataBaseOperation.GETLISTCOIN,logResponse);
					loginResponse.setStatus(HttpStatus.NOT_FOUND.toString());
					return new   ResponseEntity<LoginResponse>(loginResponse, HttpStatus.NOT_FOUND);
				}
				
			}


		}
		else {
			LoginSigninLogger.getInstance().logger(l.getUsername(),false,logResponse);
			loginResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new  ResponseEntity<LoginResponse>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}

	private ResponseEntity<LoginResponse> success(String userType,HttpStatus status) {
		loginResponse.setStatus(status.toString());
		loginResponse.setTypeUser(userType);
		logResponse.setLog(ManagerDashboard.getInstance().getLog());
		loginResponse.setLog(logResponse);				
		return new   ResponseEntity<LoginResponse>(loginResponse, status);
		
	}
	
	private void setCoin() {
		CoinGekoService coinGekoService = new CoinGekoService();
		List<String>listDefault = new ArrayList<String>();
		listDefault = ManagerCoin.getInstance().getCoinService().getListCoinDefault();


		ManagerCoin.getInstance().setMoneyListCoinGeko(listDefault);
		ManagerCoin.getInstance().setMoneyListCoinMarket(listDefault);
		ManagerCoin.getInstance().getCoinService().setListCoinDB(ManagerCoin.getInstance().getGetCoin().getList());
		ManagerCoin.getInstance().setListCoin(ManagerCoin.getInstance().getCoinService().getListDB());
		ManagerCoin.getInstance().setCoingekoCoin(coinGekoService.getList());
		OperationDBLogger.getInstance().logger("", true, DataBaseOperation.GETLISTCOIN,logResponse);
	}
}




