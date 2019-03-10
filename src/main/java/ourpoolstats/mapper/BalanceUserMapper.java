package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.Balance;




public class BalanceUserMapper  implements RowMapper<Balance> {

	@Override
	public Balance mapRow(ResultSet rs, int index) throws SQLException {
		Balance balance = new Balance();
		balance.setId(rs.getInt(1));
		balance.setUsername(rs.getString(2));
		balance.setNameCoin(rs.getString(3));
		balance.setInitialCurrency(rs.getBigDecimal(4));
		balance.setCurrentCurrency(rs.getBigDecimal(5));
		balance.setTotalCurrency(rs.getBigDecimal(6));
		balance.setQuantity(rs.getBigDecimal(7));		
		return balance;
	}

}
