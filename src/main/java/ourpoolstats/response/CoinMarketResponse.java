package ourpoolstats.response;

import ourpoolstats.client.coinmarket.Coin;

public class CoinMarketResponse {
	private String status;
	private String error;
	private Coin coinInfo;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String eroor) {
		this.error = eroor;
	}
	public Coin getCoinInfo() {
		return coinInfo;
	}
	public void setCoinInfo(Coin coinInfo) {
		this.coinInfo = coinInfo;
	}
	
	

}
