package oupoolstats.service.language;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.mapper.LanguageMapper;
import ourpoolstats.myenum.LenguageType;
import ourpoolstats.query.QueryLanguage;
import ourpoolstats.utility.GetConnection;

public class LanguageService implements ILanguageService {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public LanguageService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}
	
	@Override
	public LenguageType getLenguace(String Username) {
		return jdbcTemplate.query(QueryLanguage.getInstance().getGetLanguage(),new LanguageMapper(), Username).get(0).getLenguageType();
	}

	@Override
	public void setLenguace(String l,String u) {
		jdbcTemplate.update(QueryLanguage.getInstance().getSetLanguage(),l,u);

	}

	@Override
	public void insertLenguace(String u, String l) {
		jdbcTemplate.update(QueryLanguage.getInstance().getSetLanguage(),u,l);
		
	}

}
