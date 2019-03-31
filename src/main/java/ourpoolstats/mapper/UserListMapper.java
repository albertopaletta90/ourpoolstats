package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.UserList;

public class UserListMapper implements RowMapper<UserList> {

	@Override
	public UserList mapRow(ResultSet rs, int index) throws SQLException {
		UserList userList = new UserList();
		userList.setName(rs.getString(1));
		userList.setSurname(rs.getString(2));
		userList.setUsername(rs.getString(3));
		userList.setEmail(rs.getString(4));
		userList.setUserType(rs.getString(5));		
		return userList;
	}

}
