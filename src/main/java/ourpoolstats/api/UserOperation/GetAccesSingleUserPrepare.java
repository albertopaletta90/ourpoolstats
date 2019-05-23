package ourpoolstats.api.UserOperation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.UserLogMapper;
import ourpoolstats.model.UserLog;
import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.response.LogUserResponse;
import ourpoolstats.response.status.UserLogResponseStatus;
import ourpoolstats.utility.connection.GetConnection;

public class GetAccesSingleUserPrepare {

	public ResponseEntity<LogUserResponse> logSingleUser(String username) {
		List<UserLog>list = GetConnection.getInstance().getJdbcTemplate().query(QueryAdminOption.getInstance().getUserSingleLog(), new UserLogMapper(),username);
		LogUserResponse logUserResponse = new LogUserResponse();
		if(list != null) {
			return new UserLogResponseStatus().succesLog(logUserResponse,list,username);
		}
		else {
			return new UserLogResponseStatus().notFoundLog(logUserResponse,list,username);
		}
	}
}
