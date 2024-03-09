package databaseConnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DatabaseConnector {

	private Connection conn;

	public static Connection getConnection() {
		if (instance.conn == null) {
			return instance.startConnection();
		}
		return instance.conn;
	}

	private Connection startConnection() {
		try {
			// Utilizamos la URL de conexión de H2 para una base de datos en memoria
			var connectionUrl = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de H2: " + ex);
			}

			// Usuario y contraseña pueden ser vacíos para una base de datos en memoria
			this.conn = DriverManager.getConnection(connectionUrl, "", "");

			cargarDatosIniciales();

			boolean valid = conn.isValid(50000);
			System.out.println(valid ? "TEST OK" : "TEST FAIL");

			return this.conn;

		} catch (SQLException sqle) {
			System.out.println("Error: " + sqle);
		}

		// En caso de que no se realice la conexión estamos perdidos
		return this.conn;
	}


	private void cargarDatosIniciales() throws SQLException {
	    try (Statement stmt = conn.createStatement()) {
	        // Crear la tabla de usuarios
	        String createTableUsuariosSQL = "CREATE TABLE IF NOT EXISTS usuarios (\n"
	                + "    id INT AUTO_INCREMENT PRIMARY KEY,\n" + "    email VARCHAR(255) UNIQUE NOT NULL,\n"
	                + "    nombre VARCHAR(255) NOT NULL,\n" + "    contraseña VARCHAR(255) NOT NULL\n" + ");";
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
					+ "FOREIGN KEY (usuario_id) REFERENCES usuarios(id)"
					+ ")";
			stmt.execute(createTablePrestamosSQL);


	        // Insertar un préstamo para Juan Pérez
	        String insertPrestamoSQL = "INSERT INTO prestamos (capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnMeses, tipoDePrestamo, usuario_id) VALUES "
	                + "(120000.0, 4.5, 1, 1, 'Hipoteca', 1 )";
	        stmt.execute(insertPrestamoSQL);
	    }
	}


	// Singleton pattern
	private static final H2DatabaseConnector instance = new H2DatabaseConnector();

	private H2DatabaseConnector() {
	}

}
