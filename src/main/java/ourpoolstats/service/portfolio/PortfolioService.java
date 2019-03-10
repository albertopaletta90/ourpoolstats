package ourpoolstats.service.portfolio;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.mapper.PortfolioMapper;
import ourpoolstats.model.Portfolio;
import ourpoolstats.query.QueryPortfolio;
import ourpoolstats.response.ResponsePortfolio;
import ourpoolstats.utility.GetConnection;

public class PortfolioService implements IportfolioService{

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public PortfolioService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}


	@Override
	public ResponseEntity<ResponsePortfolio> insertToPortfolio(Portfolio portfolio) {
		ResponsePortfolio responsePortfolio = new ResponsePortfolio();
		try {
			jdbcTemplate.update(QueryPortfolio.getInstance().getInsertToPotfolio(),portfolio.getUsername(),portfolio.getUserType(),portfolio.getNameCoin(),portfolio.getPriceInitial(),portfolio.getPriceCurrent(),portfolio.getQuantity());
			return succes(responsePortfolio, null, null);
		} catch (Exception e) {
			return error(responsePortfolio,e);
		}

	}

	@Override
	public ResponseEntity<ResponsePortfolio> deleteCoinToPortfolio(String name,String username) {
		ResponsePortfolio portfolio = new ResponsePortfolio();
		try {
			int id = jdbcTemplate.query(QueryPortfolio.getInstance().getGetPortfolioUser(), new PortfolioMapper(),username).get(0).getId();
			jdbcTemplate.update(QueryPortfolio.getInstance().getDeleteCoinToPortfolio(),id);
			return succes(portfolio, null, null);
		} catch (Exception e) {
			return error(portfolio,e);
		}

	}

	@Override
	public ResponseEntity<ResponsePortfolio> getCoinToPortfolio(String username) {
		ResponsePortfolio responsePortfolio = new ResponsePortfolio();
		try {
			List<Portfolio>list = jdbcTemplate.query(QueryPortfolio.getInstance().getGetPortfolioUser(), new PortfolioMapper(),username);
			if(list.isEmpty())
				return listNotFound(responsePortfolio);
			if(list.get(0).getUserType().equals("MASTER")) {
				List<Portfolio>listPartecipant = jdbcTemplate.query(QueryPortfolio.getInstance().getGetPortfolioPartecipant(), new PortfolioMapper(),list.get(0).getUsername());
				return succes(responsePortfolio, list,listPartecipant);
			}
			return succes(responsePortfolio,list,null);
		}catch (Exception e) {
	
		}
		return null;
	}

	
	private ResponseEntity<ResponsePortfolio> succes(ResponsePortfolio responsePortfolio, List<Portfolio> list,List<Portfolio> listPartecipant) {
		responsePortfolio.setStatus(HttpStatus.OK.toString());
		responsePortfolio.setPortfolio(list);
		responsePortfolio.setListPartecipant(listPartecipant);
		return new ResponseEntity<ResponsePortfolio>(responsePortfolio,HttpStatus.OK);
	}


	private ResponseEntity<ResponsePortfolio> listNotFound(ResponsePortfolio responsePortfolio) {
		responsePortfolio.setStatus(HttpStatus.NOT_FOUND.toString());
		responsePortfolio.setPortfolio(null);
		responsePortfolio.setError("Lista Non Trovata");
		return new ResponseEntity<ResponsePortfolio>(responsePortfolio,HttpStatus.NOT_FOUND);
	}


	private ResponseEntity<ResponsePortfolio> error(ResponsePortfolio portfolio, Exception e) {
		portfolio.setPortfolio(null);
		portfolio.setError(e.getMessage());
		portfolio.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<ResponsePortfolio>(portfolio,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
