package ourpoolstats.utility.connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class GetConnection {
	public static GetConnection instance;
	private SetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	private GetConnection() {
		setConnection();
	}

	public static GetConnection getInstance() {

		if(instance == null) {
			instance = new GetConnection();
		}

		return instance;
	}

	private void setConnection() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(SetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}

	public SetConnection getGetConnection() {
		return getConnection;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	

}
