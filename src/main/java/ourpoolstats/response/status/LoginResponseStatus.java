package ourpoolstats.response.status;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperationCoin;
import ourpoolstats.log.LoginSigninLogger;
import ourpoolstats.log.OperationDBLogger;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.response.LogResponse;
import ourpoolstats.response.LoginResponse;
import ourpoolstats.type.DataBaseOperation;

public class LoginResponseStatus {

	CommonOperationCoin commonOperationCoin = new CommonOperationCoin();
	
	public ResponseEntity<LoginResponse> success(LoginResponse loginResponse,LogResponse logResponse,String userType,HttpStatus status) {
		setCoin(logResponse);
		loginResponse.setStatus(status.toString());
		loginResponse.setTypeUser(userType);	
		return new   ResponseEntity<LoginResponse>(loginResponse, status);

	}

	public void setCoin(LogResponse logResponse) {	
		List<String>listDefault = new ArrayList<String>();
		listDefault = commonOperationCoin.getListCoinDefault();
		ManagerCoin.getInstance().setMoneyListCoinGeko(listDefault);
		ManagerCoin.getInstance().setMoneyListCoinMarket(listDefault);
		commonOperationCoin.setListCoinDB(ManagerCoin.getInstance().getGetCoin().getList());
		ManagerCoin.getInstance().setListCoin(commonOperationCoin.getListDB());
		ManagerCoin.getInstance().setCoingekoCoin(commonOperationCoin.getListCoinGeko());
		OperationDBLogger.getInstance().logger("", true, DataBaseOperation.GETLISTCOIN);
	}

	public ResponseEntity<LoginResponse> notFound(LoginResponse loginResponse) {
		OperationDBLogger.getInstance().logger("", false, DataBaseOperation.GETLISTCOIN);
		loginResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		return new   ResponseEntity<LoginResponse>(loginResponse, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<LoginResponse> error(LoginResponse loginResponse,String usermname) {
		LoginSigninLogger.getInstance().logger(usermname,false);
		loginResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new  ResponseEntity<LoginResponse>(loginResponse, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
}
