package ourpoolstats.service.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.model.User;
import ourpoolstats.response.LogUserResponse;
import ourpoolstats.response.Response;
import ourpoolstats.response.UserListResponse;
import ourpoolstats.response.UserOnlineResponse;

public interface IAdminDasboradService {

	public ResponseEntity<Response> createUser(User user);
	public ResponseEntity<Response> deleteUser(String username);
	public ResponseEntity<Response> cangeTypeUser(String userType,String username);
	public ResponseEntity<LogUserResponse> logSingleUser(String username);
	public ResponseEntity<LogUserResponse> logUser();
	public ResponseEntity<UserOnlineResponse> userOnline(String username);
	public List<String> getCoins();
	public ResponseEntity<UserListResponse> getUserList(String username);


}
