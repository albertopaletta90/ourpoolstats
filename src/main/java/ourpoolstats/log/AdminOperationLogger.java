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
import ourpoolstats.type.AdminOperation;

public class AdminOperationLogger {

	private static AdminOperationLogger instance;

	private AdminOperationLogger() {}

	private Logger logger = Logger.getLogger(AdminOperationLogger.class.getName());

	public static AdminOperationLogger getInstance() {

		if(instance == null ) {

			instance = new AdminOperationLogger();
		}

		return instance;
	}




	public void logger(String username,boolean status, AdminOperation operation) {
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
			Handler fileHandler = new FileHandler("C:\\Users\\Alberone\\Desktop\\worspace\\log\\adminOperation\\operationAdmin.log", 2000, 5);
			fileHandler.setFormatter(new OurpoolStatsFormatter());
			fileHandler.setFilter(new OurpoolStatsFilter());
			logger.addHandler(fileHandler);
			//logging messages
			switch (operation) {
			case INSERTUSER:
				if(status)
					logger.log(Level.INFO, "<INSERTUSER><OK> " + "L'utente " +  username + " è stato inserito Corretamente </INSERTUSER>");
				else if(!status)
					logger.log(Level.SEVERE, "<INSERTUSER><KO> " + "L'utente " +  username + " è gia presente nel BD </INSERTUSER>");
				break;
			case DELETE:
				if(status)
					logger.log(Level.INFO, "<DELETEUSER><OK> " + "L'utente " +  username + " è stato cancellato Corretamente </DELETEUSER>");
				else if(!status)
					logger.log(Level.SEVERE, "<DELETEUSER><KO> " + "L'utente " +  username + " non è stato trovato nel BD </DELETEUSER>");
				break;
			case INSERTCOIN:
				if(status)
					logger.log(Level.INFO, "<INSERTCOIN><OK> " + "La Moneta " +  username + " è stata inserita Corretamente </INSERTCOIN>");
				else if(!status)
					logger.log(Level.SEVERE, "<INSERTCOIN><KO> " + "La Moneta " +  username + " non è stata inserita  nel BD </INSERTCOIN>");
				break;
			case DELETECOIN:
				if(status)
					logger.log(Level.INFO, "<DELETECOIN><OK> " + "La moneta " +  username + " è stata cancellato Corretamente </DELETECOIN>");
				else if(!status)
					logger.log(Level.SEVERE, "<DELETECOIN><KO> " + "La Moneta " +  username + " non è stata trovata nel BD </DELETECOIN>");
				break;

			case USERONLINE:
				if(status)
					logger.log(Level.INFO, "<USERONLINE><OK> " + "Gli Utenti online Sono Disponibili </USERONLINE>");
				else if(!status)
					logger.log(Level.SEVERE, "<USERONLINE><KO> " + "Gli Utenti online Non Sono Disponibili  </USERONLINE>");
				break;
			case VIEWLOGUSER:
				if(status)
					logger.log(Level.INFO, "<VIEWLOGUSER><OK> " + "Gli Accessi Degli Utenti Sono Disponibili </VIEWLOGUSER>");
				else if(!status)
					logger.log(Level.SEVERE, "<VIEWLOGUSER><KO> " + "Gli Accessi Degli Utenti Non Sono Disponibili  </VIEWLOGUSER>");
				break;
			case CHANGETYPE:
				if(status)
					logger.log(Level.INFO, "<CHANGEUSER><OK> " + "All'Utente " + username + " è stato Cambiato Corretamente il Tipo. </CHANGEUSER>");
				else if(!status)
					logger.log(Level.SEVERE, "<CHANGEUSER><KO> " +  "All'Utente"  + username + " è stato Cambiato Corretamente il Tipo. </CHANGEUSER>");
				break;


			}

			logger.log(Level.CONFIG, "Config data");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

}


