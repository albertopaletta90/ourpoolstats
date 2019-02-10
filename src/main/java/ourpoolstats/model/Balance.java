package ourpoolstats.model;

import java.math.BigDecimal;

public class Balance {

	private int id;
	private String username;
	private String nameCoin;
	private BigDecimal initialCurrency;
	private BigDecimal currentCurrency;
	private BigDecimal totalCurrency;
	private BigDecimal quantity;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNameCoin() {
		return nameCoin;
	}
	public void setNameCoin(String nameCoin) {
		this.nameCoin = nameCoin;
	}
	public BigDecimal getInitialCurrency() {
		return initialCurrency;
	}
	public void setInitialCurrency(BigDecimal initialCurrency) {
		this.initialCurrency = initialCurrency;
	}
	public BigDecimal getCurrentCurrency() {
		return currentCurrency;
	}
	public void setCurrentCurrency(BigDecimal currentCurrency) {
		this.currentCurrency = currentCurrency;
	}
	public BigDecimal getTotalCurrency() {
		return totalCurrency;
	}
	public void setTotalCurrency(BigDecimal totalCurrency) {
		this.totalCurrency = totalCurrency;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	
}
