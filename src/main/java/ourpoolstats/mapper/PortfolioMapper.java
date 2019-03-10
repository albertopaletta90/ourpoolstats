package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.Portfolio;

public class PortfolioMapper implements RowMapper<Portfolio> {

	@Override
	public Portfolio mapRow(ResultSet rs, int index) throws SQLException {
		return new Portfolio(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBigDecimal(6),rs.getBigDecimal(7),rs.getBigDecimal(5));		
	}


}
