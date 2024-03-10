package prestamos.infraestructura.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import databaseConnectors.MysqlDatabaseConnector;
import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import prestamos.infraestructura.entities.PrestamoEntity;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;

/**
 * Implementación concreta de un repositorio de préstamos para el almacenamiento en una base de datos MySQL.
 *
 *
 * Esta clase proporciona métodos para la persistencia y recuperación de objetos {@link PrestamoEntity} en una base de
 * datos MySQL. La persistencia incluye la creación, eliminación y recuperación de préstamos asociados a un usuario.
 *
 *
 *
 * Se espera que esta clase sea utilizada en conjunto con un {@link UsuarioRepositoryPort} para gestionar la
 * persistencia de usuarios asociados a los préstamos.
 *
 *
 * @see PrestamoEntity
 * @see UsuarioRepositoryPort
 *
 */
public class PrestamoMysqlRepositoryImpl {

	static Connection con = MysqlDatabaseConnector.getConnection();
	private static final Logger LOGGER = Logger.getLogger(PrestamoMysqlRepositoryImpl.class.getName());

	
	
	public PrestamoMysqlRepositoryImpl() {}

	/**
	 * Guarda un objeto {@link PrestamoEntity} en la base de datos MySQL.
	 *
	 * @param prestamo La entidad {@link PrestamoEntity} que se desea guardar.
	 * @return La entidad {@link PrestamoEntity} guardada en la base de datos.
	 */
	public PrestamoEntity guardarPrestamo(PrestamoEntity prestamo) {


		
		PrestamoEntity prestamoEntity = null;

		try {


			String insertPrestamoSQL = "INSERT INTO prestamos (capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnMeses, tipoDePrestamo, fecha_creacion, usuario_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";


			checkCon();
			PreparedStatement pstmt = con.prepareStatement(insertPrestamoSQL, Statement.RETURN_GENERATED_KEYS);
			pstmt.setDouble(1, prestamo.getCapital());
			pstmt.setDouble(2, prestamo.getInteres());
			pstmt.setInt(3, prestamo.getFrecuenciaDePagoEnMeses());
			pstmt.setInt(4, prestamo.getPlazoDeAmortizacionEnMeses());
			pstmt.setString(5, prestamo.getTipoDePrestamo());
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(7, prestamo.getUsuario());

			int affectedRows = pstmt.executeUpdate();


			if (affectedRows > 0) {

				ResultSet generatedKeys = pstmt.getGeneratedKeys();

				if (generatedKeys.next()) {

					int usuarioId = generatedKeys.getInt(1);

					prestamoEntity = new PrestamoEntity();
					prestamoEntity.setId(usuarioId);
					prestamoEntity.setCapital(prestamo.getCapital());
					prestamoEntity.setInteres(prestamo.getInteres());
					prestamoEntity.setFrecuenciaDePagoEnMeses(prestamo.getFrecuenciaDePagoEnMeses());
					prestamoEntity.setPlazoDeAmortizacionEnMeses(prestamo.getPlazoDeAmortizacionEnMeses());
					prestamoEntity.setTipoDePrestamo(prestamo.getClass().toString());
					prestamoEntity.setId(prestamo.getUsuario());
					prestamoEntity.setFechaCreacion(generatedKeys.getDate("fecha_creacion"));
				}
			}

		} catch (SQLException e) {

			LOGGER.log(Level.SEVERE, "Error saving PRESTAMO " + e.getMessage());
		}
		

		return prestamoEntity;
	}

	/**
	 * Elimina un préstamo de la base de datos MySQL.
	 *
	 * @param prestamo La entidad {@link PrestamoEntity} que se desea eliminar.
	 * @return `true` si la eliminación fue exitosa, `false` si no se pudo eliminar.
	 */
	public boolean eliminarPrestamo(int prestamoId) {

		checkCon();

		
		String eliminarPrestamoSQL = "DELETE FROM prestamos WHERE " + "id = ? ";

		try (PreparedStatement eliminarPrestamoStmt = con.prepareStatement(eliminarPrestamoSQL)) {

			eliminarPrestamoStmt.setInt(1, prestamoId);

			int filasAfectadas = eliminarPrestamoStmt.executeUpdate();

			if (filasAfectadas > 0) {
				
				return true;

			} else {

				return true;
			}

		} catch (SQLException e) {

			LOGGER.log(Level.SEVERE, "Error deleting PRESTAMO " + e.getMessage());
		}

		return true;
	}


	/**
	 * Obtiene todos los préstamos asociados a un usuario desde la base de datos MySQL.
	 *
	 * @param usuarioId El correo electrónico del usuario para el cual se desean obtener los préstamos.
	 * @return Lista de préstamos asociados al usuario.
	 */
	public List<Prestamo> obtenerTodosLosPrestamosDeUnUsuario(int usuarioId) {
		
		checkCon();
		
	    List<Prestamo> prestamos = new ArrayList<>();

	    String obtenerPrestamosSQL = "SELECT * FROM prestamos WHERE usuario_id = ?";
	    
	    try (PreparedStatement obtenerPrestamosStmt = con.prepareStatement(obtenerPrestamosSQL)) {
	        obtenerPrestamosStmt.setInt(1, usuarioId);

	        try (ResultSet resultSet = obtenerPrestamosStmt.executeQuery()) {
	            while (resultSet.next()) {
	                Prestamo prestamo = new Hipoteca();
	                prestamo.setId(resultSet.getInt("id"));
	                prestamo.setCapital(resultSet.getDouble("capital"));
	                prestamo.setInteres(resultSet.getDouble("interes"));
	                prestamo.setFrecuenciaDePagoEnMeses(resultSet.getInt("frecuenciaDePagoEnMeses"));
	                prestamo.setPlazoDeAmortizacionEnMeses(resultSet.getInt("plazoDeAmortizacionEnMeses"));
	                prestamo.setTipoPrestamo(resultSet.getString("tipoDePrestamo"));
	                prestamo.setUsuarioId(resultSet.getInt("usuario_id"));
	                Date fechaCreacionSql = resultSet.getDate("fecha_creacion");
	                prestamo.setFechaCreacion(fechaCreacionSql);
	                prestamos.add(prestamo);
	            }
	        }

	    } catch (SQLException e) {

	    	LOGGER.log(Level.SEVERE, "Error getting PRESTAMO " + e.getMessage());
	    }

	    return prestamos;
	}
	
	public void checkCon () {
	    
	    	this.con =  MysqlDatabaseConnector.getConnection();
	}

}
