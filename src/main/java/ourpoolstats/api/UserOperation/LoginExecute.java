package ourpoolstats.api.UserOperation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ourpoolstats.commonOperation.CommonOperation;
import ourpoolstats.log.LoginSigninLogger;
import ourpoolstats.log.OperationDBLogger;
import ourpoolstats.manager.ManagerImage;
import ourpoolstats.model.Login;
import ourpoolstats.response.LogResponse;
import ourpoolstats.response.LoginResponse;
import ourpoolstats.response.status.LoginResponseStatus;
import ourpoolstats.type.DataBaseOperation;

public class LoginExecute {
	public ResponseEntity<LoginResponse> login(Login l, HttpServletRequest request) {
		CommonOperation commonOperation = new CommonOperation();
		LogResponse logResponse = new LogResponse();
		LoginResponse loginResponse = new LoginResponse();

		if(commonOperation.searchUserWithPassword(l.getUsername(), l.getPassword())) { // TODO :: Controllo username & password
			String userType = new CommonOperation().searchUserType(l.getUsername()).toString();
			LoginSigninLogger.getInstance().logger(l.getUsername(),true);

			if(commonOperation.isFirstLoginDay(l.getUsername())) { // TODO :: Controllo primo accesso del girono
				commonOperation.setFirstLoginDay(l.getUsername(), 0);
				commonOperation.insertToUserLogin(l);
				commonOperation.insertToUserOnline(l);
				OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTLOGUSER);
			}else {// TODO: Fine Controllo primo accesso del giorno 
				OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTLOGUSER);
			}
			
			if(commonOperation.isFirstLogin(l.getUsername())){// TODO : Controllo primo accesso
				commonOperation.setFirstLogin(l.getUsername());
				try {
					ImageProfileExecute image = new ImageProfileExecute();
					image.setImageProfile(l.getUsername(), ManagerImage.getInstance().getLinkImageProfile(), "insert");
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTIMAGEPROFILE);
					OperationDBLogger.getInstance().logger(l.getUsername(), true, DataBaseOperation.INSERTLOGUSER);
				} catch (Exception e) {
					e.printStackTrace();
					OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTIMAGEPROFILE);
					OperationDBLogger.getInstance().logger(l.getUsername(), false, DataBaseOperation.INSERTLOGUSER);
				}
				return new LoginResponseStatus().success(loginResponse,logResponse,userType, HttpStatus.CREATED);

			}else{  // TODO :: Fine Controllo primo accesso
				try {// TODO: login Effettuato correttamente & set Lista monete
					return new LoginResponseStatus().success(loginResponse,logResponse,userType,HttpStatus.OK);
				}
				catch (Exception e) {// TODO: errore nella genrazione delle monete
					return new LoginResponseStatus().notFound(loginResponse);
				}			
			}

		}
		else {// TODO : login erratto
			return new LoginResponseStatus().error(loginResponse,l.getUsername());
		}
	}
}
