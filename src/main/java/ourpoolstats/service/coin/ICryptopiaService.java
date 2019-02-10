package ourpoolstats.service.coin;

import java.util.List;

import ourpoolstats.api.cryptopia.remote.Currency;
import ourpoolstats.api.cryptopia.remote.TradePair;

public interface ICryptopiaService {
	
	public List<TradePair> initCoin();
	public void setMapCoin();
	public List<Currency> getListSelectecd(List<String>list);

}
