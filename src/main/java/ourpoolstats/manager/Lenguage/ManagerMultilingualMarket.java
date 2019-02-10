package ourpoolstats.manager.Lenguage;

public class ManagerMultilingualMarket {

	private static ManagerMultilingualMarket instance;
	
	private String nomeCoin = "Moneta";
	private String quantity = "Quantità";
	private String changeBtc = "Valore Iniziale";
	private String currencyTotal = "Valore Totale";
	private String currencyCurrent = "Valore Corrente";
	private String sell = "Vendi";
	private String buy = "Compra";
	private String errorChoiche = "Devi Selezionare Almeno Una Moneta o una quantità";
	private ManagerMultilingualMarket() {}

	public static ManagerMultilingualMarket getInstance() {

		if(instance == null) {
			instance = new ManagerMultilingualMarket();

		}

		return instance;
	}

	public String getNomeCoin() {
		return nomeCoin;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getChangeBtc() {
		return changeBtc;
	}

	public String getCurrencyTotal() {
		return currencyTotal;
	}

	public String getSell() {
		return sell;
	}

	public String getBuy() {
		return buy;
	}

	public String getCurrencyCurrent() {
		return currencyCurrent;
	}

	public String getErrorChoiche() {
		return errorChoiche;
	}

	
	

}
