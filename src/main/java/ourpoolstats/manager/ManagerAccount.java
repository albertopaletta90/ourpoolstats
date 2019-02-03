package ourpoolstats.manager;

import oupoolstats.service.user.UserOperration;

public class ManagerAccount {

	private static ManagerAccount instance;
	private boolean changePassword = false;
	private boolean changeErrorPassword = false;
	private boolean changeEmail =false;
	private boolean changeErrorEmail =false;
	private boolean deleteUser = false;
	private boolean deleteUserError = false;
	private UserOperration userOperration = new UserOperration();
	
	
	private ManagerAccount() {}
	
	public static ManagerAccount getInstance() {
		
		if(instance == null) {
			
			instance = new ManagerAccount();
		}
		
		return instance;
	}

	public boolean isChangePassword() {
		return changePassword;
	}

	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}

	public boolean isChangeErrorPassword() {
		return changeErrorPassword;
	}

	public void setChangeErrorPassword(boolean changeErrorPassword) {
		this.changeErrorPassword = changeErrorPassword;
	}

	public boolean isChangeEmail() {
		return changeEmail;
	}

	public void setChangeEmail(boolean changeEmail) {
		this.changeEmail = changeEmail;
	}

	public boolean isChangeErrorEmail() {
		return changeErrorEmail;
	}

	public void setChangeErrorEmail(boolean changeErrorEmail) {
		this.changeErrorEmail = changeErrorEmail;
	}

	public boolean isDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(boolean deleteUser) {
		this.deleteUser = deleteUser;
	}

	public boolean isDeleteUserError() {
		return deleteUserError;
	}

	public void setDeleteUserError(boolean deleteUserError) {
		this.deleteUserError = deleteUserError;
	}

	public UserOperration getUserOperration() {
		return userOperration;
	}

	public void setUserOperration(UserOperration userOperration) {
		this.userOperration = userOperration;
	}
	
	
	
}
