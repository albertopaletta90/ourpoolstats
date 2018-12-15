package ourpoolstats.query;

public class QueryChat {
	
	private static QueryChat instance;
	public String getMessageMittente = "select mesage from message_private where username_mittente = ?";
	public String getMessaggeDestinatario = "select mesage from message_private where username_destinatario = ?";
	
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
	
	


}
