package ourpoolstats.response;

import java.util.List;

import ourpoolstats.model.UserList;

public class UserListResponse {

	private String status;
	private String error;
	private List<UserList>userList;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<UserList> getUserList() {
		return userList;
	}
	public void setUserList(List<UserList> userList) {
		this.userList = userList;
	}
	
	
}
