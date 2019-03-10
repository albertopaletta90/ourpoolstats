package ourpoolstats.manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerDashboard {

	private static ManagerDashboard instance;
	private List<String>log = new ArrayList<String>();
	

	private ManagerDashboard() {}
	
	public static ManagerDashboard getInstance() {
		
		if(instance == null) {
			instance = new ManagerDashboard();
		}
		
		return instance;
	}

	public List<String> getLog() {
		return log;
	}

	public void setLog(List<String> log) {
		this.log = log;
	}

	

}
