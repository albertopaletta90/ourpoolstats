package ourpoolstats.response;

import java.util.List;

public class UserOnlineResponse {
	
	private String status;
	private String error;
	private List<String>user;
	
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
	public List<String> getData() {
		return user;
	}
	public void setUserOnline(List<String> userOnline) {
		this.user = userOnline;
	}
}
