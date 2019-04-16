package ourpoolstats.response;

import java.math.BigDecimal;

public class CurrentCoinResponse {
	private String status;
	private String error = "Nessun Errore";
	private BigDecimal value;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	
}
