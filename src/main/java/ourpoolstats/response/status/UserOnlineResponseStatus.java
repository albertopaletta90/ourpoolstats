package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.model.User;
import ourpoolstats.response.UserOnlineResponse;

public class UserOnlineResponseStatus {

	public ResponseEntity<UserOnlineResponse> success(UserOnlineResponse userOnlineResponse, String username,List<String> list) {
		userOnlineResponse.setStatus(HttpStatus.OK.toString());
		userOnlineResponse.setUserOnline(list);
		return new ResponseEntity<UserOnlineResponse>(userOnlineResponse,HttpStatus.OK);
	}

	public ResponseEntity<UserOnlineResponse> error(UserOnlineResponse userOnlineResponse, String username,List<String> list) {
		userOnlineResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		userOnlineResponse.setUserOnline(list);
		userOnlineResponse.setError("Nessun User Trovato");
		return new ResponseEntity<UserOnlineResponse>(userOnlineResponse,HttpStatus.NOT_FOUND);
	}

}
