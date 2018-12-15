package ourpoolstats.model;

import java.util.Date;

public class UserLog {
	
	private int userLogId;
	private String username;
	private Date dateLogin;

	public UserLog() {
	}

	public int getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(int userLogId) {
		this.userLogId = userLogId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateLogin() {
		return dateLogin;
	}

	public void setDateLogin(Date dateLogin) {
		this.dateLogin = dateLogin;
	}

	
}
