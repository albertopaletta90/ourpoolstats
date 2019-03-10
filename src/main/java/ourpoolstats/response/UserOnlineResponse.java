package ourpoolstats.response;

import java.util.List;

import ourpoolstats.model.User;

public class UserOnlineResponse {
	
	private String status;
	private String error;
	private List<User>user;
	
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
	public List<User> getUserLog() {
		return user;
	}
	public void setUserLog(List<User> userLog) {
		this.user = userLog;
	}
}
