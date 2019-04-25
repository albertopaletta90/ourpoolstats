package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.log.AdminOperationLogger;
import ourpoolstats.response.Response;
import ourpoolstats.type.LogOperation;

public class ResponseStatus {

	public ResponseEntity<Response> error(Response response, String username, Exception e,LogOperation operation) {
		AdminOperationLogger.getInstance().logger(username, false, operation);
		response.setError("Errore Tecnico " + e.getMessage());
		return new  ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Response> success(Response response, String username,LogOperation operation,List<String>data) {
		AdminOperationLogger.getInstance().logger(username, true, operation);
		response.setStatus(HttpStatus.OK.toString());
		response.setData(data);
		return new  ResponseEntity<Response>(response, HttpStatus.OK);
	}

	public ResponseEntity<Response> notFound(Response response, String username,LogOperation operation,String message) {
		AdminOperationLogger.getInstance().logger(username, false, operation);
		response.setStatus(HttpStatus.NOT_FOUND.toString());
		response.setError(message);
		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
	}

}


