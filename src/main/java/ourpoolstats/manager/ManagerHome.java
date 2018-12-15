package ourpoolstats.manager;

public class ManagerHome {

	private static ManagerHome instance;
	private boolean login;
	private boolean signin;
	private boolean news;
	
	private ManagerHome() {		
	}
	
	public static ManagerHome getInstance(){

		if(instance == null) {
			instance = new ManagerHome();
		}
		
		return instance;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isSignin() {
		return signin;
	}

	public void setSignin(boolean signin) {
		this.signin = signin;
	}

	public boolean isNews() {
		return news;
	}

	public void setNews(boolean news) {
		this.news = news;
	}
	
	
	
	
}
