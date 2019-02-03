package ourpoolstats.manager;

import ourpoolstats.type.CurrencyType;
import ourpoolstats.type.LenguageType;

public class ManagerImage {
	
	private static ManagerImage instance ;
	private String linkDefaultImageLanguages = "https://stadiodellaromafaq.files.wordpress.com/2016/09/italy.png";
	private String linkItalianImageLanguages = "https://stadiodellaromafaq.files.wordpress.com/2016/09/italy.png";
	private String linkEnglishImageLanguages = "https://www.statuasancarlo.it/wp-content/uploads/2015/04/icona-inglese.png";
	private String linkImageProfile ="http://aux2.iconspalace.com/uploads/manager-icon-256.png" ;
	private String linkCurrencyDeflaut = "https://cdn.iconscout.com/icon/free/png-256/euro-207-444688.png";
	private String linkCurrencyEur = "https://cdn.iconscout.com/icon/free/png-256/euro-207-444688.png";
	private String linkCurrencyUsd = "http://i2.wp.com/www.klindex-america.com/wp-content/uploads/2016/02/klindex-dollar-icon-grinding.png";
	private ManagerImage() {}
	
	public static ManagerImage getInstance() {
		
		if(instance == null ) {
			instance = new ManagerImage();
		}
		
		return instance;
	}
	
	public void setImageDefault(LenguageType lenguage) {
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
	

	public void setImageCurrency(CurrencyType currency) {
		switch (currency) {
		case EURO:
				this.linkCurrencyDeflaut = linkCurrencyEur;
			break;
		case  USD:
			this.linkCurrencyDeflaut = linkCurrencyUsd;

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

	public String getLinkCurrencyDeflaut() {
		return linkCurrencyDeflaut;
	}

	public String getLinkCurrencyEur() {
		return linkCurrencyEur;
	}

	public String getLinkCurrencyUsd() {
		return linkCurrencyUsd;
	}
	
	
	
}
