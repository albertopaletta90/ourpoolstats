package ourpoolstats.api.UserOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.StringMapper;
import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.response.UserOnlineResponse;
import ourpoolstats.response.status.UserOnlineResponseStatus;
import ourpoolstats.utility.connection.GetConnection;

public class GetUserOnlinePrepare {

	public ResponseEntity<UserOnlineResponse> userOnline(String username) {
		List<String>list = new ArrayList<>();
		list = GetConnection.getInstance().getJdbcTemplate().query(QueryAdminOption.getInstance().getUserOnline(), new StringMapper(),username);
		UserOnlineResponse userOnlineResponse = new UserOnlineResponse();
		if(list!=null) {
			return new UserOnlineResponseStatus().success(userOnlineResponse, username, list);
		}else {
			return new UserOnlineResponseStatus().error(userOnlineResponse,username,list);
		}
	}


}
