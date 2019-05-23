package ourpoolstats.api.UserOperation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.UserLogMapper;
import ourpoolstats.model.UserLog;
import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.response.LogUserResponse;
import ourpoolstats.response.status.UserLogResponseStatus;
import ourpoolstats.utility.connection.GetConnection;

public class GetAccessAllUserPrapare {

	public ResponseEntity<LogUserResponse> logUser() {
		List<UserLog>list = GetConnection.getInstance().getJdbcTemplate().query(QueryAdminOption.getInstance().getUserLog(), new UserLogMapper());
		LogUserResponse logUserResponse = new LogUserResponse();
		if(list != null) {
			return new UserLogResponseStatus().succesLog(logUserResponse,list,"");
		}
		else {
			return new UserLogResponseStatus().succesLog(logUserResponse,list,"");
		}
	}

}
