package ourpoolstats.manager;

import ourpoolstats.myenum.CryptoCurrency;

import java.util.List;

import oupoolstats.api.cryptopia.remote.data.Currency;
public class ManagerCoin {

	private static ManagerCoin instance;
	private CryptoCurrency cryptoCurrency;
	private List<Currency>cryptopiaCoin;
	

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

	public List<Currency> getCryptopiaCoin() {
		return cryptopiaCoin;
	}

	public void setCryptopiaCoin(List<Currency> cryptopiaCoin) {
		this.cryptopiaCoin = cryptopiaCoin;
	}
	
	
	
}
