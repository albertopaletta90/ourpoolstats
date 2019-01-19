package oupoolstats.service.language;

import ourpoolstats.myenum.LenguageType;

public interface ILanguageService {

	public LenguageType getLenguace(String Username);
	public void setLenguace(String l,String u);
	public void insertLenguace(String u,String l);
}
