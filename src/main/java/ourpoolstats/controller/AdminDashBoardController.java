package ourpoolstats.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ourpoolstats.api.UserOperation.ChangeUserTypeExecute;
import ourpoolstats.api.UserOperation.CreateUserExecute;
import ourpoolstats.api.UserOperation.DeleteUserExecute;
import ourpoolstats.api.UserOperation.GetAccesSingleUserPrepare;
import ourpoolstats.api.UserOperation.GetAccessAllUserPrapare;
import ourpoolstats.api.UserOperation.GetUserListPrepare;
import ourpoolstats.api.UserOperation.GetUserOnlinePrepare;
import ourpoolstats.api.coin.AddCoinExecute;
import ourpoolstats.api.coin.DeleteCoinExecute;
import ourpoolstats.model.User;
import ourpoolstats.response.LogUserResponse;
import ourpoolstats.response.Response;
import ourpoolstats.response.UserListResponse;
import ourpoolstats.response.UserOnlineResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AdminDashBoardController {

	@RequestMapping(value = "/createUser/{name}/surname/{surname}/username/{username}/password/{password}/email/{email}", method = RequestMethod.POST)
	public  ResponseEntity<Response> createUser(@PathVariable("name") String name, @PathVariable("surname") String surname, @PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("email") String email) {
		User user = new User(name,surname,username,password,email);
		return new CreateUserExecute().createUser(user);
	}

	@RequestMapping(value = "/deleteUser/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Response>  deleteUser(@PathVariable("name") String username) {
		return new DeleteUserExecute().deleteUser(username);
	}

	@RequestMapping(value = "/changeTypeUser/{type}/user/{username}", method = RequestMethod.POST)
	public ResponseEntity<Response> changeTypeUser(@PathVariable("type") String type,@PathVariable("username") String username) {
		return new ChangeUserTypeExecute().cangeTypeUser(type, username);
	}

	@RequestMapping(value = "/logUser", method = RequestMethod.GET)
	public ResponseEntity<LogUserResponse> logUser(HttpServletRequest request) {
		return new GetAccessAllUserPrapare().logUser();
	}

	@RequestMapping(value = "/logSingleUser/{username}", method = RequestMethod.GET)
	public ResponseEntity<LogUserResponse> logSingleUser(@PathVariable("username")String username) {
		return new GetAccesSingleUserPrepare().logSingleUser(username);
	}

	@RequestMapping(value = "/userOnline/{username}", method = RequestMethod.GET)
	public ResponseEntity<UserOnlineResponse> userOnline(@PathVariable("username") String username) {
		return new GetUserOnlinePrepare().userOnline(username);
	}

	@RequestMapping(value = "/addCoin/{nameCoin}", method = RequestMethod.POST)
	public ResponseEntity<Response> addCoin(@PathVariable("nameCoin")String name) {
		Response response = new Response();
		return new AddCoinExecute().addCoin(name,response);
		
	}
	
	@RequestMapping(value = "/deleteCoin/{nameCoin}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteCoin(@PathVariable("nameCoin")String name) {
		Response response = new Response();
		return new DeleteCoinExecute().deleteCoin(name,response);
		
	}
	
	@RequestMapping(value = "/getUserList/{username}", method = RequestMethod.GET)
	public ResponseEntity<UserListResponse> getUserList(@PathVariable("username") String username) {
		return new GetUserListPrepare().getUserList(username);
		
	}
	
}
