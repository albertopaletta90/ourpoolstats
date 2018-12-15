package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.User;

public class UserLoginMapper implements RowMapper<User>  {

	@Override
	public User mapRow(ResultSet rs, int index) throws SQLException {
		User userLogin = new User();		
		userLogin.setUsername(rs.getString(1));
		return userLogin;
	}

}
