package oupoolstats.service.coin;


import java.util.List;

import oupoolstats.api.coingeko.CoinGekoClient;
import oupoolstats.api.coingeko.data.Market;

public class CoinGekoService implements ICoinGekoService {
	
private static CoinGekoService instance;
	
	private CoinGekoService() {}
	
	public static CoinGekoService getInstance() {
		
		if(instance == null) {
	
			instance = new CoinGekoService();
		
		}
		
		return instance;
	
	}
	
	
	@Override
	public List<Market> getList() {
		return CoinGekoClient.GetInstance().getListMarket();
		
	}



}
