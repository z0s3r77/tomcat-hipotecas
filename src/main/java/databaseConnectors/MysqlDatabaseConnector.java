package databaseConnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDatabaseConnector {

    private Connection conn;

    public static Connection getConnection() {
        if (instance.conn == null) {
            return instance.startConnection();
        }
        return instance.conn;
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



    private Connection startConnection() {
        try {
            var connectionUrl = "jdbc:mysql://localhost:3306/administracion";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }

            this.conn = DriverManager.getConnection(connectionUrl, "z0s3r77", "supersecret");

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
