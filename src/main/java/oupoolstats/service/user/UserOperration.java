package oupoolstats.service.user;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.manager.ManagerImage;
import ourpoolstats.mapper.FirstLoginMapper;
import ourpoolstats.mapper.ImageMapper;
import ourpoolstats.mapper.LoginMapper;
import ourpoolstats.mapper.MailMapper;
import ourpoolstats.mapper.PasswordMapper;
import ourpoolstats.mapper.UserTypeMapper;
import ourpoolstats.model.Login;
import ourpoolstats.model.User;
import ourpoolstats.myenum.UserType;
import ourpoolstats.query.QueryImage;
import ourpoolstats.query.QueryUser;
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
		String hashPswword = jdbcTemplate.query(QueryUser.getInstance().getHashPassword(), new PasswordMapper(),u.getPassword()).get(0);
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
		String hashPassword = jdbcTemplate.query(QueryUser.getInstance().getHashPassword(), new PasswordMapper(),password).get(0);
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
		List<String>usertype = jdbcTemplate.query(QueryUser.getInstance().getSearchUserType(), new UserTypeMapper(),username);			
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
	public boolean forgotPassword(String username) {

		return false;
	}

	@Override
	public String getImageProfile(String username) {
		List<String> list = jdbcTemplate.query(QueryImage.getInstance().getGetImageProfile(), new ImageMapper(),username);
		return list.get(0);

	}

	@Override
	public boolean setImageProfile(String username, String url,String method) {
		switch (method) {
		case "insert":
			try {
				jdbcTemplate.update(QueryImage.getInstance().getInsetImageProfile(),username,url);
			} catch (Exception e) {
				return false;
			}
			break;
		case "update":
			try {
				jdbcTemplate.update(QueryImage.getInstance().getSetImageProfile(),url,username);
			} catch (Exception e) {
				return false;
			}
			break;
		}

		return true;
	}

	@Override
	public boolean changePassword(String username, String password) {
		try {
			String newPassword =  jdbcTemplate.query(QueryUser.getInstance().getHashPassword(), new PasswordMapper(),password).get(0);
			jdbcTemplate.update(QueryUser.getInstance().getChangePassword(),newPassword,username);
			return true;
		} catch (Exception e) {
			return false;
		}


	}

	@Override
	public boolean changeEmail(String username, String email) {
		try {
			jdbcTemplate.update(QueryUser.getInstance().getChangeEmail(),email,username);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteUser(String user) {
		try {
			jdbcTemplate.update(QueryUser.getInstance().getDeleteUser(),user);
			return true;
		} catch (Exception e) {
			return false;
		}			
	}

	public String findUsernameToEmail(String emails) {
		emailTemporaney = emails;
		try {
			List<String> list = jdbcTemplate.query(QueryUser.getInstance().getSearchUserToEmail(), new MailMapper(),emails);
			return list.get(0);
		} catch (Exception e) {

		}
		return "";
	}

	public void insertToUserOnline(Login login) {
		jdbcTemplate.update(QueryUser.getInstance().getInsertUserOnline(),login.getUsername());

	}

	public void deleteToUserOnline(String login) {
		jdbcTemplate.update(QueryUser.getInstance().getDeleteUserOnline(),login);

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


}
