package ourpoolstats.model;

import org.springframework.ui.ModelMap;

import ourpoolstats.type.UserType;

public class Login {
	
	private String username;
	private String password;
	private UserType userType;
	
	public Login() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setAllParameter(ModelMap model) {
		this.username = (String) model.get("username");
		this.password = (String) model.get("password");
		this.userType = (UserType) model.get("userType");
		
	}
	
	

}
