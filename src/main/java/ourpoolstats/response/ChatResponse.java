package ourpoolstats.response;

import java.util.List;

import ourpoolstats.model.Message;

public class ChatResponse {
	
	private  String status ;
	private  String error = "Nessun Errore";
	private  List<Message> messagesReciver;
	private  List<Message> messagesSender;
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
	public List<Message> getMessagesReciver() {
		return messagesReciver;
	}
	public void setMessagesReciver(List<Message> messagesReciver) {
		this.messagesReciver = messagesReciver;
	}
	public List<Message> getMessagesSender() {
		return messagesSender;
	}
	public void setMessagesSender(List<Message> messagesSender) {
		this.messagesSender = messagesSender;
	}
	
	
}
