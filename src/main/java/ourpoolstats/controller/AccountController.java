package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ourpoolstats.response.Response;
import ourpoolstats.service.user.UserOperration;




@Controller
public class AccountController {
	
	@RequestMapping(value = "/addImage/{url}", method = RequestMethod.POST)
	public ResponseEntity<Response> addImage(HttpServletRequest request,@PathVariable("url") String url){
		String username = (String) request.getSession().getAttribute("username");
		return new UserOperration().setImageProfile(username, url,"update");
	}

	@RequestMapping(value = "/getImage/{username}", method = RequestMethod.POST)
	public String getImage(HttpServletRequest request,@PathVariable("username") String username){
		return new UserOperration().getImageProfile(username);
	}

	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<Response> logout(HttpServletRequest request){
		String username = (String) request.getSession().getAttribute("username");
		return new UserOperration().deleteToUserOnline(username,request);
	}


	@RequestMapping(value = "/changePassword/{username}/password{password}", method = RequestMethod.POST)
	public  ResponseEntity<Response> changePassword(HttpServletRequest request,@PathVariable("username")String username,@PathVariable("password")String password){
		return new UserOperration().changePassword(username, password);
	}

	@RequestMapping(value = "/changeEmail/{username}/email{email}", method = RequestMethod.POST)
	public ResponseEntity<Response> changeEmail(HttpServletRequest request,@PathVariable("username")String username,@PathVariable("email")String email){
		return new UserOperration().changeEmail(username, email);
	}

	@RequestMapping(value = "/deleteUserAction", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteUser(HttpServletRequest request) {
		String username = (String)request.getSession().getAttribute("username");
		return new UserOperration().deleteUser(username);
	}


}
