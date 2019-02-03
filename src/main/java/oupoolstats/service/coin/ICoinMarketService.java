package oupoolstats.service.coin;
import java.util.List;

import oupoolstats.api.coinmarket.Coin;

public interface ICoinMarketService {
	
	public List<String> getListCoinDefault();
	public Coin getCoinInfo(String name);
	public List<Coin>getListCoinUser(String user);

}
