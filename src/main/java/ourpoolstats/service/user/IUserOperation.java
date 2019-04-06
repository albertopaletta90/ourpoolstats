package ourpoolstats.service.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import ourpoolstats.model.Login;
import ourpoolstats.model.User;
import ourpoolstats.response.Response;
import ourpoolstats.type.UserType;

public interface IUserOperation {
	public boolean signinUser(User u);
	public boolean loginUser(String username,String password);
	ResponseEntity<Response> deleteToUserOnline(String username ,HttpServletRequest request);
	public void insertToUserLogin(Login l);
	public UserType searchUserType(String username);	
	public ResponseEntity<Response> getImageProfile(String username);
	public ResponseEntity<Response>  setImageProfile(String username, String url,String method );
	public ResponseEntity<Response> changePassword(String username, String password,String newPassword);
	public ResponseEntity<Response> changeEmail(String username, String email);
	public ResponseEntity<Response> deleteUser(String user);
	public boolean isFirstLogin(String User);
	public boolean setFirstLogin(String user);
	public boolean isFirstLoginDay(String User);
	public boolean setFirstLoginDay(String user,int value);
}
