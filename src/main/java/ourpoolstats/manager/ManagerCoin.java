package ourpoolstats.manager;

import java.util.List;

import ourpoolstats.client.coingeko.CoinGekoClient;
import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.client.coinmarket.CoinMarketClient;
import ourpoolstats.model.CoinDB;
import ourpoolstats.type.CryptoCurrency;
import ourpoolstats.type.CurrencyType;
public class ManagerCoin {

	private static ManagerCoin instance;
	private CryptoCurrency cryptoCurrency;
	private List<Market>coingekoCoin;
	private List<CoinDB> listCoin = null;
	private CoinMarketClient coinMarketClient = new CoinMarketClient();

	private CurrencyType currencyType = CurrencyType.EURO;
	

	private ManagerCoin() {}

	public static ManagerCoin getInstance() {

		if(instance == null) {

			instance = new ManagerCoin();
		}
		return instance;
	}
	
	public void setMoneyListCoinGeko(List<String>listDefault) {
		
		if(!CoinGekoClient.GetInstance().getListMarket().isEmpty())
			CoinGekoClient.GetInstance().getListMarket().clear();
		
		for(int i = 0;	i<listDefault.size(); i++)
			CoinGekoClient.GetInstance().getMarket(listDefault.get(i));

	}
	
	public void setMoneyListCoinMarket(List<String>listDefault) {
		if(!coinMarketClient.getList().isEmpty())
			coinMarketClient.deleteList();
		
		for (String element : listDefault) {
			this.coinMarketClient.getCoin(element);
		}
		
	}

	public CryptoCurrency getCryptoCurrency() {
		return cryptoCurrency;
	}

	public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
	}

	public List<Market> getCoingekoCoin() {
		return coingekoCoin;
	}

	public void setCoingekoCoin(List<Market> coingekoCoin) {
		this.coingekoCoin = coingekoCoin;
	}

	public CoinMarketClient getGetCoin() {
		return coinMarketClient;
	}

	public void setGetCoin(CoinMarketClient getCoin) {
		this.coinMarketClient = getCoin;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	
	public List<CoinDB> getListCoin() {
		return listCoin;
	}

	public void setListCoin(List<CoinDB> listCoin) {
		this.listCoin = listCoin;
	}


	
	

}
