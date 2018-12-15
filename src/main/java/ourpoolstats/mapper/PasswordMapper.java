package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PasswordMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet rs, int index) throws SQLException {
		return rs.getString(1);		
	}

}
