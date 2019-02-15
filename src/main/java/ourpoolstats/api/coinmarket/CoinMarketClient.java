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
		case "Riple" :
			link = "data:image/png;base64,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";
			break;
		}
		
		
		return link;
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
