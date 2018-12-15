package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.UserLog;

public class UserLogMapper  implements RowMapper<UserLog>{

	@Override
	public UserLog mapRow(ResultSet rs, int index) throws SQLException {
		UserLog  log =  new UserLog();
		log.setUsername(rs.getString(1));
		log.setDateLogin(rs.getTimestamp(2));
		
		return log;
	}

}
