package ourpoolstats.manager;

import ourpoolstats.myenum.Lenguage;

public class ManagerImage {
	
	private static ManagerImage instance ;
	private String linkDefaultImageLanguages = "https://stadiodellaromafaq.files.wordpress.com/2016/09/italy.png";
	private String linkItalianImageLanguages = "https://stadiodellaromafaq.files.wordpress.com/2016/09/italy.png";
	private String linkEnglishImageLanguages = "https://www.statuasancarlo.it/wp-content/uploads/2015/04/icona-inglese.png";
	private String linkImageProfile = "https://cdn.icon-icons.com/icons2/1369/PNG/512/-account-circle_89831.png";
	private ManagerImage() {}
	
	public static ManagerImage getInstance() {
		
		if(instance == null ) {
			instance = new ManagerImage();
		}
		
		return instance;
	}
	
	public void setImageDefault(Lenguage lenguage) {
		switch (lenguage) {
		case ITALIAN:
				this.linkDefaultImageLanguages = linkItalianImageLanguages;
			break;
		case  ENGLISH :
			this.linkDefaultImageLanguages = linkEnglishImageLanguages;

		default:
			break;
		}
		
	}
	
	public String getLinkDefaultImageLanguages() {
		return linkDefaultImageLanguages;
	}

	public String getLinkEnglishImageLanguages() {
		return linkEnglishImageLanguages;
	}

	public String getLinkItalianImageLanguages() {
		return linkItalianImageLanguages;
	}

	public String getLinkImageProfile() {
		return linkImageProfile;
	}

	public void setLinkImageProfile(String linkImageProfile) {
		this.linkImageProfile = linkImageProfile;
	}
	
	
}
