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

public class LoginSigninLogger {
	private static LoginSigninLogger instance;

	private LoginSigninLogger() {}

	private Logger logger = Logger.getLogger(LoginSigninLogger.class.getName());

	public static LoginSigninLogger getInstance() {

		if(instance == null ) {

			instance = new LoginSigninLogger();
		}

		return instance;
	}




	public void logger(String username,boolean status,LogResponse logResponse ) {
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
			//FileHandler file name with max size and number of log files limit
			Handler fileHandler = new FileHandler("C:\\Users\\Alberone\\Desktop\\worspace\\log\\login\\log.log", 2000, 5);
			fileHandler.setFormatter(new OurpoolStatsFormatter());
			//setting custom filter for FileHandler
			fileHandler.setFilter(new OurpoolStatsFilter());
			logger.addHandler(fileHandler);
			//logging messages
			if(status) {
				logger.log(Level.INFO, "<LOGIN><OK> " + "L'utente " +  username + " ha effetuato corretamente L'acesso </LOGIN>");
				ManagerDashboard.getInstance().getLog().add("<LOGIN><OK> " + "L'utente " +  username + " ha effetuato corretamente L'acesso </LOGIN>");
			}				
			else if(!status) {
				logger.log(Level.SEVERE, "<LOGIN><KO> " + "L'utente " +  username + " Ha inserito in modo errato i dati. </LOGIN>");
				ManagerDashboard.getInstance().getLog().add("<LOGIN><KO> " + "L'utente " +  username + " Ha inserito in modo errato i dati. </LOGIN>");
			}
				
			logger.log(Level.CONFIG, "Config data");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}

}