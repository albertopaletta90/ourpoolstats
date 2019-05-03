package ourpoolstats.api.chat;

import java.util.GregorianCalendar;

import org.springframework.http.ResponseEntity;

import ourpoolstats.query.QueryChat;
import ourpoolstats.response.ChatResponse;
import ourpoolstats.response.status.ChatResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.GetConnection;

public class ChatExexute {

	public ResponseEntity<ChatResponse> sendMessage(String destinatario,String mittente,String message){
		ChatResponse chatResponse = new ChatResponse();
		try {
			GetConnection.getInstance().getJdbcTemplate().update(QueryChat.getInstance().getSendMessage(),
																 message,
																 mittente,
																 destinatario,
																 new GregorianCalendar());
			return new ChatResponseStatus().success(chatResponse,LogOperation.CHAT,null,null);
		} catch (Exception e) {
			return new ChatResponseStatus().error(chatResponse,e,LogOperation.CHAT);
		}
	}

}
