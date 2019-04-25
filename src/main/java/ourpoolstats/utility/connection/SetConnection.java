package ourpoolstats.utility.connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SetConnection {
	public static SetConnection instance;
	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	private SetConnection() {
		setConnection();
	}

	public static SetConnection getInstance() {

		if(instance == null) {
			instance = new SetConnection();
		}

		return instance;
	}

	private void setConnection() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}

	public GetConnection getGetConnection() {
		return getConnection;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	

}
