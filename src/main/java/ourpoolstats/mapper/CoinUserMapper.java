package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import oupoolstats.api.coinmarket.Coin;

public class CoinUserMapper  implements RowMapper<Coin> {

	@Override
	public Coin mapRow(ResultSet rs, int index) throws SQLException {
		Coin coin = new Coin();
		coin.setName(rs.getString(1));
		coin.setQuantity(rs.getInt(2));
		return coin;
	}

}
