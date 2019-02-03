package ourpoolstats.query;

public class QueryCoin {
	private static QueryCoin instance;
	
	private String getDefaulCoin = "select name from coin where username = 'user'";
	private String getuserCoin = "select name,quantity from coin where username = ?";
	private String insertCoin = "insert into coin (?,?)";
	private String deleteCoin = "delete from coin where name = ?";
	private String deleteCoinUser = "delete from coin where name = ? anda username = ?";

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
	
	
}
