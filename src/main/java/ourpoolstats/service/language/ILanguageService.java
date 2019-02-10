package ourpoolstats.service.language;

import ourpoolstats.type.LenguageType;

public interface ILanguageService {

	public LenguageType getLenguace(String Username);
	public void setLenguace(String l,String u);
	public void insertLenguace(String u,String l);
}
