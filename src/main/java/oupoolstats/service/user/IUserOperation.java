package oupoolstats.service.user;

import ourpoolstats.model.Login;
import ourpoolstats.model.User;
import ourpoolstats.type.UserType;

public interface IUserOperation {
	public boolean signinUser(User u);
	public boolean loginUser(String username,String password);
	
	public void insertToUserLogin(Login l);
	public UserType searchUserType(String username);	
	public boolean forgotPassword(String username);	
	public String getImageProfile(String username);
	public boolean setImageProfile(String username, String url,String method );
	public boolean changePassword(String username, String password);
	public boolean changeEmail(String username, String email);
	public boolean deleteUser(String user);
	public boolean isFirstLogin(String User);
	public boolean setFirstLogin(String user);
	public boolean isFirstLoginDay(String User);
	public boolean setFirstLoginDay(String user,int value);
}
