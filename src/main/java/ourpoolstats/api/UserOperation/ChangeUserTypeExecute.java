package ourpoolstats.api.UserOperation;

import org.springframework.http.ResponseEntity;

import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.SetConnection;

public class ChangeUserTypeExecute {
	
	public ResponseEntity<Response> cangeTypeUser(String userType,String username) {
		Response response = new Response();
		try {
			SetConnection.getInstance().getJdbcTemplate().update(QueryAdminOption.getInstance().getChangeUserType(),userType,username);
			return new ResponseStatus().success(response, username, LogOperation.CHANGETYPE,null);
		}catch (Exception e) {
			return new ResponseStatus().error(response, username, e, LogOperation.CHANGETYPE);
		}
	}
}
