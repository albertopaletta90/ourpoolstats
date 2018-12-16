package ourpoolstats.manager;

import ourpoolstats.myenum.CryptoCurrency;

import java.util.List;

import oupoolstats.api.cryptopia.remote.data.Currency;
import oupoolstats.api.cryptopia.remote.data.TradePair;
public class ManagerCoin {

	private static ManagerCoin instance;
	private CryptoCurrency cryptoCurrency;
	private List<TradePair>cryptopiaCoin;
	

	private ManagerCoin() {}

	public static ManagerCoin getInstance() {

		if(instance == null) {

			instance = new ManagerCoin();
		}
		return instance;
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
	
	
	
}
