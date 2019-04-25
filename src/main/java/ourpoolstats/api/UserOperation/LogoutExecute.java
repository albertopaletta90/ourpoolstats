package ourpoolstats.api.UserOperation;

import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperation;
import ourpoolstats.query.QueryUser;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.SetConnection;

public class LogoutExecute {

	public ResponseEntity<Response> deleteToUserOnline(String username) {
		Response response = new Response();
		CommonOperation userOeration = new CommonOperation();
		try {
			SetConnection.getInstance().getJdbcTemplate().update(QueryUser.getInstance().getDeleteUserOnline(),username);
			userOeration.setFirstLoginDay(username, 1);
			return new ResponseStatus().success(response, username, LogOperation.LOGOUT, null);			
		}catch (Exception e) {
			return new ResponseStatus().error(response, username, e, LogOperation.LOGOUT);
		}

	}
}
