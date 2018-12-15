package ourpoolstats.manager;

public class ManagerLoginSignin {
	
	private static ManagerLoginSignin instance;
	private boolean errorLogin = false;
	private boolean errorRegistration = false;
	private boolean firstLogin = true;
	
	private ManagerLoginSignin() {}
	
	public static ManagerLoginSignin getInstance() {
		
		if(instance == null) {
			instance = new ManagerLoginSignin();
		}
		
		return instance;
	}

	public boolean isErrorLogin() {
		return errorLogin;
	}

	public void setErrorLogin(boolean errorLogin) {
		this.errorLogin = errorLogin;
	}
	
	public boolean isErrorRegistration() {
		return errorRegistration;
	}

	public void setErrorRegistration(boolean errorRegistration) {
		this.errorRegistration = errorRegistration;
	}


	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	
}
