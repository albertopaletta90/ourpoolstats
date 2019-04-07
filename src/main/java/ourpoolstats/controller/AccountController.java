package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.response.Response;
import ourpoolstats.service.user.UserOperration;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AccountController {
	
	@RequestMapping(value = "/addImage/{url}", method = RequestMethod.POST)
	public ResponseEntity<Response> addImage(HttpServletRequest request,@PathVariable("url") String url){
		String username = (String) request.getSession().getAttribute("username");
		return new UserOperration().setImageProfile(username, url,"update");
	}

	@RequestMapping(value = "/getImage/{username}", method = RequestMethod.POST)
	public ResponseEntity<Response> getImage(HttpServletRequest request,@PathVariable("username") String username){
		return new UserOperration().getImageProfile(username);
	}

	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<Response> logout(HttpServletRequest request){
		String username = (String) request.getSession().getAttribute("username");
		return new UserOperration().deleteToUserOnline(username,request);
	}


	@RequestMapping(value = "/changePassword/{username}/password{password}/newPassword{newPassword}", method = RequestMethod.POST)
	public  ResponseEntity<Response> changePassword(HttpServletRequest request,@PathVariable("username")String username,@PathVariable("password")String password,@PathVariable("newPassword")String newPassword){
		return new UserOperration().changePassword(username, password,newPassword);
	}

	@RequestMapping(value = "/changeEmail/{username}/email/{email}", method = RequestMethod.POST)
	public ResponseEntity<Response> changeEmail(HttpServletRequest request,@PathVariable("username")String username,@PathVariable("email")String email){
		return new UserOperration().changeEmail(username, email);
	}

	@RequestMapping(value = "/deleteUserAction", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteUser(HttpServletRequest request) {
		String username = (String)request.getSession().getAttribute("username");
		return new UserOperration().deleteUser(username);
	}


}
