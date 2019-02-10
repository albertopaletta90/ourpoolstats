package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.CoinDB;

public class CoinDBMapper  implements RowMapper<CoinDB>{

	@Override
	public CoinDB mapRow(ResultSet rs, int index) throws SQLException {
		CoinDB coin = new CoinDB();
		coin.setId(rs.getInt(1));
		coin.setName(rs.getString(2));
		coin.setPriceBtc(rs.getBigDecimal(3));
		coin.setPriceUsd(rs.getBigDecimal(4));
		coin.setMarketCap(rs.getBigDecimal(5));
		coin.setPerc_1(rs.getBigDecimal(6));
		coin.setPerc_24(rs.getBigDecimal(7));
		return coin;
	}

}
