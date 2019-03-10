package ourpoolstats.response;

import ourpoolstats.client.coinmarket.Coin;

public class CoinMarketResponse {
	private String status;
	private String eroor;
	private Coin coinInfo;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEroor() {
		return eroor;
	}
	public void setEroor(String eroor) {
		this.eroor = eroor;
	}
	public Coin getCoinInfo() {
		return coinInfo;
	}
	public void setCoinInfo(Coin coinInfo) {
		this.coinInfo = coinInfo;
	}
	
	

}
