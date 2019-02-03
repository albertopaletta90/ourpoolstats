package ourpoolstats.manager;

import java.util.List;

import oupoolstats.api.coingeko.CoinGekoClient;
import oupoolstats.api.coingeko.data.Market;
import oupoolstats.api.coinmarket.Coin;
import oupoolstats.api.coinmarket.CoinMarketClient;
import oupoolstats.api.cryptopia.remote.data.TradePair;
import oupoolstats.service.coin.CoinMarketService;
import ourpoolstats.type.CryptoCurrency;
import ourpoolstats.type.CurrencyType;
public class ManagerCoin {

	private static ManagerCoin instance;
	private CryptoCurrency cryptoCurrency;
	private List<TradePair>cryptopiaCoin;
	private List<Market>coingekoCoin;
	private List<String>coinListDefault;
	private CoinMarketClient getCoin = new CoinMarketClient();
	private CoinMarketService coinService = new CoinMarketService();
	private List<Coin>listUserCoinMarket; 
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

	public CryptoCurrency getCryptoCurrency() {
		return cryptoCurrency;
	}

	public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
		this.cryptoCurrency = cryptoCurrency;
	}

	public List<TradePair> getCryptopiaCoin() {
		return cryptopiaCoin;
	}

	public void setCryptopiaCoin(List<TradePair> cryptopiaCoin) {
		this.cryptopiaCoin = cryptopiaCoin;
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

	public List<Coin> getListUserCoinMarket() {
		return listUserCoinMarket;
	}

	public void setListUserCoinMarket(List<Coin> listUserCoinMarket) {
		this.listUserCoinMarket = listUserCoinMarket;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}
	
	

}
