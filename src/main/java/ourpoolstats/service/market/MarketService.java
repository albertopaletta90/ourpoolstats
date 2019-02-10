package ourpoolstats.service.market;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.api.coinmarket.Coin;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.type.DataBaseOperation;
import ourpoolstats.utility.GetConnection;

public class MarketService implements IMarketService {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public MarketService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}


	@Override
	public boolean buy(String username, String coin,BigDecimal initialCurrency, BigDecimal totalCurrency,BigDecimal quantity) {
		try {
			jdbcTemplate.update(QueryCoin.getInstance().getBuyCoin(),username,coin,initialCurrency,totalCurrency,quantity);
			return true;
		}catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean sell(int index, DataBaseOperation operation,BigDecimal quantity) {

		switch (operation) {
		case DELETEBALANCE:
			try {
				jdbcTemplate.update(QueryCoin.getInstance().getDeleteCoinBalance(),index);
				System.out.println(QueryCoin.getInstance().getDeleteCoinBalance());
				return true;
			}catch (Exception e) {
				System.out.println(e.getMessage());			
				return false;
			}
		case UPDATEBALANCE:
			try {
				jdbcTemplate.update(QueryCoin.getInstance().getUpdateQuantityCoinBalance(),quantity,index);
				return true;
			}catch (Exception e) {
				System.out.println(e.getMessage());			
				return false;
			}

		}
		return false;
	}


	@Override
	public BigDecimal getCurrentCurrencyCoin(String nameCoin) {
		Coin coin = ManagerCoin.getInstance().getGetCoin().getCoinInfo(nameCoin);
		BigDecimal priceCurrent = BigDecimal.valueOf(coin.getPrice_usd());
		return priceCurrent;
	}

}
