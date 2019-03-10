package ourpoolstats.service.coin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.client.coinmarket.Coin;
import ourpoolstats.client.coinmarket.CoinMarketClient;
import ourpoolstats.mapper.BalanceUserMapper;
import ourpoolstats.mapper.CoinDBMapper;
import ourpoolstats.mapper.StringMapper;
import ourpoolstats.model.Balance;
import ourpoolstats.model.CoinDB;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.response.CoinMarketResponse;
import ourpoolstats.utility.GetConnection;

public class CoinMarketService implements ICoinMarketService {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public CoinMarketService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}


	@Override
	public List<String> getListCoinDefault() {
		List<String>coinList = new ArrayList<>();
		coinList =jdbcTemplate.query(QueryCoin.getInstance().getGetDefaulCoin(), new StringMapper());
		return coinList;
	}


	@Override
	public ResponseEntity<CoinMarketResponse> getCoinInfo(String name) {
		CoinMarketResponse coinMarketResponse = new CoinMarketResponse();
		try {
			CoinMarketClient client = new CoinMarketClient();
			Coin coinInfo = client.getCoinInfo(name);		
			coinMarketResponse.setStatus(HttpStatus.OK.toString());
			coinMarketResponse.setCoinInfo(coinInfo);
			return new ResponseEntity<CoinMarketResponse>(coinMarketResponse,HttpStatus.OK);			
		} catch (Exception e) {
			coinMarketResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			coinMarketResponse.setCoinInfo(null);
			coinMarketResponse.setEroor(e.getMessage());
			return new ResponseEntity<CoinMarketResponse>(coinMarketResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@Override
	public List<Balance> getListCoinUser(String username) {
		try {
			return jdbcTemplate.query(QueryCoin.getInstance().getGetuserCoin(), new BalanceUserMapper() ,username);				
		}catch (Exception e) {
			List<Balance>tmp = new ArrayList<>();
			return tmp;
		}

	}


	@Override
	public void setListCoinDB(List<Coin> list) {
		try {
			jdbcTemplate.update(QueryCoin.getInstance().getDeleteCoin());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for(int i =0; i<list.size(); i++) {
			BigDecimal btc = BigDecimal.valueOf(list.get(i).getPrice_btc());
			BigDecimal usd = BigDecimal.valueOf(list.get(i).getPrice_usd());
			BigDecimal market = BigDecimal.valueOf(list.get(i).getMarket_cap_usd());
			BigDecimal perc_1 = BigDecimal.valueOf(list.get(i).getPercent_change_1h());
			BigDecimal perc_24 = BigDecimal.valueOf(list.get(i).getPercent_change_24h());
			try {
				jdbcTemplate.update(QueryCoin.getInstance().getInsertCoin(),list.get(i).getName(),"user",btc,usd,market,perc_1,perc_24);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}


	@Override
	public List<CoinDB> getListDB() {
		try {
			return jdbcTemplate.query(QueryCoin.getInstance().getGetCoinDB(), new CoinDBMapper());
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
