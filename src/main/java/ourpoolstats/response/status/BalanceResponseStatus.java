package ourpoolstats.response.status;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperationCoin;
import ourpoolstats.log.AdminOperationLogger;
import ourpoolstats.model.Balance;
import ourpoolstats.response.BalanceResponse;
import ourpoolstats.type.LogOperation;

public class BalanceResponseStatus {
	
	CommonOperationCoin commonOperationCoin = new CommonOperationCoin();
	
	public ResponseEntity<BalanceResponse> success(String username, BalanceResponse balanceResponse,LogOperation operation,List<Balance>listMarket) {
		AdminOperationLogger.getInstance().logger(username, false, operation);
		balanceResponse.setStatus(HttpStatus.OK.toString());
		balanceResponse.setBalance(listMarket);
		return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.OK);
	}

	public ResponseEntity<BalanceResponse> error(BalanceResponse balanceResponse,LogOperation operation,String username) {	
		AdminOperationLogger.getInstance().logger(username, false, operation);List<Balance>listMarket = commonOperationCoin.getListCoinUser(username);
		balanceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		balanceResponse.setBalance(listMarket);
		return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<BalanceResponse> badRequestError(BalanceResponse balanceResponse,LogOperation operation,String username) {
		AdminOperationLogger.getInstance().logger(username, false, operation);
		List<Balance>listMarket = commonOperationCoin.getListCoinUser(username);
		balanceResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
		balanceResponse.setBalance(listMarket);
		balanceResponse.setEroor("Monete/Quantita sono obbligatori");
		return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<BalanceResponse> notFound(BalanceResponse balanceResponse, String username, LogOperation operation,List<Balance>list) {
		AdminOperationLogger.getInstance().logger(username, false, operation);
		balanceResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		balanceResponse.setBalance(list);
		return new ResponseEntity<BalanceResponse>(balanceResponse,HttpStatus.NOT_FOUND);
	}

}
