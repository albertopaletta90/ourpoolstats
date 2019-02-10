package ourpoolstats.service.coin;
import java.util.List;

import ourpoolstats.api.coinmarket.Coin;
import ourpoolstats.model.Balance;
import ourpoolstats.model.CoinDB;

public interface ICoinMarketService {
	
	public List<String> getListCoinDefault();
	public Coin getCoinInfo(String name);
	public List<Balance>getListCoinUser(String user);
	public void setListCoinDB(List<Coin>list);
	public List<CoinDB>getListDB();

}
