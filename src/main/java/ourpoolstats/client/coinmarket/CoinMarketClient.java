package ourpoolstats.client.coinmarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.client.RestTemplate;

import ourpoolstats.client.coingeko.CoinGekoClient;


public class CoinMarketClient {
	private String url = "https://api.coinmarketcap.com/v1/ticker/";
	private List<Coin>listCoin = new ArrayList<Coin>();
	
	public void getCoin(String nameCoin) {
		RestTemplate restTemplate = new RestTemplate();
		Coin[] coins = restTemplate.getForObject(url, Coin[].class);
		Object[] list = Arrays.stream((Coin[]) coins).filter(x -> x.getName().equalsIgnoreCase(nameCoin)).toArray();
		listCoin.add((Coin) list[0]);
		
	}
	
	public Coin getCoinInfo(String nameCoin) {
		RestTemplate restTemplate = new RestTemplate();
		Coin[] coins = restTemplate.getForObject(url, Coin[].class);
		Object[] list = Arrays.stream((Coin[]) coins).filter(x -> x.getName().equalsIgnoreCase(nameCoin)).toArray();
		return (Coin) list[0];
		
	}
	
	public static String getIcon(String name) {
		return CoinGekoClient.GetInstance().getInfoCoin(name).getImage();
	}

	public List<Coin> getList() {
		return listCoin;
		
	}

	public void deleteList() {
		
		if(!listCoin.isEmpty())
			listCoin.clear();
		
	}
	
	public static void  setNameInfoCoin(String value,HttpServletRequest request) {
		request.getSession().setAttribute("coin", value);
		
	}
	

}
