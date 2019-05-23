package ourpoolstats.api.UserOperation;

import java.util.List;

import org.springframework.http.ResponseEntity;

import ourpoolstats.mapper.StringMapper;
import ourpoolstats.query.QueryImage;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.GetConnection;

public class ImageProfilePrepare {

	public ResponseEntity<Response> getImageProfile(String username) {
		Response response = new Response();
		try {
			List<String> imageProfile = GetConnection.getInstance().getJdbcTemplate().query(QueryImage.getInstance().getGetImageProfile(), new StringMapper(),username);
			return new ResponseStatus().success(response, username, LogOperation.IMAGEPROFILE,imageProfile);
		}
		catch (Exception e) {
			return new ResponseStatus().error(response, username, e, LogOperation.IMAGEPROFILE);
		}

	}

}
