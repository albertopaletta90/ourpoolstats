package ourpoolstats.multilingual;

public class MultiLilingualDashboardController {

	private static MultiLilingualDashboardController instance;

	private String account = "Profilo";
	private String options = "Opzioni";
	private String insertUser = "Registra Utente";
	private String deleteUser = "Elimina Utente";
	private String viewLogSigleUser = "Visualizza Accessi Utente";
	private String viewLogUsers = "Visualizza Accessi Utenti";
	private String viewUserOnline = "Visualizza Utenti Online";
	private String addCoin = "Aggiungi Monete";
	private String deleteCoin = "Elimina Monete ";	
	private String addImage ="Aggiungi Immagine";
	private String changeImage ="Cambia Immagine";
	private String changePassword ="Cambia Password";
	private String changeEmail ="Cambia Email";
	private String changeUser ="Cambia Tipo Utente";
	private String userType ="Tipo Utente";
	private String userLog ="Accessi Utente";
	private String userOnline ="Utenti Online";
	private String action = "Azioni";
	private String succesCreateUser = "Operazione Effettuata Con Sucesso";
	private String errorDeleteUser = "Operazione Non Riuscita";
	private String sendEmail = "Invia Email";
	private String chat = "Chat";
	private String logout = "Esci";
	private String symbol = "Simbolo";
	private String nameCoin ="Nome";
	private String priceBtc ="Prezzo in BTC";
	private String priceUsd ="Prezzo in Dollari";
	private String marketcap = "Market Cap";
	private String perc1H = "1H%";
	private String perc24H = "24H%";
	private String coinMarket = "CoinMarket";
	private String cryptopia = "Cryptopia";
	private String coinGeko = "Coingeko";
	private String errorInternt = "Errore con La Connessione";  
	private String deleteUserAction = "Sei Sicuro DI Volere Cancellare il Tuo Account";



	private MultiLilingualDashboardController() {}

	public static MultiLilingualDashboardController getInstance() {

		if(instance == null ) {
			instance = new MultiLilingualDashboardController();
		}

		return instance;
	}


	public void setLenguageItalian() {
		this.account = "Profilo";
		this.options = "Opzioni";
		this.insertUser = "Registra Utente";
		this.deleteUser = "Elimina Utente";
		this.viewLogSigleUser = "Visualizza Accessi Utente";
		this.viewLogUsers = "Visualizza Accessi Utenti";
		this.viewUserOnline = "Visualizza Utenti Online";
		this.addCoin = "Aggiungi Monete";
		this.deleteCoin = "Elimina Monete ";	
		this.addImage ="Aggiungi Immagine";
		this.changeImage ="Cambia Immagine";
		this.changePassword ="Cambia Password";
		this.changeEmail ="Cambia Email";
		this.changeUser ="Cambia Tipo Utente";
		this.userType ="Tipo Utente";
		this.userLog ="Accessi Utente";
		this.userOnline ="Utenti Online";
		this.action = "Azioni";
		this. sendEmail = "Invia Email";
		this.symbol = "Simbolo";
		this.nameCoin ="Nome";
		this.priceBtc ="Prezzo in BTC";
		this.priceUsd ="Prezzo in Dollari";
		this.marketcap = "Market Cap";
		this.perc1H = "1H%";
		this.perc24H = "24H%";

	}

	public void setLenguageEnglish() {
		this.account = "Account";
		this.options = "Options";
		this.insertUser = "Insert User";
		this.deleteUser = "Delete User";
		this.viewLogSigleUser = "View single user access";
		this.viewLogUsers = "View single user access";
		this.viewUserOnline = "View users online";
		this.addCoin = "Add Coin";
		this.deleteCoin = "Delete Coin";
		this.addImage ="Add Image";
		this.changeImage ="Change Immage";
		this.changePassword ="Change Password";
		this.changeEmail ="Change Email";
		this.changeUser ="Cange User Type";
		this.userType ="User Type";
		this.userLog ="User Log";
		this.userOnline ="User Online";
		this.action = "Action ";
		this.sendEmail = "Send Email";
		this.symbol = "Symbol";
		this.nameCoin ="Name";
		this.priceBtc ="Price  BTC";
		this.priceUsd ="Price USD";
		this.marketcap = "Market Cap";
		this.perc1H = "1H%";
		this.perc24H = "24H%";
	}




	public String getAccount() {
		return account;
	}

	public String getOptions(){
		return options;
	}

	public String getInsertUser() {
		return insertUser;
	}

	public String getDeleteUser() {
		return deleteUser;
	}

	public String getViewLogSigleUser() {
		return viewLogSigleUser;
	}

	public String getViewLogUsers() {
		return viewLogUsers;
	}

	public String getViewUserOnline() {
		return viewUserOnline;
	}

	public String getAddCoin() {
		return addCoin;
	}

	public String getDeleteCoin() {
		return deleteCoin;
	}

	public String getAddImage() {
		return addImage;
	}

	public String getChangeImage() {
		return changeImage;
	}

	public String getChangePassword() {
		return changePassword;
	}

	public String getChangeEmail() {
		return changeEmail;
	}

	public String getChangeUser() {
		return changeUser;
	}

	public String getUserType() {
		return userType;
	}

	public String getUserLog() {
		return userLog;
	}

	public String getUserOnline() {
		return userOnline;
	}

	public String getAction() {
		return action;
	}

	public String getSuccesCreateUser() {
		return succesCreateUser;
	}

	public String getErrorDeleteUser() {
		return errorDeleteUser;
	}

	public String getSendEmail() {
		return sendEmail;
	}

	public String getChat() {
		return chat;
	}


	public String getLogout() {
		return logout;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getNameCoin() {
		return nameCoin;
	}

	public String getPriceBtc() {
		return priceBtc;
	}

	public String getPriceUsd() {
		return priceUsd;
	}

	public String getMarketcap() {
		return marketcap;
	}

	public String getPerc1H() {
		return perc1H;
	}

	public String getPerc24H() {
		return perc24H;
	}

	public String getCoinMarket() {
		return coinMarket;
	}

	public String getCryptopia() {
		return cryptopia;
	}

	public String getCoinGeko() {
		return coinGeko;
	}

	public String getErrorInternt() {
		return errorInternt;
	}

	public String getDeleteUserAction() {
		return deleteUserAction;
	}

	


}
