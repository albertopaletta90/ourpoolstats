package oupoolstats.service.coin;

import java.util.List;

import oupoolstats.api.coingeko.data.Market;

public interface ICoinGekoService {
	
	public List<Market> getList();

}
