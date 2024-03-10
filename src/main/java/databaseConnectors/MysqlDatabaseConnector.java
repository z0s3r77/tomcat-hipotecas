package databaseConnectors;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MysqlDatabaseConnector {

	private DataSource pool;
    private Connection conn;

    public static Connection getConnection() {
        if (instance.conn == null) {
            try {
				return instance.startConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return instance.conn;
    }

    private void cargarDatosIniciales() throws SQLException {
    	
    	System.out.println("Cargando datos inciales");
    	
        try (Statement stmt = conn.createStatement()) {
            // Crear la tabla de usuarios
            String createTableUsuariosSQL = "CREATE TABLE IF NOT EXISTS usuarios (\n"
                    + "    id INT AUTO_INCREMENT PRIMARY KEY,\n" + "    email VARCHAR(255) UNIQUE NOT NULL,\n"
                    + "    nombre VARCHAR(255) NOT NULL,\n" + "    password VARCHAR(255) NOT NULL\n" + ");";
            stmt.execute(createTableUsuariosSQL);


            // Insertar datos iniciales de usuario 1
            String insertDataUsuarioSQL1 = "INSERT INTO usuarios (nombre, email, contraseña) VALUES "
                    + "('Juan Pérez', 'usuario1@example.com', 'contraseña123')";
            stmt.execute(insertDataUsuarioSQL1);

            // Crear la tabla de préstamos
            String createTablePrestamosSQL = "CREATE TABLE IF NOT EXISTS prestamos ("
                    + "id INT  AUTO_INCREMENT PRIMARY KEY,"
                    + "capital DOUBLE,"
                    + "interes DOUBLE,"
                    + "frecuenciaDePagoEnMeses INT,"
                    + "plazoDeAmortizacionEnMeses INT,"
                    + "tipoDePrestamo VARCHAR(255),"
                    + "usuario_id INT,"
                    + "fecha_creacion DATE,"  // Nueva columna fecha_creacion de tipo DATE
                    + "FOREIGN KEY (usuario_id) REFERENCES usuarios(id)"
                    + ")";
            stmt.execute(createTablePrestamosSQL);

        }
    }



    private Connection startConnection() throws NamingException {
        try {
        	
        	        	
        	try {
        		// Un objeto InitialContext nos permite ejecutar operaciones con
        		// nombres.
        		InitialContext contexto = new InitialContext();
        		// Utilizamos el objeto InitialContext para acceder al pool de
        		// conexiones.
        		pool = (DataSource) contexto.lookup("java:comp/env/jdbc/mysql_administracion");

        		if (pool == null) {
        			System.out.print("Error al acceder al pool");
        		}
        		
        		} catch (NamingException e) {
        		System.out.println("Error al acceder al contexto");
        		e.printStackTrace();
        		}
        	
        	
            this.conn = pool.getConnection();

             // cargarDatosIniciales();

            boolean valid = conn.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");

            return this.conn;

        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

        // En caso de que no se realice la conexión estamos perdidos
        return this.conn;
    }

    // Singleton pattern
    private static final MysqlDatabaseConnector instance = new MysqlDatabaseConnector();

    private MysqlDatabaseConnector() {}

}
