package databaseConnectors;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MysqlDatabaseConnector {

	private DataSource pool;
    private Connection conn;
	private static final Logger LOGGER = Logger.getLogger(MysqlDatabaseConnector.class.getName());


    public static Connection getConnection() {
        if (instance.conn == null) {
            try {
				return instance.startConnection();
			} catch (NamingException e) {
				LOGGER.log(Level.SEVERE, e.toString());
			}
        }
        return instance.conn;
    }

    private Connection startConnection() throws NamingException {
      
    	try {
               	
        	try {

        		InitialContext contexto = new InitialContext();
        		pool = (DataSource) contexto.lookup("java:comp/env/jdbc/mysql_administracion");

        		if (pool == null) {
        			
        			LOGGER.log(Level.SEVERE,"Error with the pool" );
        		}
        		
        		} catch (NamingException e) {
        			LOGGER.log(Level.SEVERE,"Error loading context" + e.toString());
        		}
        	
        	
            	this.conn = pool.getConnection();

	            boolean valid = conn.isValid(50000);

	            LOGGER.log(Level.INFO, valid ? "TEST OK" : "TEST FAIL");
	
	            return this.conn;

        } catch (java.sql.SQLException sqle) {
        	
            LOGGER.log(Level.SEVERE,"Error: " + sqle );
        }

        return this.conn;
    }

    // Singleton pattern
    private static final MysqlDatabaseConnector instance = new MysqlDatabaseConnector();

    private MysqlDatabaseConnector() {}

}
