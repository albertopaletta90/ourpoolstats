package ourpoolstats.api.UserOperation;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.StringMapper;
import ourpoolstats.model.User;
import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.query.QueryUser;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.SetConnection;

public class CreateUserExecute{

	public ResponseEntity<Response> createUser(User user) {
		Response response = new Response();
		String hashPswword = SetConnection.getInstance().getJdbcTemplate().query(QueryUser.getInstance().getHashPassword(), new StringMapper(),user.getPassword()).get(0);
		String userType = "USER";
		try {
			SetConnection.getInstance().getJdbcTemplate().update(QueryAdminOption.getInstance().getInsertUserAdmin(),user.getUserName(),user.getUserSurname(),user.getEmail(),user.getUsername(),hashPswword,userType);
			SetConnection.getInstance().getJdbcTemplate().update(QueryAdminOption.getInstance().getInsertToImageProfile(),user.getUsername());
			SetConnection.getInstance().getJdbcTemplate().update(QueryAdminOption.getInstance().getInsertTouserOnline(),user.getUsername());
		}catch (Exception e) {
			return new ResponseStatus().error(response, user.getUsername(), e, LogOperation.INSERTUSER);
		}
		return new ResponseStatus().success(response, user.getUsername(), LogOperation.INSERTUSER,null);
	}

}
