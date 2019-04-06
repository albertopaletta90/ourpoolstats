package ourpoolstats.service.user;

import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.mapper.FirstLoginMapper;
import ourpoolstats.mapper.LoginMapper;
import ourpoolstats.mapper.StringMapper;
import ourpoolstats.model.Login;
import ourpoolstats.model.User;
import ourpoolstats.query.QueryImage;
import ourpoolstats.query.QueryUser;
import ourpoolstats.response.Response;
import ourpoolstats.type.UserType;
import ourpoolstats.utility.GetConnection;



public class UserOperration implements IUserOperation {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public static String emailTemporaney; 

	public UserOperration() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}

	@Override
	public boolean signinUser(User u) {
		String hashPswword = jdbcTemplate.query(QueryUser.getInstance().getHashPassword(), new StringMapper(),u.getPassword()).get(0);
		String userType = UserType.USER.toString();
		try {
			jdbcTemplate.update(QueryUser.getInstance().getInserUser(),u.getUserName(),u.getUserSurname(),u.getEmail(),u.getUsername(),hashPswword,userType);
			return true;
		} catch (Exception e) {
			return false;
		}


	}

	@Override
	public boolean loginUser(String username, String password) {
		String hashPassword = jdbcTemplate.query(QueryUser.getInstance().getHashPassword(), new StringMapper(),password).get(0);
		List<Login>login =jdbcTemplate.query(QueryUser.getInstance().getLogin(), new LoginMapper(),username);
		if(login.isEmpty())
			return false;
		if(login.get(0).getUsername().equals(username) && login.get(0).getPassword().equals(hashPassword))
			return true;
		else
			return false;

	}

	@Override
	public UserType searchUserType(String username) {
		List<String>usertype = jdbcTemplate.query(QueryUser.getInstance().getSearchUserType(), new StringMapper(),username);			
		if(usertype.get(0).equals("ADMIN"))
			return UserType.ADMIN ;
		if(usertype.get(0).equals("MANAGER"))
			return UserType.MANAGER;

		return UserType.USER;	
	}

	@Override
	public void insertToUserLogin(Login l) {
		jdbcTemplate.update(QueryUser.getInstance().getInsertUserLogin(),l.getUsername(),new GregorianCalendar());
	}

	@Override
	public ResponseEntity<Response> getImageProfile(String username) {
		List<String> imageProfile = jdbcTemplate.query(QueryImage.getInstance().getGetImageProfile(), new StringMapper(),username);
		Response response = new Response();
		response.setStatus(HttpStatus.OK.toString());
		response.setEror("Nessun Errore");
		response.setData(imageProfile);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Response> setImageProfile(String username, String url,String method) {
		switch (method) {
		case "insert":
			try {
				jdbcTemplate.update(QueryImage.getInstance().getInsetImageProfile(),username,url);
				return success();
			} catch (Exception e) {
				return fail(e);
			}

		case "update":
			try {
				jdbcTemplate.update(QueryImage.getInstance().getSetImageProfile(),url,username);
				return success();
			} catch (Exception e) {
				return fail(e);
			}

		}
		return null;


	}

	private ResponseEntity<Response> success() {
		Response response = new Response();
		response.setStatus(HttpStatus.OK.toString());
		return new  ResponseEntity<Response>(response, HttpStatus.OK);

	}

	private ResponseEntity<Response> fail(Exception e ) {
		Response response = new Response();
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		response.setEror(e.getMessage());
		return new  ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);


	}


	@Override
	public ResponseEntity<Response> changePassword(String username, String password,String newPassword) {
		Response response = new Response();
		if(loginUser(username, password)) {
			try {
				newPassword = jdbcTemplate.query(QueryUser.getInstance().getHashPassword(), new StringMapper(),password).get(0);
				jdbcTemplate.update(QueryUser.getInstance().getChangePassword(),newPassword,username);
				response.setStatus(HttpStatus.OK.toString());
				return new  ResponseEntity<Response>(response,HttpStatus.OK);
			} catch (Exception e) {
				return error(response);
			}

		}else {
			return error(response);
		}

	}

	@Override
	public ResponseEntity<Response> changeEmail(String username, String email) {
		Response response = new Response();
		try {
			jdbcTemplate.update(QueryUser.getInstance().getChangeEmail(),email,username);
			response.setStatus(HttpStatus.OK.toString());
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setEror(e.getMessage());
			return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Response> deleteUser(String user) {
		Response response = new Response();
		try {
			jdbcTemplate.update(QueryUser.getInstance().getDeleteUser(),user);
			response.setStatus(HttpStatus.OK.toString());
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setEror(e.getMessage());
			return new  ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}

	public String findUsernameToEmail(String emails) {
		emailTemporaney = emails;
		try {
			List<String> list = jdbcTemplate.query(QueryUser.getInstance().getSearchUserToEmail(), new StringMapper(),emails);
			return list.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public void insertToUserOnline(Login login) {
		jdbcTemplate.update(QueryUser.getInstance().getInsertUserOnline(),login.getUsername());

	}

	@Override
	public ResponseEntity<Response> deleteToUserOnline(String username,HttpServletRequest request) {
		Response response = new Response();
		try {
			jdbcTemplate.update(QueryUser.getInstance().getDeleteUserOnline(),username);
			setFirstLoginDay(username, 1);
			response.setStatus(HttpStatus.OK.toString());
			request.getSession().removeAttribute(username);
			return new  ResponseEntity<Response>(response,HttpStatus.OK);			
		}catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setEror(e.getMessage());
			return new  ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public boolean isFirstLogin(String User) {
		if(jdbcTemplate.query(QueryUser.getInstance().getIsFisrtLogin(), new FirstLoginMapper(),User).get(0) == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean setFirstLogin(String user) {
		try {
			jdbcTemplate.update(QueryUser.getInstance().getSetFisrtLogin(), user);
			return true;
		} catch (Exception e) {
			return false;
		}


	}

	@Override
	public boolean isFirstLoginDay(String User) {
		if(jdbcTemplate.query(QueryUser.getInstance().getIsFisrtLoginDay(), new FirstLoginMapper(),User).get(0) == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean setFirstLoginDay(String user, int value) {
		try {
			jdbcTemplate.update(QueryUser.getInstance().getSetFisrtLoginDay(),value,user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private ResponseEntity<Response> error(Response response) {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		response.setEror("Errore Tecnico");
		return new  ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
