package ourpoolstats.api.UserOperation;

import org.springframework.http.ResponseEntity;

import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.GetConnection;

public class DeleteUserExecute {

	public ResponseEntity<Response> deleteUser(String username) {
		Response response = new Response();
		try {
			int row =GetConnection.getInstance().getJdbcTemplate().update(QueryAdminOption.getInstance().getDeleteUser(),username);
			if(row==0) {
				return new ResponseStatus().error(response,username,new Exception(),LogOperation.DELETE);
			}
			return new ResponseStatus().success(response, username,LogOperation.DELETE,null);
		}catch (Exception e) {
			return new ResponseStatus().error(response,username,new Exception(),LogOperation.DELETE);
		}
	}
}
