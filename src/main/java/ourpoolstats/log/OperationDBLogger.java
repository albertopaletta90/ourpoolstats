package ourpoolstats.log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import ourpoolstats.log.configuration.OurpoolStatsFilter;
import ourpoolstats.log.configuration.OurpoolStatsFormatter;
import ourpoolstats.log.configuration.OurpoolStatsHandler;
import ourpoolstats.manager.ManagerDashboard;
import ourpoolstats.response.LogResponse;
import ourpoolstats.type.DataBaseOperation;

public class OperationDBLogger {

	private static OperationDBLogger instance;

	private OperationDBLogger() {}

	private Logger logger = Logger.getLogger(AdminOperationLogger.class.getName());

	public static OperationDBLogger getInstance() {

		if(instance == null ) {

			instance = new OperationDBLogger();
		}

		return instance;
	}




	public void logger(String value,boolean status, DataBaseOperation operation,LogResponse logResponse) {
		try {
			LogManager.getLogManager().readConfiguration(new FileInputStream("C:\\Users\\Alberone\\git\\ourpoolstats\\mylogging.properties"));
		} catch (SecurityException | IOException e1) {
			e1.printStackTrace();
		}
		logger.setLevel(Level.FINE);
		logger.addHandler(new ConsoleHandler());
		//adding custom handler
		logger.addHandler(new OurpoolStatsHandler());
		try {
			Handler fileHandler = new FileHandler("C:\\Users\\Alberone\\Desktop\\worspace\\log\\dataBaseOperation\\operationAdmin.log", 2000, 5);
			fileHandler.setFormatter(new OurpoolStatsFormatter());
			fileHandler.setFilter(new OurpoolStatsFilter());
			logger.addHandler(fileHandler);

			switch (operation) {

			case INSERTIMAGEPROFILE :
				if(status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.INFO, "<INSERTIMAGEPROFILE><OK> " + "All'Utente " + value + " è stata Inseruita per la prima Volta l'immagine di profilo </INSERTIMAGEPROFILE>");
					logResponse.setLevel(Level.INFO.toString());
					ManagerDashboard.getInstance().getLog().add("<INSERTIMAGEPROFILE><OK> " + "All'Utente " + value + " è stata Inseruita per la prima Volta l'immagine di profilo </INSERTIMAGEPROFILE>");
				}	
				else if(!status) {
					logResponse.setOperation(operation.toString());
					logResponse.setLevel(Level.SEVERE.toString());
					logger.log(Level.SEVERE, ("<INSERTIMAGEPROFILE><KO> " +  "All'Utente"  + value + " Non è stata Inserita L'immagine  </INSERTIMAGEPROFILE>"));
					ManagerDashboard.getInstance().getLog().add("<INSERTIMAGEPROFILE><KO> " +  "All'Utente"  + value + " Non è stata Inserita L'immagine  </INSERTIMAGEPROFILE>");
				}


				break;
			case INSERTLANGUAGE :
				if(status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.INFO, "<INSERTLANGUAGE><OK> " + "All'Utente " + value + " è stata Inseruita per la prima Volta La Lingua</INSERTLANGUAGE>");
				}
				else if(!status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.SEVERE, ("<INSERTLANGUAGE><KO> " +  "All'Utente"  + value + " Non è stata Inserita La Lingua </INSERTLANGUAGE>"));
				}
				break;
			case INSERTLOGUSER :
				if(status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.INFO, "<INSERTLOGUSER><OK> " + "All'Utente " + value + " è stata Inseruito Nei Log Di Accesso </INSERTLOGUSER>");
				}
				else if(!status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.SEVERE, ("<INSERTLOGUSER><KO> " +  "All'Utente"  + value + " Non è stato Inserito nei Log di Accesso  </INSERTLOGUSER>"));
				}
				break;
			case UPDATELANGUAGE :
				if(status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.INFO, "<UPDATELANGUAGE><OK> " + "All'Utente " + value + " è stata Modificata La Lingua</UPDATELANGUAGE>");
				}
				else if(!status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.SEVERE, ("<UPDATELANGUAGE><KO> " +  "All'Utente"  + value + " Non è stata Modificata La Lingua </UPDATELANGUAGE>"));
				}					
				break;
			case GETLISTCOIN :
				if(status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.INFO, "<GETLISTCOIN><OK> La Lista Di Monete Base é stata Generata   </GETLISTCOIN>");
				}
				else if(!status) {
					logResponse.setOperation(operation.toString());
					logger.log(Level.SEVERE, ("<GETLISTCOIN><KO>La Lista Di Monete Base non é stata Generata  </GETLISTCOIN>"));
				}

				break;


			}

			logger.log(Level.CONFIG, "Config data");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
}
