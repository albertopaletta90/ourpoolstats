package ourpoolstats.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ourpoolstats.model.Language;
import ourpoolstats.type.LenguageType;

public class LanguageMapper  implements RowMapper<Language> {

	@Override
	public Language mapRow(ResultSet rs, int arg1) throws SQLException {
		Language language = new Language();
		language.setUsername(rs.getString(1));
		if(rs.getString(2).equals("italiano"))
			language.setLenguageType(LenguageType.ITALIAN);
		else
			language.setLenguageType(LenguageType.ENGLISH);
		return language;
	}

}
