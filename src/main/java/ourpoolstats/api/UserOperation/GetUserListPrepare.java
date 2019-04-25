package ourpoolstats.api.UserOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.UserListMapper;
import ourpoolstats.model.UserList;
import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.response.UserListResponse;
import ourpoolstats.response.status.UserListResponseStatus;
import ourpoolstats.utility.connection.SetConnection;

public class GetUserListPrepare {

	public ResponseEntity<UserListResponse> getUserList(String username){
		UserListResponse userListResponse = new UserListResponse();
		List<UserList>userList = new ArrayList<>();
		try {
			userList = SetConnection.getInstance().getJdbcTemplate().query(QueryAdminOption.getInstance().getGetListUser(), new UserListMapper());
			return new UserListResponseStatus().success(userListResponse,userList,username);
		} catch (Exception e) {
			return new UserListResponseStatus().error(userListResponse,userList,username,e);
		}
	}
	
}
