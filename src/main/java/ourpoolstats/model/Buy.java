package ourpoolstats.model;

import java.math.BigDecimal;

public class Buy {

	private int indexCoin;
	private BigDecimal quantity;

	public int getIndexCoin() {
		return indexCoin;
	}
	public void setIndexCoin(int indexCoin) {
		this.indexCoin = indexCoin;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
