package oupoolstats.service.coin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import oupoolstats.api.coinmarket.Coin;
import oupoolstats.api.coinmarket.CoinMarketClient;
import ourpoolstats.mapper.CoinMapper;
import ourpoolstats.mapper.CoinUserMapper;
import ourpoolstats.query.QueryCoin;
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
		coinList =jdbcTemplate.query(QueryCoin.getInstance().getGetDefaulCoin(), new CoinMapper());
		return coinList;
	}


	@Override
	public Coin getCoinInfo(String name) {
		CoinMarketClient client = new CoinMarketClient();
		return client.getCoinInfo(name);		
	}


	@Override
	public List<Coin> getListCoinUser(String username) {
		try {
			return jdbcTemplate.query(QueryCoin.getInstance().getGetuserCoin(), new CoinUserMapper() ,username);				
		}catch (Exception e) {
			List<Coin>tmp = new ArrayList<>();
			return tmp;
		}

	}

}
