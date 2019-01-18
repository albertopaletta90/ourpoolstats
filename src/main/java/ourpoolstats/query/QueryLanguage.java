package ourpoolstats.query;

public class QueryLanguage {

	private static QueryLanguage instance;
	private String getLanguage = "select user,language from language_user where user = ?";
	private String setLanguage = "update language_user set language = ? where user = ?";
	
	
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
	
	

}

