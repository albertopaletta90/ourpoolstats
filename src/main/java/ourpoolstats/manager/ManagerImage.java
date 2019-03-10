package ourpoolstats.manager;

import ourpoolstats.type.CurrencyType;

public class ManagerImage {
	
	private static ManagerImage instance ;
	private String linkDefaultImageLanguages = "https://stadiodellaromafaq.files.wordpress.com/2016/09/italy.png";
	private String linkItalianImageLanguages = "https://stadiodellaromafaq.files.wordpress.com/2016/09/italy.png";
	private String linkEnglishImageLanguages = "https://www.statuasancarlo.it/wp-content/uploads/2015/04/icona-inglese.png";
	private String linkImageProfile ="http://aux2.iconspalace.com/uploads/manager-icon-256.png" ;
	private String linkCurrencyDeflaut = "https://cdn.iconscout.com/icon/free/png-256/euro-207-444688.png";
	private String linkCurrencyEur = "https://cdn.iconscout.com/icon/free/png-256/euro-207-444688.png";
	private String linkCurrencyUsd = "http://i2.wp.com/www.klindex-america.com/wp-content/uploads/2016/02/klindex-dollar-icon-grinding.png";
	private String linkMarketCurrencyDeflaut = "http://i2.wp.com/www.klindex-america.com/wp-content/uploads/2016/02/klindex-dollar-icon-grinding.png";
	private String linkMarketCurrencyEur = "https://cdn.iconscout.com/icon/free/png-256/euro-207-444688.png";
	private String linkMarketCurrencyUsd = "http://i2.wp.com/www.klindex-america.com/wp-content/uploads/2016/02/klindex-dollar-icon-grinding.png";
	private String linkMarketCurrencyBTC = "https://chainz.cryptoid.info/logo/btc.png";
	private ManagerImage() {}
	
	public static ManagerImage getInstance() {
		
		if(instance == null ) {
			instance = new ManagerImage();
		}
		
		return instance;
	}
	
	public void setImageDefault(String lenguage) {
		switch (lenguage) {
		case "ITALIAN":
				this.linkDefaultImageLanguages = linkItalianImageLanguages;
			break;
		case  "ENGLISH" :
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
	
	public void setImageMarketCurrency(CurrencyType currency) {
		switch (currency) {
		case EURO:
				this.linkMarketCurrencyDeflaut = linkMarketCurrencyEur;
			break;
		case  USD:
			this.linkMarketCurrencyDeflaut = linkMarketCurrencyUsd;
			break;
		case  BTC:
			this.linkMarketCurrencyDeflaut = linkMarketCurrencyBTC;
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

	public String getLinkMarketCurrencyDeflaut() {
		return linkMarketCurrencyDeflaut;
	}

	public String getLinkMarketCurrencyEur() {
		return linkMarketCurrencyEur;
	}

	public String getLinkMarketCurrencyUsd() {
		return linkMarketCurrencyUsd;
	}

	public String getLinkMarketCurrencyBTC() {
		return linkMarketCurrencyBTC;
	}
	
	
	
}
