package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.Login;

public class LoginMapper implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet rs, int index) throws SQLException {
		Login login = new Login();
		login.setUsername(rs.getString(1));
		login.setPassword(rs.getString(2));			
		return login;		
	}	
}
	