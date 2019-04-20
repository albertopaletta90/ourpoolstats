package ourpoolstats.response;

import java.util.ArrayList;
import java.util.List;

public class Response {
	private String status;
	private String error = "Nessun Errore";
	private List<String> data = new ArrayList<>();

	public Response() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEror() {
		return error;
	}

	public void setError(String eror) {
		this.error = eror;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	
	
	

	
}
