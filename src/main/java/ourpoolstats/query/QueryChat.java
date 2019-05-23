package ourpoolstats.query;

public class QueryChat {
	
	private static QueryChat instance;
	private String getMessageMittente = "select message,username_mittente,date_message from message_private where username_mittente = (?)";
	private String getMessaggeDestinatario = "select message,username_mittente,date_message from message_private where username_mittente = (?)";
	private String sendMessage = "insert into message_private (message,username_mittente,username_destinatario,date_message) values(?,?,?,?)";
	
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
