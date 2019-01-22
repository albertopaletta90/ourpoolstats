package oupoolstats.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import ourpoolstats.mapper.PasswordMapper;
import ourpoolstats.mapper.UserLogMapper;
import ourpoolstats.mapper.UserLoginMapper;
import ourpoolstats.model.User;
import ourpoolstats.model.UserLog;
import ourpoolstats.query.QueryAdminOption;
import ourpoolstats.query.QueryUser;
import ourpoolstats.utility.GetConnection;

public class AdminDasboradService implements IAdminDasboradService {

	private GetConnection getConnection;
	private JdbcTemplate jdbcTemplate;

	public AdminDasboradService() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		this.getConnection =(GetConnection) context.getBean("transactionManager");
		this.jdbcTemplate = getConnection.getJdbcTemplateObject();
	}

	@Override
	public boolean createUser(User u) {		
		String hashPswword = jdbcTemplate.query(QueryUser.getInstance().getHashPassword(), new PasswordMapper(),u.getPassword()).get(0);
		String userType = "USER";
		int row = 0;
		try {
			row = jdbcTemplate.update(QueryAdminOption.getInstance().getInsertUserAdmin(),u.getUserName(),u.getUserSurname(),u.getEmail(),u.getUsername(),hashPswword,userType);
		}catch (Exception e) {
			return false;
		}

		if(row > 0)
			return true;
		else		
			return false;
	}

	@Override
	public boolean deleteUser(String username) {

		int row = jdbcTemplate.update(QueryAdminOption.getInstance().getDeleteUser(),username);
		if (row > 0)
			return true;
		else		
			return false;
	}

	@Override
	public boolean cangeTypeUser(String userType,String username) {
		int row = jdbcTemplate.update(QueryAdminOption.getInstance().getChangeUserType(),userType,username);
		if (row > 0)
			return true;
		else		
			return false;
	}

	@Override
	public User logSingleUser(String username) {
		return null;
	}

	@Override
	public List<UserLog> logUser() {
		List<UserLog>list = jdbcTemplate.query(QueryAdminOption.getInstance().getUserLog(), new UserLogMapper());
		if(list == null )
			return null;
		else
			return list;
	}

	@Override
	public List<User> userOnline(String username) {
		List<User>list = new ArrayList<>();
		list = jdbcTemplate.query(QueryAdminOption.getInstance().getUserOnline(), new UserLoginMapper(),username);
		return list;
	}

	@Override
	public List<String> getCoins() {

		return null;
	}

}
