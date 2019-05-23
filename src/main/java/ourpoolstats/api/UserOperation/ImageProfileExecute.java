package ourpoolstats.api.UserOperation;

import org.springframework.http.ResponseEntity;

import ourpoolstats.query.QueryImage;
import ourpoolstats.response.Response;
import ourpoolstats.response.status.ResponseStatus;
import ourpoolstats.type.LogOperation;
import ourpoolstats.utility.connection.GetConnection;

public class ImageProfileExecute {

	public ResponseEntity<Response> setImageProfile(String username, String url,String method) {
		Response response = new Response();
		switch (method) {
		case "insert":
			try {
				GetConnection.getInstance().getJdbcTemplate().update(QueryImage.getInstance().getInsetImageProfile(),username,url);
				return new ResponseStatus().success(response, username, LogOperation.IMAGEPROFILE, null);
			} catch (Exception e) {
				return new ResponseStatus().error(response, username, e, null);
			}

		case "update":
			try {
				GetConnection.getInstance().getJdbcTemplate().update(QueryImage.getInstance().getSetImageProfile(),url,username);
				return new ResponseStatus().success(response, username, LogOperation.IMAGEPROFILE, null);
			} catch (Exception e) {
				return new ResponseStatus().error(response, username, e, null);
			}

		}
		return null;

	}
}
