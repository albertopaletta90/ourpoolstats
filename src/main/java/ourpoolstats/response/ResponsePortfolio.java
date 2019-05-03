package ourpoolstats.response;

import java.util.ArrayList;
import java.util.List;

import ourpoolstats.model.Portfolio;

public class ResponsePortfolio {

	private String status;
	private String error = "Nessun Errore";
	private List<Portfolio>portfolio = new ArrayList<>();
	private List<Portfolio>listPartecipant = new ArrayList<>();
	
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
	public List<Portfolio> getMaster() {
		return portfolio;
	}
	public void setPortfolio(List<Portfolio> portfolio) {
		this.portfolio = portfolio;
	}
	public List<Portfolio> getPartecipant() {
		return listPartecipant;
	}
	public void setListPartecipant(List<Portfolio> listPartecipant) {
		this.listPartecipant = listPartecipant;
	}
	
	
}
