package oupoolstats.service.coin;

import java.util.List;

import oupoolstats.api.cryptopia.remote.data.Currency;

public interface ICryptopiaService {
	
	public void initCoin();
	public void setMapCoin();
	public List<Currency> getListSelectecd(List<String>list);

}
