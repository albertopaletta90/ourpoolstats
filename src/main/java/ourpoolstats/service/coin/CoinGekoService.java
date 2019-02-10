package ourpoolstats.service.coin;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import ourpoolstats.api.coingeko.CoinGekoClient;
import ourpoolstats.api.coingeko.data.Market;

public class CoinGekoService implements ICoinGekoService {

	private static CoinGekoService instance;
	private String urlMarket = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

	private CoinGekoService() {}

	public static CoinGekoService getInstance() {

		if(instance == null) {

			instance = new CoinGekoService();

		}

		return instance;

	}

	@Override
	public Market getCoinInfo(String id) {
		RestTemplate restTemplate = new RestTemplate();
		Market[] coins = restTemplate.getForObject(urlMarket, Market[].class);
		Object[] list = Arrays.stream((Market[]) coins).filter(x -> x.getName().equalsIgnoreCase(id)).toArray();
		return (Market) list[0];
	}


	@Override
	public List<Market> getList() {
		return CoinGekoClient.GetInstance().getListMarket();

	}




}
