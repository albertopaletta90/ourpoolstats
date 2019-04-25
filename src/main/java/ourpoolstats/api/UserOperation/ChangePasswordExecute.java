package ourpoolstats.api.UserOperation;

import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperation;
import ourpoolstats.mapper.StringMapper;
import ourpoolstats.query.QueryUser;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.SetConnection;

public class ChangePasswordExecute {

	

	public ResponseEntity<Response> changePassword(String username, String password,String newPassword) {
		Response response = new Response();
		CommonOperation userOperration = new CommonOperation();
		if(userOperration.searchUserWithPassword(username, password)) {
			try {
				newPassword = SetConnection.getInstance().getJdbcTemplate().query(QueryUser.getInstance().getHashPassword(), new StringMapper(),password).get(0);
				SetConnection.getInstance().getJdbcTemplate().update(QueryUser.getInstance().getChangePassword(),newPassword,username);
				return new ResponseStatus().success(response, username, LogOperation.CHANGEPASSWORD, null);
			} catch (Exception e) {
				return new ResponseStatus().error(response, username, e, LogOperation.CHANGEPASSWORD);
			}

		}else {
			return new ResponseStatus().notFound(response, username, LogOperation.CHANGEPASSWORD,"Utente Non Trovato");
		}

	}

}
