package oupoolstats.service.coin;

import java.util.List;

import oupoolstats.api.cryptopia.CryptopiaClient;
import oupoolstats.api.cryptopia.remote.data.Currency;

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
	public void initCoin() {

		CryptopiaClient.getInstance().initCurrency();
	}

	@Override
	public void setMapCoin() {
		CryptopiaClient.getInstance().createMapCoinCryptopia();
	}

	@Override
	public List<Currency> getListSelectecd(List<String> list) {
		return CryptopiaClient.getInstance().getMapCoinCryptopia(list);
	}



}
