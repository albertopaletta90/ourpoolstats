package ourpoolstats.model;

import java.math.BigDecimal;

import ourpoolstats.client.coinmarket.CoinMarketClient;

public class CoinDB {

	private int id;
	private String symbol;
	private String name;
	private BigDecimal priceBtc;
	private BigDecimal priceUsd;
	private BigDecimal marketCap;
	private BigDecimal perc_1;
	private BigDecimal perc_24;
	private BigDecimal perc_7;
	private BigDecimal volume;
	private BigDecimal lastUpdate;
	private BigDecimal supplyAvaible;
	private BigDecimal totalSupply;
	private BigDecimal maxSupply;

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
	
	public String getSymbol() {
		return this.symbol = CoinMarketClient.getIcon(name);
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getPerc_7() {
		return perc_7;
	}

	public void setPerc_7(BigDecimal perc_7) {
		this.perc_7 = perc_7;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(BigDecimal lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public BigDecimal getSupplyAvaible() {
		return supplyAvaible;
	}

	public void setSupplyAvaible(BigDecimal supplyAvaible) {
		this.supplyAvaible = supplyAvaible;
	}

	public BigDecimal getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(BigDecimal totalSupply) {
		this.totalSupply = totalSupply;
	}

	public BigDecimal getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(BigDecimal maxSupply) {
		this.maxSupply = maxSupply;
	}	

	
}
