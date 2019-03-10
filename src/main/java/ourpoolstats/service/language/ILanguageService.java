package ourpoolstats.service.language;

import org.springframework.http.ResponseEntity;

import ourpoolstats.response.Response;
import ourpoolstats.type.LenguageType;

public interface ILanguageService {

	public LenguageType getLenguace(String Username);
	public void setLenguace(String l,String u);
	public void insertLenguace(String u,String l);
	public ResponseEntity<Response>changeLanguage(String username,String lenguageType);
}
