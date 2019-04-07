package ourpoolstats.model;

import java.math.BigDecimal;

import org.springframework.ui.ModelMap;

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

	public void setAllParameter(ModelMap model) {
		this.indexCoin = Integer.parseInt((String)model.get("coin"));
		this.quantity = new BigDecimal((String) model.get("quantity"));
	}

}