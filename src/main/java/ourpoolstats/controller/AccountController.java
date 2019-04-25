package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.api.UserOperation.ChangeEmailsExecute;
import ourpoolstats.api.UserOperation.ChangePasswordExecute;
import ourpoolstats.api.UserOperation.ImageProfileExecute;
import ourpoolstats.api.UserOperation.ImageProfilePrepare;
import ourpoolstats.api.UserOperation.LogoutExecute;
import ourpoolstats.response.Response;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AccountController {
	
	@RequestMapping(value = "/addImage/{url}/username/{username}", method = RequestMethod.POST)
	public ResponseEntity<Response> addImage(HttpServletRequest request,@PathVariable("url") String url,@PathVariable("username") String username){
		return new ImageProfileExecute().setImageProfile(username, url,"update");
	}

	@RequestMapping(value = "/getImage/{username}", method = RequestMethod.POST)
	public ResponseEntity<Response> getImage(HttpServletRequest request,@PathVariable("username") String username){
		return new ImageProfilePrepare().getImageProfile(username);
	}

	
	
	@RequestMapping(value = "/logout/{username}", method = RequestMethod.GET)
	public ResponseEntity<Response> logout(@PathVariable("username") String username){
		return new LogoutExecute().deleteToUserOnline(username);
	}


	@RequestMapping(value = "/changePassword/{username}/password{password}/newPassword{newPassword}", method = RequestMethod.POST)
	public  ResponseEntity<Response> changePassword(HttpServletRequest request,@PathVariable("username")String username,@PathVariable("password")String password,@PathVariable("newPassword")String newPassword){
		return new ChangePasswordExecute().changePassword(username, password,newPassword);
	}

	@RequestMapping(value = "/changeEmail/{username}/email/{email}", method = RequestMethod.POST)
	public ResponseEntity<Response> changeEmail(HttpServletRequest request,@PathVariable("username")String username,@PathVariable("email")String email){
		return new ChangeEmailsExecute().changeEmail(username, email);
	}

}
