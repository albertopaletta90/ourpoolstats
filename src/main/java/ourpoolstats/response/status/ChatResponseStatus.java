package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.model.Message;
import ourpoolstats.response.ChatResponse;
import ourpoolstats.type.LogOperation;

public class ChatResponseStatus {

	public ResponseEntity<ChatResponse> success(ChatResponse chatResponse,LogOperation operation,List<Message> messageReciver,List<Message> messageSender) {
		chatResponse.setStatus(HttpStatus.OK.toString());
		chatResponse.setError("Nessun Errore");
		chatResponse.setMessagesReciver(messageReciver);
		chatResponse.setMessagesSender(messageSender);
		return new ResponseEntity<ChatResponse>(chatResponse,HttpStatus.OK);
	}

	public ResponseEntity<ChatResponse> error(ChatResponse chatResponse, Exception e, LogOperation operation) {
		chatResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		chatResponse.setError("Errore Tecnico " + e.getMessage());
		return new ResponseEntity<ChatResponse>(chatResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
