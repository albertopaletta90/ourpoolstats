package ourpoolstats.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.log.AdminOperationLogger;
import ourpoolstats.mapper.StringMapper;
import ourpoolstats.mapper.UserLogMapper;
import ourpoolstats.mapper.UserLoginMapper;
import ourpoolstats.model.User;
import ourpoolstats.model.UserLog;
import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.query.QueryUser;
import ourpoolstats.response.LogUserResponse;
import ourpoolstats.response.Response;
import ourpoolstats.response.UserOnlineResponse;
import ourpoolstats.service.language.LanguageService;
import ourpoolstats.type.AdminOperation;
import ourpoolstats.utility.GetConnection;

public class AdminDasboradService implements IAdminDasboradService {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public AdminDasboradService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}

	@Override
	public ResponseEntity<Response> createUser(User user) {
		Response response = new Response();
		String hashPswword = jdbcTemplate.query(QueryUser.getInstance().getHashPassword(), new StringMapper(),user.getPassword()).get(0);
		String userType = "USER";
		try {
			jdbcTemplate.update(QueryAdminOption.getInstance().getInsertUserAdmin(),user.getUserName(),user.getUserSurname(),user.getEmail(),user.getUsername(),hashPswword,userType);
		}catch (Exception e) {
			AdminOperationLogger.getInstance().logger(user.getUsername(), false, AdminOperation.INSERTUSER);
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setEror("Utente Gi� presente  " + e.getMessage());
			return new  ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LanguageService languageService = new LanguageService();
		languageService.setLenguace("italiano", user.getUsername());
		AdminOperationLogger.getInstance().logger(user.getUsername(), true, AdminOperation.INSERTUSER);
		response.setStatus(HttpStatus.OK.toString());
		return new  ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response> deleteUser(String username) {
		Response response = new Response();
		try {
			jdbcTemplate.update(QueryAdminOption.getInstance().getDeleteUser(),username);
			AdminOperationLogger.getInstance().logger(username, true, AdminOperation.DELETE);
			response.setStatus(HttpStatus.OK.toString());
			return new  ResponseEntity<Response>(response, HttpStatus.OK);
		}catch (Exception e) {
			AdminOperationLogger.getInstance().logger(username, false, AdminOperation.DELETE);
			response.setEror("Errore Tecnico " + e.getMessage());
			return new  ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Response> cangeTypeUser(String userType,String username) {
		Response response = new Response();
		try {
			jdbcTemplate.update(QueryAdminOption.getInstance().getChangeUserType(),userType,username);
			AdminOperationLogger.getInstance().logger(username, true, AdminOperation.CHANGETYPE);
			response.setStatus(HttpStatus.OK.toString());
			return new  ResponseEntity<Response>(response, HttpStatus.OK);
		}catch (Exception e) {
			AdminOperationLogger.getInstance().logger(username, false, AdminOperation.CHANGETYPE);
			response.setEror("Errore Tecnico " + e.getMessage());
			return new  ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public User logSingleUser(String username) {
		return null;
	}

	@Override
	public ResponseEntity<LogUserResponse> logUser() {
		List<UserLog>list = jdbcTemplate.query(QueryAdminOption.getInstance().getUserLog(), new UserLogMapper());
		LogUserResponse logUserResponse = new LogUserResponse();
		if(list != null) {
			AdminOperationLogger.getInstance().logger("", true, AdminOperation.VIEWLOGUSER);
			logUserResponse.setStatus(HttpStatus.OK.toString());
			logUserResponse.setUserLog(list);
			return new  ResponseEntity<LogUserResponse>(logUserResponse, HttpStatus.OK);
		}
		else {
			AdminOperationLogger.getInstance().logger("", false, AdminOperation.VIEWLOGUSER);
			logUserResponse.setStatus(HttpStatus.NOT_FOUND.toString());
			logUserResponse.setUserLog(list);
			return new  ResponseEntity<LogUserResponse>(logUserResponse, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<UserOnlineResponse> userOnline(String username) {
		List<User>list = new ArrayList<>();
		list = jdbcTemplate.query(QueryAdminOption.getInstance().getUserOnline(), new UserLoginMapper(),username);
		UserOnlineResponse userOnlineResponse = new UserOnlineResponse();
		if(list!=null || !list.isEmpty()) {
			userOnlineResponse.setStatus(HttpStatus.OK.toString());
			userOnlineResponse.setUserLog(list);
			return new ResponseEntity<UserOnlineResponse>(userOnlineResponse,HttpStatus.OK);
		}else {
			userOnlineResponse.setStatus(HttpStatus.NOT_FOUND.toString());
			userOnlineResponse.setUserLog(list);
			userOnlineResponse.setError("Nessun User Trovato");
			return new ResponseEntity<UserOnlineResponse>(userOnlineResponse,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<String> getCoins() {

		return null;
	}

}
