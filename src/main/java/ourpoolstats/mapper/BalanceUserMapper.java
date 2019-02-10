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
		balance.setNameCoin(rs.getString(2));
		balance.setInitialCurrency(rs.getBigDecimal(3));
		balance.setCurrentCurrency(rs.getBigDecimal(4));
		balance.setTotalCurrency(rs.getBigDecimal(5));
		balance.setQuantity(rs.getBigDecimal(6));		
		return balance;
	}

}
