package ourpoolstats.api.coingeko.data;

import java.util.Date;

public class Market {
	

	private String id;
	private String symbol;
	private String name;
	private String image;
	private float current_price;
	private float market_cap;
	private float market_cap_rank;
	private float total_volume;
	private float high_24h;
	private float low_24h;
	private float price_change_24h;
	private float price_change_percentage_24h;
	private float market_cap_change_24h;
	private float market_cap_change_percentage_24h;
	private float circulating_supply;
	private float total_supply;
	private float ath;
	private float ath_change_percentage;
	private Date ath_date;
	
	private Date last_updated;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(float current_price) {
		this.current_price = current_price;
	}
	public float getMarket_cap() {
		return market_cap;
	}
	public void setMarket_cap(float market_cap) {
		this.market_cap = market_cap;
	}
	public float getMarket_cap_rank() {
		return market_cap_rank;
	}
	public void setMarket_cap_rank(float market_cap_rank) {
		this.market_cap_rank = market_cap_rank;
	}
	public float getTotal_volume() {
		return total_volume;
	}
	public void setTotal_volume(float total_volume) {
		this.total_volume = total_volume;
	}
	public float getHigh_24h() {
		return high_24h;
	}
	public void setHigh_24h(float high_24h) {
		this.high_24h = high_24h;
	}
	public float getLow_24h() {
		return low_24h;
	}
	public void setLow_24h(float low_24h) {
		this.low_24h = low_24h;
	}
	public float getPrice_change_24h() {
		return price_change_24h;
	}
	public void setPrice_change_24h(float price_change_24h) {
		this.price_change_24h = price_change_24h;
	}
	public float getPrice_change_percentage_24h() {
		return price_change_percentage_24h;
	}
	public void setPrice_change_percentage_24h(float price_change_percentage_24h) {
		this.price_change_percentage_24h = price_change_percentage_24h;
	}
	public float getMarket_cap_change_24h() {
		return market_cap_change_24h;
	}
	public void setMarket_cap_change_24h(float market_cap_change_24h) {
		this.market_cap_change_24h = market_cap_change_24h;
	}
	public float getMarket_cap_change_percentage_24h() {
		return market_cap_change_percentage_24h;
	}
	public void setMarket_cap_change_percentage_24h(float market_cap_change_percentage_24h) {
		this.market_cap_change_percentage_24h = market_cap_change_percentage_24h;
	}
	public float getCirculating_supply() {
		return circulating_supply;
	}
	public void setCirculating_supply(float circulating_supply) {
		this.circulating_supply = circulating_supply;
	}
	public float getTotal_supply() {
		return total_supply;
	}
	public void setTotal_supply(float total_supply) {
		this.total_supply = total_supply;
	}
	public float getAth() {
		return ath;
	}
	public void setAth(float ath) {
		this.ath = ath;
	}
	public float getAth_change_percentage() {
		return ath_change_percentage;
	}
	public void setAth_change_percentage(float ath_change_percentage) {
		this.ath_change_percentage = ath_change_percentage;
	}
	public Date getAth_date() {
		return ath_date;
	}
	public void setAth_date(Date ath_date) {
		this.ath_date = ath_date;
	}
//	public String getRoi() {
//		return roi;
//	}
//	public void setRoi(String roi) {
//		this.roi = roi;
//	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}

	
	
}
