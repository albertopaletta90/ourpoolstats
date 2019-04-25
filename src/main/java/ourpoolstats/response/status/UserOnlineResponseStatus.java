package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.model.User;
import ourpoolstats.response.UserOnlineResponse;

public class UserOnlineResponseStatus {

	public ResponseEntity<UserOnlineResponse> success(UserOnlineResponse userOnlineResponse, String username,List<User> list) {
		userOnlineResponse.setStatus(HttpStatus.OK.toString());
		userOnlineResponse.setUserLog(list);
		return new ResponseEntity<UserOnlineResponse>(userOnlineResponse,HttpStatus.OK);
	}

	public ResponseEntity<UserOnlineResponse> error(UserOnlineResponse userOnlineResponse, String username,List<User> list) {
		userOnlineResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		userOnlineResponse.setUserLog(list);
		userOnlineResponse.setError("Nessun User Trovato");
		return new ResponseEntity<UserOnlineResponse>(userOnlineResponse,HttpStatus.NOT_FOUND);
	}

}
