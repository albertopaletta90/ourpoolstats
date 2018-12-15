package oupoolstats.service.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.mapper.MessageMapper;
import ourpoolstats.model.Message;
import ourpoolstats.query.QueryChat;
import ourpoolstats.utility.GetConnection;

public class DashboardService implements IDashboardService {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public DashboardService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}

	
	@Override
	public  List<Message> getMessageMittente(String username) {
		List<Message>list = new ArrayList<>();
		list = jdbcTemplate.query(QueryChat.getInstance().getMessageMittente, new MessageMapper(),username);
		return list;
	}

	@Override
	public List<Message> getMessageDestinatario(String username) {
		List<Message>list = new ArrayList<>();
		list = jdbcTemplate.query(QueryChat.getInstance().getMessaggeDestinatario, new MessageMapper(),username);
		return list;
	}

}
