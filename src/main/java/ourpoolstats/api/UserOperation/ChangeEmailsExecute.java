package ourpoolstats.api.UserOperation;

import org.springframework.http.ResponseEntity;

import ourpoolstats.query.QueryUser;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.SetConnection;

public class ChangeEmailsExecute {	

	public ResponseEntity<Response> changeEmail(String username, String email) {
		Response response = new Response();
		try {
			SetConnection.getInstance().getJdbcTemplate().update(QueryUser.getInstance().getChangeEmail(),email,username);
			return new ResponseStatus().success(response, username, LogOperation.CHANGEEMAIL, null);
		} catch (Exception e) {
			return new ResponseStatus().error(response, username, e, LogOperation.CHANGEEMAIL);
		}

	}


}
