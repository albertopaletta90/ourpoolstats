package ourpoolstats.response;

import java.util.List;

import ourpoolstats.model.Balance;

public class BalanceResponse {
	
	private String status;
	private String error ="Nessun Errore";
	private List<Balance>balance;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setEroor(String eroor) {
		this.error = eroor;
	}
	public List<Balance> getBalance() {
		return balance;
	}
	public void setBalance(List<Balance> balance) {
		this.balance = balance;
	}
	
	

}
