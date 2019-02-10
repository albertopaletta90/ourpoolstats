package ourpoolstats.service.coin;

import java.util.List;

import ourpoolstats.api.cryptopia.CryptopiaClient;
import ourpoolstats.api.cryptopia.remote.Currency;
import ourpoolstats.api.cryptopia.remote.TradePair;

public class CryptopiaService implements ICryptopiaService {

	private static CryptopiaService instance;
	
	private CryptopiaService() {}
	
	public static CryptopiaService getInstance() {
		
		if(instance == null) {
	
			instance = new CryptopiaService();
		
		}
		
		return instance;
	
	}
	
	
	
	@Override
	public List<TradePair> initCoin() {
		return CryptopiaClient.getInstance().getTradePairs();
	}

	@Override
	public void setMapCoin() {
		
	}

	@Override
	public List<Currency> getListSelectecd(List<String> list) {
		return null;
	}



}
