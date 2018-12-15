package ourpoolstats.query;

public class QueryImage {
	
	private static QueryImage instance;
	private String getImageProfile = "select url from image_profile where username = ?";
	private String setImageProfile = "update image_profile set url = ? where username = ?";
	private String insetImageProfile = "insert into image_profile (username,url) values(?,?)";
	
	private QueryImage() {}
	
	public static QueryImage getInstance() {
		
		if(instance== null) {
			instance = new QueryImage(); 
		}
		
		return instance;
	}

	public String getGetImageProfile() {
		return getImageProfile;
	}

	public String getSetImageProfile() {
		return setImageProfile;
	}

	public String getInsetImageProfile() {
		return insetImageProfile;
	}

	
	
}
