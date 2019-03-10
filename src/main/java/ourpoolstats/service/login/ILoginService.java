package ourpoolstats.service.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import ourpoolstats.model.Login;
import ourpoolstats.response.LoginResponse;

public interface ILoginService {
	
	public ResponseEntity<LoginResponse>login(Login l,HttpServletRequest request);

}
