package ourpoolstats.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.api.UserOperation.LoginExecute;
import ourpoolstats.model.Login;
import ourpoolstats.response.LoginResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<LoginResponse> login(HttpServletRequest request,@RequestParam List<String> login) {
		LoginExecute loginExecute = new LoginExecute();
		Login Username = new Login(login.get(0),login.get(1));
		return loginExecute.login(Username,request);
	}

}
