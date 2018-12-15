package ourpoolstats.multilingual;

public class MultilingualHomeController {

	private static MultilingualHomeController instance;
	private String home ="Home";
	private String ls ="Accedi/Registrati";
	private String market =  "Mercato";
	private String forum = "Forum";
	private String login = "Accedi";
	private String signin = "Registrati";
	private String username = "Username";
	private String Password = "Password";
	private String forGotPassword  = "Password Dimenticata?";
	private String errorLogin = "Utente/Password Errati"; 
	private String name = "Nome";
	private String surname ="Cognome";
	private String email = "E-mail";
	private String back = "Indietro";
	private String errorSiginin = "Errore Nella Registrazione";
	private String successSignin = "Registrazione Avvenuta Con Sucesso";
	

	private MultilingualHomeController()
	{
	}

	public static MultilingualHomeController getInstance()
	{
		if (instance == null)
		{
			instance = new MultilingualHomeController();
		}

		return instance; 
	}
	
	

	public void setLenguageItalian() {
		this.ls= "Accedi/Registrati";
		this.market = "Mercato";
		this.login = "Accedi";
		this.signin = "Registrati";
		this.forGotPassword  = "Password Dimenticata?";
		this.errorLogin = "Utente/Password Errati";
		this.name = "Nome";
		this.surname ="Cognome";
		this.back = "Indietro";
	}

	public void setLenguageEnglish() {
		this.ls= "Login/Signin";
		this.market = "Market";
		this.login = "Login";
		this.signin = "Signin";
		this.forGotPassword  = "Forgot Password?";
		this.errorLogin = "Wrong user/password";
		this.name = "Name";
		this.surname ="Surname";
		this.back = "Back";
	}
	
	public String getHome() {
		return home;
	}

	public String getLs() {
		return ls;
	}

	public String getMarket() {
		return market;
	}

	public String getForum() {
		return forum;
	}

	public String getLogin() {
		return login;
	}

	public String getSignin() {
		return signin;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return Password;
	}

	public String getForGotPassword() {
		return forGotPassword;
	}

	public String getErrorLogin() {
		return errorLogin;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getBack() {
		return back;
	}
		
	public String getErrorSiginin() {
		return errorSiginin;
	}

	public String getSuccessSignin() {
		return successSignin;
	}

	
	
}
