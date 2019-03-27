package ourpoolstats.query;

public class QueryAdminOption {

	private static QueryAdminOption instance;
	
	public  String insertUserAdmin = "insert into user (user_name,user_surname,email,username,password,user_type) values (?,?,?,?,?,?)";
	public  String userOnline = "select distinct username from user_login where username <> ? ";
	public  String searchUser = "select * from user u where u.username = ?";
	public  String deleteUser = "delete from user where username = ?";
	public  String changeUserType = "update user set user_type = ? where username = ?";
	public  String userLog = "select distinct username,date_login from user_login";
	public  String userSingleLog = "select username,date_login from user_login where username = ?";
	public  String getListUser = "select user_name,user_surname,username,email,user_type from user";
	
	
	private QueryAdminOption() {}
	
	public static QueryAdminOption getInstance() {
		
		if(instance==null) {
			instance = new QueryAdminOption();
		}
		
		return instance;
	}

	public String getInsertUserAdmin() {
		return insertUserAdmin;
	}

	public String getUserOnline() {
		return userOnline;
	}

	public String getSearchUser() {
		return searchUser;
	}

	public String getDeleteUser() {
		return deleteUser;
	}

	public String getChangeUserType() {
		return changeUserType;
	}

	public String getUserLog() {
		return userLog;
	}

	public String getUserSingleLog() {
		return userSingleLog;
	}

	public String getGetListUser() {
		return getListUser;
	}
	
	
	
	
	
}
