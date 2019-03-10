package ourpoolstats.response;

import java.util.List;

import ourpoolstats.model.CoinDB;

public class CoinMarketListResponse {
	
	private String status ="OK";
	private String error ="Nessun Errore";
	
	private List<CoinDB> coinMarketList;
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
	public List<CoinDB> getCoinMarketList() {
		return coinMarketList;
	}
	public void setCoinMarketList(List<CoinDB> coinMarketList) {
		this.coinMarketList = coinMarketList;
	}
	
	
}
