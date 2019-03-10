package ourpoolstats.response;

import java.util.List;

import ourpoolstats.client.coingeko.data.Market;

public class CoinGekoListResponse {
	private String status ="OK";
	private String error ="Nessun Errore";
	private List<Market> coingekoList;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Market> getCoingekoList() {
		return coingekoList;
	}

	public void setCoingekoList(List<Market> coingekoList) {
		this.coingekoList = coingekoList;
	}
	
	
	
}
