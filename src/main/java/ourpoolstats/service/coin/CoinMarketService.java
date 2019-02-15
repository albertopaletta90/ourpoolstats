package ourpoolstats.service.coin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.api.coinmarket.Coin;
import ourpoolstats.api.coinmarket.CoinMarketClient;
import ourpoolstats.mapper.BalanceUserMapper;
import ourpoolstats.mapper.CoinDBMapper;
import ourpoolstats.mapper.CoinMapper;
import ourpoolstats.model.Balance;
import ourpoolstats.model.CoinDB;
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
			if(list.get(i).getName().equals("Bitcoin"))
				btc.movePointLeft(3);
		
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
