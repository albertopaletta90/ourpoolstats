package ourpoolstats.model;

import java.math.BigDecimal;

public class Portfolio {

	private int id;
	private String username;
	private String userType;
	private String nameCoin;
	private BigDecimal priceInitial;
	private BigDecimal priceCurrent;
	private BigDecimal quantity;
	private boolean partecipant;
	private String nameCoinPartecipant;
	
	public Portfolio() {}

	public Portfolio(int i, String u,String ut,String n,BigDecimal pI,BigDecimal pC,BigDecimal q) {
		this.id =i;
		this.username = u;
		this.userType = ut;
		this.nameCoin = n;
		this.priceInitial = pI;
		this.priceCurrent = pC;
		this.quantity = q;		
	}

	public Portfolio(String u,String ut,String name ,BigDecimal pI,BigDecimal pC,BigDecimal q) {
		this.username = u;
		this.userType = ut;
		this.nameCoin = name;
		this.priceInitial = pI;
		this.priceCurrent = pC;
		this.quantity = q;		
	}
	
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getNameCoin() {
		return nameCoin;
	}

	public void setNameCoin(String nameCoin) {
		this.nameCoin = nameCoin;
	}

	public BigDecimal getPriceInitial() {
		return priceInitial;
	}

	public void setPriceInitial(BigDecimal priceInitial) {
		this.priceInitial = priceInitial;
	}

	public BigDecimal getPriceCurrent() {
		return priceCurrent;
	}

	public void setPriceCurrent(BigDecimal priceCurrent) {
		this.priceCurrent = priceCurrent;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public boolean isPartecipant() {
		return partecipant;
	}

	public void setPartecipant(boolean partecipant) {
		this.partecipant = partecipant;
	}

	public String getNameCoinPartecipant() {
		return nameCoinPartecipant;
	}

	public void setNameCoinPartecipant(String nameCoinPartecipant) {
		this.nameCoinPartecipant = nameCoinPartecipant;
	}

	public void setEmptyParams() {
		this.id =0;
		this.username = "";
		this.userType = "";
		this.nameCoin = "";
		this.priceInitial = BigDecimal.valueOf(0);
		this.priceCurrent = BigDecimal.valueOf(0);
		this.quantity = BigDecimal.valueOf(0);
		
	}
	
	

}
