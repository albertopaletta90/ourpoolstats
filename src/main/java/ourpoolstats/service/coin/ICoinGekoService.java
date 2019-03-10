package ourpoolstats.service.coin;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.response.CoinGekoResponse;

public interface ICoinGekoService {
	
	public List<Market> getList();
	public ResponseEntity<CoinGekoResponse> getCoinInfo(String name);

}
