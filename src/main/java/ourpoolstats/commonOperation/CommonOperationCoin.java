package ourpoolstats.commonOperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ourpoolstats.client.coingeko.CoinGekoClient;
import ourpoolstats.client.coingeko.data.Market;
import ourpoolstats.client.coinmarket.Coin;
import ourpoolstats.log.OperationDBLogger;
import ourpoolstats.manager.ManagerCoin;
import ourpoolstats.mapper.BalanceUserMapper;
import ourpoolstats.mapper.CoinDBMapper;
import ourpoolstats.mapper.StringMapper;
import ourpoolstats.model.Balance;
import ourpoolstats.model.CoinDB;
import ourpoolstats.query.QueryCoin;
import ourpoolstats.type.DataBaseOperation;
import ourpoolstats.utility.connection.GetConnection;

public class CommonOperationCoin {
	
	public List<String> getListCoinDefault() {
		List<String>coinList = new ArrayList<>();
		coinList = GetConnection.getInstance().getJdbcTemplate().query(QueryCoin.getInstance().getGetDefaulCoin(), new StringMapper());
		return coinList;
	}

	public List<Balance> getListCoinUser(String username) {
		try {
			return GetConnection.getInstance().getJdbcTemplate().query(QueryCoin.getInstance().getGetuserCoin(), new BalanceUserMapper() ,username);				
		}catch (Exception e) {
			List<Balance>tmp = new ArrayList<>();
			return tmp;
		}
	}

	public void setListCoinDB(List<Coin> list) {
		try {
			GetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getDeleteCoinDefault());
		}catch (Exception e) {
		
		}

		for(int i =0; i<list.size(); i++) {
			BigDecimal btc = BigDecimal.valueOf(list.get(i).getPrice_btc());
			BigDecimal usd = BigDecimal.valueOf(list.get(i).getPrice_usd());
			BigDecimal market = BigDecimal.valueOf(list.get(i).getMarket_cap_usd());
			BigDecimal perc_1 = BigDecimal.valueOf(list.get(i).getPercent_change_1h());
			BigDecimal perc_24 = BigDecimal.valueOf(list.get(i).getPercent_change_24h());
			BigDecimal perc_7 = BigDecimal.valueOf(list.get(i).getPercent_change_7d());
			BigDecimal volume = BigDecimal.valueOf(list.get(i).get_24h_volume_usd());
			BigDecimal lastUpdate = BigDecimal.valueOf(list.get(i).getLast_updated());
			BigDecimal supplyAvaible = BigDecimal.valueOf(list.get(i).getAvailable_supply());
			BigDecimal totalSupply = BigDecimal.valueOf(list.get(i).getTotal_supply());
			BigDecimal maxSupply = BigDecimal.valueOf(list.get(i).getMax_supply());
			try {
				GetConnection.getInstance().getJdbcTemplate().update(QueryCoin.getInstance().getInsertCoin(),list.get(i).getName(),"user",btc,usd,market,perc_1,perc_24,perc_7,volume,lastUpdate,supplyAvaible,totalSupply,maxSupply);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public List<CoinDB> getListDB() {
		try {
			return GetConnection.getInstance().getJdbcTemplate().query(QueryCoin.getInstance().getGetCoinDB(), new CoinDBMapper());
		}catch (Exception e) {
			return null;
		}

	}
	
	public List<Market> getListCoinGeko() {
		return CoinGekoClient.GetInstance().getListMarket();

	}
	
	public void setCoin() {	
		List<String>listDefault = new ArrayList<String>();
		listDefault = getListCoinDefault();
		//ManagerCoin.getInstance().setMoneyListCoinGeko(listDefault);
		ManagerCoin.getInstance().setMoneyListCoinMarket(listDefault);
		setListCoinDB(ManagerCoin.getInstance().getGetCoin().getList());
		ManagerCoin.getInstance().setListCoin(getListDB());
		//ManagerCoin.getInstance().setCoingekoCoin(getListCoinGeko());
		OperationDBLogger.getInstance().logger("", true, DataBaseOperation.GETLISTCOIN);
	}



}
