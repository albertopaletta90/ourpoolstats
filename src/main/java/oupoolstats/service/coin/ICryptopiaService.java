package oupoolstats.service.coin;

import java.util.List;

import oupoolstats.api.cryptopia.remote.data.Currency;
import oupoolstats.api.cryptopia.remote.data.TradePair;

public interface ICryptopiaService {
	
	public List<TradePair> initCoin();

}
