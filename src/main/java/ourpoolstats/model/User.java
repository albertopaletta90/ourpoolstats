package ourpoolstats.model;

import java.io.Serializable;

import org.springframework.ui.ModelMap;

import ourpoolstats.type.UserType;

public class User implements Serializable {

	private static final long serialVersionUID = -938401502965749385L;

	private int userId;
	private String userName;
	private String userSurname;
	private String username;
	private String password;
	private String email;
	private UserType userType;

	public User() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setAllParameter(ModelMap model) {
		//this.userId = (int) model.get("userId");
		this.userName = (String) model.get("userName");
		this.userSurname = (String) model.get("userSurname");
		this.email = (String) model.get("email");
		this.username = (String) model.get("username");
		this.password = (String) model.get("password");
		this.userType = (UserType) model.get("userType");
	}


}
