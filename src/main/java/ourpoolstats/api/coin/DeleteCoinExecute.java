package ourpoolstats.api.coin;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coinmarket.CoinMarketClient;
import ourpoolstats.mapper.IntegerMapper;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.SetConnection;

public class DeleteCoinExecute {
	
	public ResponseEntity<Response> deleteCoin(String name, Response response) {
		try {
			CoinMarketClient client = new CoinMarketClient();
			client.getCoinInfo(name);
			int id = SetConnection.getInstance().getJdbcTemplate().query(QueryCoin.getInstance().getGetIdCoin(), new IntegerMapper() ,name).get(0);
			SetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getDeleteCoin(),id);
			return new ResponseStatus().success(response, name, LogOperation.DELETECOIN, null);
		} catch (Exception e) {
			return new ResponseStatus().error(response, name, e, LogOperation.DELETECOIN);
		}
	}
}
