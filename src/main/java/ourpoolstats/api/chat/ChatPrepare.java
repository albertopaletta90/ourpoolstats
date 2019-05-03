package ourpoolstats.api.chat;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.MessageMapper;
import ourpoolstats.model.Message;
import ourpoolstats.query.QueryChat;
import ourpoolstats.response.ChatResponse;
import ourpoolstats.response.status.ChatResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.GetConnection;

public class ChatPrepare {

	public ResponseEntity<ChatResponse> getMessage(String destinatario,String mittente){
		ChatResponse chatResponse = new ChatResponse();
		try {
			List<Message> messageReciver = GetConnection.getInstance().getJdbcTemplate().query(QueryChat.getInstance().getGetMessaggeDestinatario(), new MessageMapper());
			List<Message> messageSender = GetConnection.getInstance().getJdbcTemplate().query(QueryChat.getInstance().getGetMessageMittente(), new MessageMapper());
			return new ChatResponseStatus().success(chatResponse, LogOperation.CHAT,messageReciver,messageSender);
		} catch (Exception e) {
			return new ChatResponseStatus().error(chatResponse, e, LogOperation.CHAT);
		}
	}
}
