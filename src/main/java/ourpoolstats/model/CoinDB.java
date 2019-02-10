package ourpoolstats.model;

import java.math.BigDecimal;

public class CoinDB {

	private int id;
	private String name;
	private BigDecimal priceBtc;
	private BigDecimal priceUsd;
	private BigDecimal marketCap;
	private BigDecimal perc_1;
	private BigDecimal perc_24;
	
	
	public CoinDB() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPriceBtc() {
		return priceBtc;
	}

	public void setPriceBtc(BigDecimal priceBtc) {
		this.priceBtc = priceBtc;
	}

	public BigDecimal getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(BigDecimal priceUsd) {
		this.priceUsd = priceUsd;
	}

	public BigDecimal getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(BigDecimal marketCap) {
		this.marketCap = marketCap;
	}

	public BigDecimal getPerc_1() {
		return perc_1;
	}

	public void setPerc_1(BigDecimal perc_1) {
		this.perc_1 = perc_1;
	}

	public BigDecimal getPerc_24() {
		return perc_24;
	}

	public void setPerc_24(BigDecimal perc_24) {
		this.perc_24 = perc_24;
	}
	
	
	

}
