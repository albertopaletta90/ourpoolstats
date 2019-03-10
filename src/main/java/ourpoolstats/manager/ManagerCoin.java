package ourpoolstats.manager;

import java.util.List;

import ourpoolstats.client.coingeko.CoinGekoClient;
import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.client.coinmarket.CoinMarketClient;
import ourpoolstats.model.CoinDB;
import ourpoolstats.service.coin.CoinMarketService;
import ourpoolstats.service.market.MarketService;
import ourpoolstats.type.CryptoCurrency;
import ourpoolstats.type.CurrencyType;
public class ManagerCoin {

	private static ManagerCoin instance;
	private CryptoCurrency cryptoCurrency;
	private List<Market>coingekoCoin;
	private List<String>coinListDefault;
	private List<CoinDB> listCoin = null;
	private CoinMarketClient getCoin = new CoinMarketClient();
	private CoinMarketService coinService = new CoinMarketService();
	private MarketService marketService = new MarketService(); 	

	private CurrencyType currencyType = CurrencyType.EURO;
	

	private ManagerCoin() {}

	public static ManagerCoin getInstance() {

		if(instance == null) {

			instance = new ManagerCoin();
		}
		return instance;
	}
	
	public void setMoneyListCoinGeko() {
		
		if(!CoinGekoClient.GetInstance().getListMarket().isEmpty())
			CoinGekoClient.GetInstance().getListMarket().clear();
		
		for(int i = 0;	i<this.coinListDefault.size(); i++)
			CoinGekoClient.GetInstance().getMarket(this.coinListDefault.get(i));

	}
	
	public void setMoneyListCoinMarket() {
		for (String element : ManagerCoin.getInstance().getCoinListDefault()) {
			this.getCoin.getCoin(element);
		}
		
	}
	
//	public BigDecimal getSumCurrency() {
//		BigDecimal sum = new BigDecimal("0");
//		for (Balance element : listUserBalance) {
//			sum = sum.add(element.getTotalCurrency());
//		}
//		return sum;
//	}

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

	public List<String> getCoinListDefault() {
		return coinListDefault;
	}

	public void setCoinListDefault(List<String> coinListDefault) {
		this.coinListDefault = coinListDefault;
	}

	public CoinMarketClient getGetCoin() {
		return getCoin;
	}

	public void setGetCoin(CoinMarketClient getCoin) {
		this.getCoin = getCoin;
	}

	public CoinMarketService getCoinService() {
		return coinService;
	}

	public void setCoinService(CoinMarketService coinService) {
		this.coinService = coinService;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	public MarketService getMarketService() {
		return marketService;
	}
	
	public List<CoinDB> getListCoin() {
		return listCoin;
	}

	public void setListCoin(List<CoinDB> listCoin) {
		this.listCoin = listCoin;
	}


	
	

}
