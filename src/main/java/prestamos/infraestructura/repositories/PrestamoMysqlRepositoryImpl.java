/**
 * 
 */
package prestamos.infraestructura.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infraestructuracomun.H2DatabaseConnector;
import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.PrestamoRepository;
import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.modelos.UsuarioRegistrado;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

/**
 * @author zoser
 *
 */
public class PrestamoMysqlRepositoryImpl implements PrestamoRepository {

	static Connection con = H2DatabaseConnector.getConnection();

	private final UsuarioRepositoryPort usuarioRepositoryPort;

	public PrestamoMysqlRepositoryImpl(UsuarioRepositoryImpl usuarioRepositoryPort) {

		this.usuarioRepositoryPort = usuarioRepositoryPort;

	}

	@Override
	public void guardarPrestamo(Prestamo prestamo) {

		try {
			String insertPrestamoSQL = "INSERT INTO prestamos (capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnMeses, tipoDePrestamo, usuario_id) "
					+ "VALUES (?, ?, ?, ?, ?, (SELECT id FROM usuarios WHERE email = ?))";

			PreparedStatement pstmt = con.prepareStatement(insertPrestamoSQL);

			pstmt.setDouble(1, prestamo.getCapital());
			pstmt.setDouble(2, prestamo.getInteres());
			pstmt.setInt(3, prestamo.getFrecuenciaDePagoEnMeses());
			pstmt.setInt(4, prestamo.getPlazoDeAmortizacionEnMeses());
			pstmt.setString(5, prestamo.getClass().toString());
			pstmt.setString(6, ((UsuarioRegistrado) prestamo.getUsuario()).getEmail());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminarPrestamo(Prestamo prestamo) {

		String eliminarPrestamoSQL = "DELETE FROM prestamos WHERE " + "capital = ? AND " + "interes = ? AND "
				+ "frecuenciaDePagoEnMeses = ? AND " + "plazoDeAmortizacionEnMeses = ? AND " + "tipoDePrestamo = ? AND "
				+ "usuario_id = (SELECT id FROM usuarios WHERE email = ?)";

		try (PreparedStatement eliminarPrestamoStmt = con.prepareStatement(eliminarPrestamoSQL)) {

			eliminarPrestamoStmt.setDouble(1, prestamo.getCapital());
			eliminarPrestamoStmt.setDouble(2, prestamo.getInteres());
			eliminarPrestamoStmt.setInt(3, prestamo.getFrecuenciaDePagoEnMeses());
			eliminarPrestamoStmt.setInt(4, prestamo.getPlazoDeAmortizacionEnMeses());
			eliminarPrestamoStmt.setString(5, prestamo.getClass().toString()); // tipoDePrestamo
			eliminarPrestamoStmt.setString(6, ((UsuarioRegistrado) prestamo.getUsuario()).getEmail());

			int filasAfectadas = eliminarPrestamoStmt.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Se eliminó el préstamo con éxito.");
			} else {
				System.out.println("No se encontró un préstamo con los atributos proporcionados.");
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Manejar la excepción adecuadamente en tu aplicación
		}

	}

	@Override
	public List<Prestamo> obtenerTodosLosPrestamosDeUnUsuario(String usuarioEmail) {
		
		Usuario usuario = usuarioRepositoryPort.findByEmail(usuarioEmail).orElseThrow();
		
	    List<Prestamo> prestamos = new ArrayList<>();
	    
		
	    String obtenerPrestamosSQL = "SELECT * FROM prestamos WHERE usuario_id = (SELECT id FROM usuarios WHERE email = ?)";
	    
	    try (PreparedStatement obtenerPrestamosStmt = con.prepareStatement(obtenerPrestamosSQL)) {
	        obtenerPrestamosStmt.setString(1, usuarioEmail);
	        
	        
	        try (ResultSet resultSet = obtenerPrestamosStmt.executeQuery()) {
	            while (resultSet.next()) {
	                Prestamo prestamo = new Hipoteca();
	                prestamo.setCapital(resultSet.getDouble("capital"));
	                prestamo.setInteres(resultSet.getDouble("interes"));
	                prestamo.setFrecuenciaDePagoEnMeses(resultSet.getInt("frecuenciaDePagoEnMeses"));
	                prestamo.setPlazoDeAmortizacionEnMeses(resultSet.getInt("plazoDeAmortizacionEnMeses"));
	                prestamo.setTipoPrestamo(resultSet.getString("tipoDePrestamo"));

	                // Aquí debes cargar el usuario asociado al préstamo utilizando la subquery
	                prestamo.setUsuario(usuario);

	                prestamos.add(prestamo);
	            }
	        }
	        
	        

	    } catch (SQLException e) {
	        e.printStackTrace(); // Manejar la excepción adecuadamente en tu aplicación
	    }

	    
	    return prestamos;
	}

}
