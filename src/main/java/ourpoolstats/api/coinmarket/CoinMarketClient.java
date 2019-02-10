package ourpoolstats.api.coinmarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.client.RestTemplate;


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
		String link ="https://chainz.cryptoid.info/logo/btc.png";
		switch (name) {
		case "BitCoin":
			link = "https://chainz.cryptoid.info/logo/btc.png";
			break;
		case "Ethereum":
			link = "https://cdn-images-1.medium.com/max/1600/1*h0DFnjYAFAZIYoJ_d4-qwQ.png";
			break;
		case "Verge":
			link = "https://cryptoncy.net/upload/000/u2/55/38/verge-photo-normal.png";
			break;
		case "Litecoin":
			link = "https://www.money.it/local/cache-vignettes/L128xH128/litecoin-e806e.png?1525418932";
			break;
		case "Kin":
			link = "https://s2.coinmarketcap.com/static/img/coins/32x32/1993.png";
			break;
		case "Monero" :
			link = "https://crypta.money/wp-content/uploads/2018/03/Monero-150x150.png";
			break;
		}
		
		
		return link;
	}

	public List<Coin> getList() {
		System.out.println("jkasdhuiwfhuiwehf " + listCoin.size());
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
