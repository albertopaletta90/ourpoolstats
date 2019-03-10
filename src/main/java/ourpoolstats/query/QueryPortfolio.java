package ourpoolstats.query;

public class QueryPortfolio {
	
	private static QueryPortfolio instance;
	
	private String insertToPotfolio = "insert into portfolio_user (username,type_username,name_coin,quantity,price_initial,price_current) values(?,?,?,?,?,?)";
	private String getPortfolioUser = "select id,username,type_username,name_coin,quantity,price_initial,price_current from portfolio_user where username = ?";
	private String deleteCoinToPortfolio = "delete from portfolio_user where id = ?";
	private String getPortfolioPartecipant = "select id,username,type_username,name_coin,quantity,price_initial,price_current from portfolio_user where partecipant = ?";
	
	private QueryPortfolio() {}
	
	public static QueryPortfolio getInstance() {
		
		if(instance == null) {
			instance = new QueryPortfolio();
		}
		
		return instance;
		
	}

	public String getInsertToPotfolio() {
		return insertToPotfolio;
	}

	public String getGetPortfolioUser() {
		return getPortfolioUser;
	}

	public String getDeleteCoinToPortfolio() {
		return deleteCoinToPortfolio;
	}

	public String getGetPortfolioPartecipant() {
		return getPortfolioPartecipant;
	}
	
	

}
