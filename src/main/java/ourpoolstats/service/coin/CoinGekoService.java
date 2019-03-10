package ourpoolstats.service.coin;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.client.coingeko.CoinGekoClient;
import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.response.CoinGekoResponse;
import ourpoolstats.utility.GetConnection;

public class CoinGekoService implements ICoinGekoService {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public CoinGekoService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}



	@Override
	public List<Market> getList() {
		return CoinGekoClient.GetInstance().getListMarket();

	}



	@Override
	public ResponseEntity<CoinGekoResponse> getCoinInfo(String name) {
		CoinGekoResponse coinGekoResponse = new CoinGekoResponse();
		try {
			Market coingeko = CoinGekoClient.GetInstance().getInfoCoin(name);
			coinGekoResponse.setStatus(HttpStatus.OK.toString());
			coinGekoResponse.setCoinInfo(coingeko);
			return new ResponseEntity<CoinGekoResponse>(coinGekoResponse,HttpStatus.OK);				
		} catch (Exception e) {
			coinGekoResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			coinGekoResponse.setCoinInfo(null);
			coinGekoResponse.setEroor(e.getMessage());		
			return new ResponseEntity<CoinGekoResponse>(coinGekoResponse,HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}




}
