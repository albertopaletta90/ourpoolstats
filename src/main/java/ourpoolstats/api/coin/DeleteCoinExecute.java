package ourpoolstats.api.coin;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coinmarket.CoinMarketClient;
import ourpoolstats.commonOperation.CommonOperationCoin;
import ourpoolstats.mapper.IntegerMapper;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.GetConnection;

public class DeleteCoinExecute {
	
	public ResponseEntity<Response> deleteCoin(String name, Response response) {
		CommonOperationCoin commonOperationCoin = new CommonOperationCoin();
		try {
			CoinMarketClient client = new CoinMarketClient();
			client.getCoinInfo(name);
			int id = GetConnection.getInstance().getJdbcTemplate().query(QueryCoin.getInstance().getGetIdCoin(), new IntegerMapper() ,name).get(0);
			GetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getDeleteCoin(),id);
			commonOperationCoin.setCoin();
			return new ResponseStatus().success(response, name, LogOperation.DELETECOIN, null);
		} catch (Exception e) {
			return new ResponseStatus().error(response, name, e, LogOperation.DELETECOIN);
		}
	}
}
