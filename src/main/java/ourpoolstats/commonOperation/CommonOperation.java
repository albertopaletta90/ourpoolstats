package ourpoolstats.commonOperation;

import java.util.GregorianCalendar;
import java.util.List;

import ourpoolstats.mapper.FirstLoginMapper;
import ourpoolstats.mapper.LoginMapper;
import ourpoolstats.mapper.StringMapper;
import ourpoolstats.model.Login;
import ourpoolstats.query.QueryUser;
import ourpoolstats.type.UserType;
import ourpoolstats.utility.connection.SetConnection;



public class CommonOperation {

	public boolean searchUserWithPassword(String username, String password) {
		String hashPassword = SetConnection.getInstance().getJdbcTemplate().query(QueryUser.getInstance().getHashPassword(), new StringMapper(),password).get(0);
		List<Login>login =SetConnection.getInstance().getJdbcTemplate().query(QueryUser.getInstance().getLogin(), new LoginMapper(),username);
		if(login.isEmpty())
			return false;
		if(login.get(0).getUsername().equals(username) && login.get(0).getPassword().equals(hashPassword))
			return true;
		else
			return false;
	}

	public UserType searchUserType(String username) {
		List<String>usertype = SetConnection.getInstance().getJdbcTemplate().query(QueryUser.getInstance().getSearchUserType(), new StringMapper(),username);			
		if(usertype.get(0).equals("ADMIN"))
			return UserType.ADMIN ;
		if(usertype.get(0).equals("MANAGER"))
			return UserType.MANAGER;

		return UserType.USER;	
	}


	public void insertToUserLogin(Login l) {
		SetConnection.getInstance().getJdbcTemplate().update(QueryUser.getInstance().getInsertUserLogin(),l.getUsername(),new GregorianCalendar());
	}

	public void insertToUserOnline(Login login) {
		SetConnection.getInstance().getJdbcTemplate().update(QueryUser.getInstance().getInsertUserOnline(),login.getUsername());

	}

	public boolean isFirstLogin(String User) {
		if(SetConnection.getInstance().getJdbcTemplate().query(QueryUser.getInstance().getIsFisrtLogin(), new FirstLoginMapper(),User).get(0) == 1)
			return true;
		else
			return false;
	}

	public boolean setFirstLogin(String user) {
		try {
			SetConnection.getInstance().getJdbcTemplate().update(QueryUser.getInstance().getSetFisrtLogin(), user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}


	public boolean isFirstLoginDay(String User) {
		if(SetConnection.getInstance().getJdbcTemplate().query(QueryUser.getInstance().getIsFisrtLoginDay(), new FirstLoginMapper(),User).get(0) == 1)
			return true;
		else
			return false;
	}

	public boolean setFirstLoginDay(String user, int value) {
		try {
			SetConnection.getInstance().getJdbcTemplate().update(QueryUser.getInstance().getSetFisrtLoginDay(),value,user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
}
