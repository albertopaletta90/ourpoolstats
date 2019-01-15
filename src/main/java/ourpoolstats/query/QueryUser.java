package ourpoolstats.query;

public class QueryUser {

	private static QueryUser instance;
	
	private  String inserUser = "insert into user (user_name,user_surname,email,username,password,user_type) values (?,?,?,?,?,?)";
	private  String insertUserLogin = "insert into user_login (username,date_login) values(?,?)";
	private  String hashPassword = "select SHA2(?,512)as password";
	private  String login ="select username,password from user u where u.username = ? ";
	private  String searchUserType ="select user_type from user u where u.username = ? ";
	private  String searchUser = "select * from user u where u.username = ?";
	private  String deleteUser = "delete from user where username = ?";
	private  String changePassword = "update user set password = ? where username = ?";
	private  String changeEmail = "update user set email = ? where username = ?";
	private  String searchUserToEmail = "select username from user u where u.email = ?";
	private  String insertUserOnline = "insert into user_online (username) values(?)";
	private  String deleteUserOnline = "delete from user_online where username = ?";
	private String 	isFisrtLogin = "select first_login from user u where u.username = ?";
	private String 	setFisrtLogin = "update user set first_login = 0 where username = ?";
	
	private QueryUser() {}
	
	public static QueryUser getInstance() {
		if(instance==null) {
			instance= new QueryUser();
		}
		
		return instance;
	}

	public String getInserUser() {
		return inserUser;
	}

	public String getInsertUserLogin() {
		return insertUserLogin;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public String getLogin() {
		return login;
	}

	public String getSearchUserType() {
		return searchUserType;
	}

	public String getSearchUser() {
		return searchUser;
	}

	public String getDeleteUser() {
		return deleteUser;
	}

	public String getChangePassword() {
		return changePassword;
	}

	public String getChangeEmail() {
		return changeEmail;
	}

	public String getSearchUserToEmail() {
		return searchUserToEmail;
	}

	public String getInsertUserOnline() {
		return insertUserOnline;
	}

	public String getDeleteUserOnline() {
		return deleteUserOnline;
	}

	public String getIsFisrtLogin() {
		return isFisrtLogin;
	}

	public String getSetFisrtLogin() {
		return setFisrtLogin;
	}
	
	
	
	
	 
	
}
