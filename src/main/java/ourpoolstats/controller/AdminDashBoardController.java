package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.model.User;
import ourpoolstats.response.LogUserResponse;
import ourpoolstats.response.Response;
import ourpoolstats.response.UserListResponse;
import ourpoolstats.response.UserOnlineResponse;
import ourpoolstats.service.admin.AdminDasboradService;
import ourpoolstats.service.coin.CoinMarketService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
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

	@RequestMapping(value = "/logSingleUser/{username}", method = RequestMethod.GET)
	public ResponseEntity<LogUserResponse> logSingleUser(@PathVariable("username")String username) {
		return new AdminDasboradService().logSingleUser(username);
	}

	@RequestMapping(value = "/userOnline", method = RequestMethod.GET)
	public ResponseEntity<UserOnlineResponse> userOnline(HttpServletRequest request) {
		String username = (String)request.getSession().getAttribute("username");
		return new AdminDasboradService().userOnline(username);
	}

	@RequestMapping(value = "/addCoin/{nameCoin}", method = RequestMethod.POST)
	public ResponseEntity<Response> addCoin(@PathVariable("nameCoin")String name) {
		Response response = new Response();
		return new CoinMarketService().addCoin(name,response);
		
	}
	
	@RequestMapping(value = "/deleteCoin/{nameCoin}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteCoin(@PathVariable("nameCoin")String name) {
		Response response = new Response();
		return new CoinMarketService().deleteCoin(name,response);
		
	}
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public ResponseEntity<UserListResponse> getUserList(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		return new AdminDasboradService().getUserList(username);
		
	}
	
}
