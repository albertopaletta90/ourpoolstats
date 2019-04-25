package ourpoolstats.query;

public class QueryChat {
	
	private static QueryChat instance;
	private String getMessageMittente = "select mesage from message_private where username_mittente = ?";
	private String getMessaggeDestinatario = "select mesage from message_private where username_destinatario = ?";
	private String sendMessage = "insert into message (messaggio,username_mittente,username_destinatario) values = ?";
	
	private QueryChat() {}
	
	public static QueryChat getInstance() {
		
		if(instance == null) {
			instance = new QueryChat();
		}
		
		return instance;
	}

	public String getGetMessageMittente() {
		return getMessageMittente;
	}

	public String getGetMessaggeDestinatario() {
		return getMessaggeDestinatario;
	}

	public String getSendMessage() {
		return sendMessage;
	}
	
}
