package ourpoolstats.response;

import java.util.List;

public class LogResponse {

	private String operation;
	private String level;
	private List<String>log;
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<String> getLog() {
		return log;
	}
	public void setLog(List<String> log) {
		this.log = log;
	}
	
	
	
	
}
