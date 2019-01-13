package oupoolstats.api.coingeko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import oupoolstats.api.coingeko.data.Coin;
import oupoolstats.api.coingeko.data.Market;


public class CoinGekoClient {
	private static  CoinGekoClient instance ;
	private static String urlMarket = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";
	private static String urlListCoin = "https://api.coingecko.com/api/v3/coins/list";
	private  List<Market>listMarket = new ArrayList<Market>();
	private  List<Coin>listCoin = new ArrayList<Coin>();

	private CoinGekoClient() {}

	public static CoinGekoClient GetInstance() {

		if(instance == null) {

			instance = new CoinGekoClient();
		}

		return instance;
	}

	public void getMarket(String nameCoin) {
		RestTemplate restTemplate = new RestTemplate();
		Market[] coins = restTemplate.getForObject(urlMarket, Market[].class);
		Object[] list = Arrays.stream((Market[]) coins).filter(x -> x.getName().equalsIgnoreCase(nameCoin)).toArray();
		listMarket.add((Market) list[0]);

	}

	public void getListCoin(String nameCoin) {
		RestTemplate restTemplate = new RestTemplate();
		Coin[] coins = restTemplate.getForObject(urlListCoin, Coin[].class);
		Object[] list = Arrays.stream((Coin[]) coins).filter(x -> x.getName().equalsIgnoreCase(nameCoin)).toArray();
		listCoin.add((Coin) list[0]);

	}

	public  List<Market> getListMarket() {
		return listMarket;
	}

	public  List<Coin> getListCoin() {
		return listCoin;
	}



}
