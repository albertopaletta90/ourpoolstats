package ourpoolstats.api.UserOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.UserLoginMapper;
import ourpoolstats.model.User;
import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.response.UserOnlineResponse;
import ourpoolstats.response.status.UserOnlineResponseStatus;
import ourpoolstats.utility.connection.SetConnection;

public class GetUserOnlinePrepare {

	public ResponseEntity<UserOnlineResponse> userOnline(String username) {
		List<User>list = new ArrayList<>();
		list = SetConnection.getInstance().getJdbcTemplate().query(QueryAdminOption.getInstance().getUserOnline(), new UserLoginMapper(),username);
		UserOnlineResponse userOnlineResponse = new UserOnlineResponse();
		if(list!=null) {
			return new UserOnlineResponseStatus().success(userOnlineResponse,username,list);
		}else {
			return new UserOnlineResponseStatus().error(userOnlineResponse,username,list);
		}
	}


}
