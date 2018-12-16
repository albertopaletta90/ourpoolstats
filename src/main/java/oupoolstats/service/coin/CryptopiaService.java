package oupoolstats.service.coin;

import java.util.List;

import oupoolstats.api.cryptopia.CryptopiaClient;
import oupoolstats.api.cryptopia.remote.data.Currency;
import oupoolstats.api.cryptopia.remote.data.TradePair;

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

}
