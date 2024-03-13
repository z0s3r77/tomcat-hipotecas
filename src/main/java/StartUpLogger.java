import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.naming.InitialContext;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class StartUpLogger implements ServletContextListener{

	public void main(){
		

		try {
			
			InitialContext context = new InitialContext();

			String logLevel =  (String) context.lookup("logLevel");
			String logFile =  (String) context.lookup("logFile");

			
			FileHandler fileHandler = new FileHandler(logFile, true);
			fileHandler.setFormatter(new SimpleFormatter());

			Level level = Level.parse(logLevel);
			Logger globalLogger = Logger.getLogger("");
			
			globalLogger.addHandler(fileHandler);
			globalLogger.setLevel(level); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		this.main();
		
	}

}
