package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ourpoolstats.model.User;
import ourpoolstats.response.LogUserResponse;
import ourpoolstats.response.Response;
import ourpoolstats.response.UserOnlineResponse;
import ourpoolstats.service.admin.AdminDasboradService;


@Controller
public class AdminDashBoardController {

	@RequestMapping(value = "/createUser/{name}/surname/{surname}/username/{username}/password/{password}/email/{email}", method = RequestMethod.POST)
	public  ResponseEntity<Response> createUser(@PathVariable("name") String name, @PathVariable("surname") String surname, @PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("email") String email) {
		User user = new User(name,surname,username,password,email);
		return new AdminDasboradService().createUser(user);
	}


	@RequestMapping(value = "/deleteUser/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Response>  deleteUser(@PathVariable("name") String username) {
		return new AdminDasboradService().deleteUser(username);
	}


	@RequestMapping(value = "/changeTypeUser/{type}/user/{username}", method = RequestMethod.POST)
	public ResponseEntity<Response> changeTypeUser(@PathVariable("type") String type,@PathVariable("username") String username) {
		return new AdminDasboradService().cangeTypeUser(type, username);
	}

	@RequestMapping(value = "/logUser", method = RequestMethod.GET)
	public ResponseEntity<LogUserResponse> logUser(HttpServletRequest request) {
		return new AdminDasboradService().logUser();
	}


	@RequestMapping(value = "/logSingleUser", method = RequestMethod.GET)
	public ModelAndView logSingleUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("ourpoolstats/ourpoolstats");
		return model;
	}

	@RequestMapping(value = "/userOnline", method = RequestMethod.GET)
	public ResponseEntity<UserOnlineResponse> userOnline(HttpServletRequest request) {
		String username = (String)request.getSession().getAttribute("username");
		return new AdminDasboradService().userOnline(username);
	}

	@RequestMapping(value = "/addCoin", method = RequestMethod.GET)
	public ModelAndView addCoin() {
		ModelAndView model = new ModelAndView();
		
		return model;
	}

}
