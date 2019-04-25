package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.log.AdminOperationLogger;
import ourpoolstats.model.UserLog;
import ourpoolstats.response.LogUserResponse;
import ourpoolstats.type.LogOperation;

public class UserLogResponseStatus {

	public ResponseEntity<LogUserResponse> succesLog(LogUserResponse logUserResponse, List<UserLog> list,String username) {
		AdminOperationLogger.getInstance().logger(username, true, LogOperation.VIEWLOGUSER);
		logUserResponse.setStatus(HttpStatus.OK.toString());
		logUserResponse.setUserLog(list);
		return new  ResponseEntity<LogUserResponse>(logUserResponse, HttpStatus.OK);
	}
	
	public ResponseEntity<LogUserResponse> notFoundLog(LogUserResponse logUserResponse, List<UserLog> list,String username) {
		AdminOperationLogger.getInstance().logger("", false, LogOperation.VIEWLOGUSER);
		logUserResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		logUserResponse.setUserLog(list);
		return new  ResponseEntity<LogUserResponse>(logUserResponse, HttpStatus.NOT_FOUND);
	}

}
