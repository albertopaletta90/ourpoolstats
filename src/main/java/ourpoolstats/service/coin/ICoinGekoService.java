package ourpoolstats.service.coin;

import java.util.List;

import ourpoolstats.api.coingeko.data.Market;

public interface ICoinGekoService {
	
	public List<Market> getList();
	public Market getCoinInfo(String id);

}
