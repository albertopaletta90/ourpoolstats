package ourpoolstats.response.status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperationCoin;
import ourpoolstats.log.LoginSigninLogger;
import ourpoolstats.log.OperationDBLogger;
import ourpoolstats.response.LogResponse;
import ourpoolstats.response.LoginResponse;
import ourpoolstats.type.DataBaseOperation;

public class LoginResponseStatus {

	CommonOperationCoin commonOperationCoin = new CommonOperationCoin();
	
	public ResponseEntity<LoginResponse> success(LoginResponse loginResponse,LogResponse logResponse,String userType,HttpStatus status) {
		commonOperationCoin.setCoin();
		loginResponse.setStatus(status.toString());
		loginResponse.setTypeUser(userType);	
		return new   ResponseEntity<LoginResponse>(loginResponse, status);

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
