package ourpoolstats.service.language;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.manager.ManagerImage;
import ourpoolstats.mapper.LanguageMapper;
import ourpoolstats.query.QueryLanguage;
import ourpoolstats.response.Response;
import ourpoolstats.type.LenguageType;
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
		jdbcTemplate.update(QueryLanguage.getInstance().getInsertLanguage(),u,l);
		
	}

	@Override
	public ResponseEntity<Response> changeLanguage(String username, String lenguageType) {
		Response response = new Response();
		try {
			response.setStatus(HttpStatus.OK.toString());
			response.getData().add(lenguageType);
			setLenguace(lenguageType, username);
			ManagerImage.getInstance().setImageDefault(lenguageType);
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.setEror(e.getMessage());
			ManagerImage.getInstance().setImageDefault(lenguageType);
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
