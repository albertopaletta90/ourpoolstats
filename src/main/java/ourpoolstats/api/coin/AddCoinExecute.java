package ourpoolstats.api.coin;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coinmarket.CoinMarketClient;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.SetConnection;

public class AddCoinExecute {
	public ResponseEntity<Response> addCoin(String name, Response response) {
		try {
			CoinMarketClient client = new CoinMarketClient();
			client.getCoinInfo(name);
			SetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getInsertCoin(),name,"user",0,0,0,0,0,0,0,0,0,0,0);
			return new ResponseStatus().success(response, name, LogOperation.INSERTCOIN, null);
		} catch (Exception e) {
			return new ResponseStatus().error(response, name, e, LogOperation.INSERTCOIN);
		}
	}
}
