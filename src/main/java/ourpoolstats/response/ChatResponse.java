package ourpoolstats.response;

import java.util.List;

import ourpoolstats.model.Message;

public class ChatResponse {
	
	private  String status ;
	private  String error = "Nessun Errore";
	private  List<Message> messages;
	
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
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}	
}
