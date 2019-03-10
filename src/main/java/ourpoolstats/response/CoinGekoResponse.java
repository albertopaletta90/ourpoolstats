package ourpoolstats.response;

import ourpoolstats.client.coingeko.data.Market;

public class CoinGekoResponse {
	private String status;
	private String eroor;
	private Market coinInfo;
	
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
	public Market getCoinInfo() {
		return coinInfo;
	}
	public void setCoinInfo(Market coinInfo) {
		this.coinInfo = coinInfo;
	}
	
	

}
