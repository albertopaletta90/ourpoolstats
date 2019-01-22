package ourpoolstats.query;

public class QueryLanguage {

	private static QueryLanguage instance;
	private String getLanguage = "select user,language from language_user where user = ?";
	private String setLanguage = "update language_user set language = ? where user = ?";
	private String insertLanguage = "insert into language_user (user,language) values (?,?)";
	
	
	private QueryLanguage() {}


	public static QueryLanguage getInstance() {

		if(instance == null ) {
			
			instance = new QueryLanguage();
		}
		
		return instance;
	}


	public String getGetLanguage() {
		return getLanguage;
	}


	public String getSetLanguage() {
		return setLanguage;
	}


	public String getInsertLanguage() {
		return insertLanguage;
	}
	
	

}

