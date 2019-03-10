package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FirstLoginMapper implements RowMapper<Integer>{

	@Override
	public Integer mapRow(ResultSet rs, int index) throws SQLException {
		return rs.getInt(1);
	}

}