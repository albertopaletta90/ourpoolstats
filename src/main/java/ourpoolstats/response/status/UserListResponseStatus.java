package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.model.UserList;
import ourpoolstats.response.UserListResponse;

public class UserListResponseStatus {

	public ResponseEntity<UserListResponse> success(UserListResponse userListResponse, List<UserList> userList,String username) {
		userListResponse.setStatus(HttpStatus.OK.toString());
		userListResponse.setUserList(userList);
		return new ResponseEntity<UserListResponse>(userListResponse,HttpStatus.OK);
	}

	public ResponseEntity<UserListResponse> error(UserListResponse userListResponse, List<UserList> userList,String username,Exception e) {
		userListResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		userListResponse.setError(e.getMessage());
		userListResponse.setUserList(userList);
		return new ResponseEntity<UserListResponse>(userListResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
