package ourpoolstats.service.dashboard;

import java.util.List;

import ourpoolstats.model.Message;

public interface IDashboardService {
	
	 List<Message> getMessageMittente(String username);
	
	 List<Message> getMessageDestinatario(String username);

}
