package ourpoolstats.client.coingeko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import ourpoolstats.client.coingeko.data.CoinG;
import ourpoolstats.client.coingeko.data.Market;


public class CoinGekoClient {
	private static  CoinGekoClient instance ;
	private String currency = "usd";
	private String urlMarket = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=";
	private static String urlListCoin = "https://api.coingecko.com/api/v3/coins/list";
	private  List<Market>listMarket = new ArrayList<Market>();
	private  List<CoinG>listCoin = new ArrayList<CoinG>();

	private CoinGekoClient() {}

	public static CoinGekoClient GetInstance() {

		if(instance == null) {

			instance = new CoinGekoClient();
		}

		return instance;
	}

	public void getMarket(String nameCoin) {
		RestTemplate restTemplate = new RestTemplate();
		Market[] coins = restTemplate.getForObject(urlMarket+currency, Market[].class);
		Object[] list = Arrays.stream((Market[]) coins).filter(x -> x.getName().equalsIgnoreCase(nameCoin)).toArray();
		listMarket.add((Market) list[0]);

	}

	public void getListCoin(String nameCoin) {
		RestTemplate restTemplate = new RestTemplate();
		CoinG[] coins = restTemplate.getForObject(urlListCoin, CoinG[].class);
		Object[] list = Arrays.stream((CoinG[]) coins).filter(x -> x.getName().equalsIgnoreCase(nameCoin)).toArray();
		listCoin.add((CoinG) list[0]);

	}
	
	public Market getInfoCoin(String name) {
		RestTemplate restTemplate = new RestTemplate();
		Market[] coins = restTemplate.getForObject(urlMarket+currency, Market[].class);
		Object[] list = Arrays.stream((Market[]) coins).filter(x -> x.getName().equalsIgnoreCase(name)).toArray();
		return (Market) list[0];
	}
	

	public  List<Market> getListMarket() {
		return listMarket;
	}

	public  List<CoinG> getListCoin() {
		return listCoin;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	


}
