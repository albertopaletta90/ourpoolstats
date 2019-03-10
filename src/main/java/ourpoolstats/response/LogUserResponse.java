package ourpoolstats.response;

import java.util.List;

import ourpoolstats.model.UserLog;

public class LogUserResponse {
	private String status;
	private String error;
	private List<UserLog>userLog;
	
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
	public List<UserLog> getUserLog() {
		return userLog;
	}
	public void setUserLog(List<UserLog> userLog) {
		this.userLog = userLog;
	}

}
