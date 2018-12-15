package oupoolstats.service.admin;

import java.util.List;

import ourpoolstats.model.User;
import ourpoolstats.model.UserLog;

public interface IAdminDasboradService {

	public boolean createUser(User u);
	public boolean deleteUser(String username);
	public boolean cangeTypeUser(String userType,String username);
	public User logSingleUser(String username);
	public List<UserLog> logUser();
	public List<User> userOnline(String username);
	public List<String> getCoins();
	
	
}
