package ourpoolstats.query;

public class QueryCoin {
	private static QueryCoin instance;
	
	private String getDefaulCoin = "select name from coin where username = 'user'";
	private String getuserCoin = "select idsaldo_user,username,name_coin,initial_currency,current_currency,total_currency,quantity from saldo_user where username = ?";
	private String insertCoin = "insert into coin (name,username,price_btc,price_usd,market_cap,perc_1,perc_24,perc_7d,volume,last_update,supply_avaible,total_supply,max_supply) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updatecoin = "update coin set price_btc = ? and price_usd = ? where name = ?";
	private String deleteCoin = "delete from coin where id_coin = ?";
	private String deleteCoinDefault = "delete from coin where id_coin > 1";
	private String deleteCoinUser = "delete from coin where name = ? anda username = ?";
	private String buyCoin = "insert into saldo_user (username,name_coin,initial_currency,total_currency,quantity) VALUES (?,?,?,?,?)";
	private String deleteCoinBalance = "delete from saldo_user where idsaldo_user = ?";
	private String updateQuantityCoinBalance = "update saldo_user set quantity = quantity - ? where idsaldo_user = ?";
	private String getCoinDB = "select id_coin ,name,price_btc,price_usd,market_cap,perc_1, perc_24,perc_7d,volume,last_update,supply_avaible,total_supply,max_supply from coin"; 
	private String updateListMarketPersonal = "update saldo_user set total_currency = ? , initial_currency = ? where idsaldo_user =?"; 
	private String getIdCoin = "select id_coin from coin where name = ?";
	
	private QueryCoin() {}
	
	public static QueryCoin getInstance() {
		
		if(instance == null) {
			instance = new QueryCoin();
		}
		
		return instance;
	}

	public String getGetDefaulCoin() {
		return getDefaulCoin;
	}

	public String getInsertCoin() {
		return insertCoin;
	}

	public String getDeleteCoin() {
		return deleteCoin;
	}

	public String getDeleteCoinUser() {
		return deleteCoinUser;
	}

	public String getGetuserCoin() {
		return getuserCoin;
	}

	public String getBuyCoin() {
		return buyCoin;
	}

	public String getDeleteCoinBalance() {
		return deleteCoinBalance;
	}

	public String getUpdateQuantityCoinBalance() {
		return updateQuantityCoinBalance;
	}

	public String getUpdatecoin() {
		return updatecoin;
	}

	public String getGetCoinDB() {
		return getCoinDB;
	}

	public String getUpdateListMarketPersonal() {
		return updateListMarketPersonal;
	}

	public String getGetIdCoin() {
		return getIdCoin;
	}

	public String getDeleteCoinDefault() {
		return deleteCoinDefault;
	}
	
	
}
