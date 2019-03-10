package ourpoolstats.service.coin;
import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coinmarket.Coin;
import ourpoolstats.model.Balance;
import ourpoolstats.model.CoinDB;
import ourpoolstats.response.CoinMarketResponse;

public interface ICoinMarketService {
	
	public List<String> getListCoinDefault();
	public ResponseEntity<CoinMarketResponse> getCoinInfo(String name);
	public List<Balance>getListCoinUser(String user);
	public void setListCoinDB(List<Coin>list);
	public List<CoinDB>getListDB();

}
