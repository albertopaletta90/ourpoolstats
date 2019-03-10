package ourpoolstats.response;

public class LoginResponse {
	
	private String status;
	private String typeUser;
	private LogResponse log;

	public LoginResponse() {
	}

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public LogResponse getLog() {
		return log;
	}

	public void setLog(LogResponse log) {
		this.log = log;
	}

	
	


	
	
}
