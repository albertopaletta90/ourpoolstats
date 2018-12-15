package ourpoolstats.manager;

import java.util.List;

import oupoolstats.api.coinmarket.Coin;

public class ManagerDashboard {

	private static ManagerDashboard instance;
	private boolean divOption = false;
	private boolean createUser = false;
	private boolean signinAdminSuccess = false;
	private boolean deleteUser = false;
	private boolean deleteUserSucces = false;
	private boolean changeUser = false;
	private boolean changeUserSuccess = false;
	private boolean userLog = false;
	private boolean userOnline = false;
	private boolean optionAdmin = false;
	private List<Coin> listCoin = null;

	private ManagerDashboard() {}
	
	public static ManagerDashboard getInstance() {
		
		if(instance == null) {
			instance = new ManagerDashboard();
		}
		
		return instance;
	}

	public boolean isDivOption() {
		return divOption;
	}

	public void setDivOption(boolean divOption) {
		this.divOption = divOption;
	}

	public boolean isCreateUser() {
		return createUser;
	}

	public void setCreateUser(boolean createUser) {
		this.createUser = createUser;
	}

	public boolean isSigninAdminSuccess() {
		return signinAdminSuccess;
	}

	public void setSigninAdminSuccess(boolean signinAdminSuccess) {
		this.signinAdminSuccess = signinAdminSuccess;
	}

	public boolean isDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(boolean deleteUser) {
		this.deleteUser = deleteUser;
	}

	public boolean isDeleteUserSucces() {
		return deleteUserSucces;
	}

	public void setDeleteUserSucces(boolean deleteUserSucces) {
		this.deleteUserSucces = deleteUserSucces;
	}

	public boolean isChangeUser() {
		return changeUser;
	}

	public void setChangeUser(boolean changeUser) {
		this.changeUser = changeUser;
	}

	public boolean isChangeUserSuccess() {
		return changeUserSuccess;
	}

	public void setChangeUserSuccess(boolean changeUserSuccess) {
		this.changeUserSuccess = changeUserSuccess;
	}

	public boolean isUserLog() {
		return userLog;
	}

	public void setUserLog(boolean userLog) {
		this.userLog = userLog;
	}

	public boolean isUserOnline() {
		return userOnline;
	}

	public void setUserOnline(boolean userOnline) {
		this.userOnline = userOnline;
	}

	public boolean isOptionAdmin() {
		return optionAdmin;
	}

	public void setOptionAdmin(boolean optionAdmin) {
		this.optionAdmin = optionAdmin;
	}

	public List<Coin> getListCoin() {
		return listCoin;
	}

	public void setListCoin(List<Coin> listCoin) {
		this.listCoin = listCoin;
	}
	
	
	
	
	
}
