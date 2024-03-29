package usuarios.infraestructura.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import databaseConnectors.MysqlDatabaseConnector;
import usuarios.infraestructura.entities.UsuarioEntity;

/**
 * Implementación del repositorio de usuarios registrados para MySQL.
 * Esta clase proporciona la implementación de las operaciones de base de datos para la entidad Usuario.
 */
public class UsuarioRegistradoEntityMysqlRepositoryImpl {

	static Connection con = MysqlDatabaseConnector.getConnection();
	private static final Logger LOGGER = Logger.getLogger(UsuarioRegistradoEntityMysqlRepositoryImpl.class.getName());

	/**
	 * Constructor del repositorio de usuarios registrados.
	 */
	public UsuarioRegistradoEntityMysqlRepositoryImpl(){}


	//TODO pensar si está  clase puede ser Generalizada para todos los repositorios

	/**
	 * Método para guardar un usuario en la base de datos.
	 * @param usuario Usuario a guardar.
	 * @return Usuario guardado con el ID generado.
	 */
    public UsuarioEntity save(UsuarioEntity usuario) {

		UsuarioEntity usuarioGuardado = null;

		try {
		    String insertUsuarioSQL = "INSERT INTO usuarios (nombre, email, password) VALUES (?, ?, ?)";

		    PreparedStatement pstmt = con.prepareStatement(insertUsuarioSQL, Statement.RETURN_GENERATED_KEYS);

		    pstmt.setString(1, usuario.getNombre());
		    pstmt.setString(2, usuario.getEmail());
		    pstmt.setString(3, usuario.getPassword());

		    int affectedRows = pstmt.executeUpdate();

		    if (affectedRows > 0) {
		        ResultSet generatedKeys = pstmt.getGeneratedKeys();

		        if (generatedKeys.next()) {
		            int usuarioId = generatedKeys.getInt(1);

		            // Crear el objeto Usuario con el ID generado
		            usuarioGuardado = new UsuarioEntity();
		            usuarioGuardado.setId(usuarioId);
		            usuarioGuardado.setEmail(usuario.getEmail());
		            usuarioGuardado.setNombre(usuario.getNombre());
		            usuarioGuardado.setPassword(usuario.getPassword());
		        }
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		return usuarioGuardado;
	}

	/**
	 * Método para encontrar un usuario por su identificador.
	 * @param id Identificador del usuario.
	 * @return Usuario encontrado, si existe.
	 */
	public Optional<UsuarioEntity> findById(int id) {
		try {
			String selectUsuarioSQL = "SELECT * FROM usuarios WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(selectUsuarioSQL);
			pstmt.setLong(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UsuarioEntity usuario = new UsuarioEntity();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				return Optional.of(usuario);
			}
		} catch (SQLException e) {

			LOGGER.log(Level.SEVERE, "Error saving finding User " + e.getMessage());
		}

		return Optional.empty();
	}

	/**
	 * Método para encontrar todos los usuarios.
	 * @return Lista de todos los usuarios.
	 */
	public List<UsuarioEntity> findAll() {

		List<UsuarioEntity> usuarios = new ArrayList<>();

		try {
			String selectAllUsuariosSQL = "SELECT * FROM usuarios";
			PreparedStatement pstmt = con.prepareStatement(selectAllUsuariosSQL);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				UsuarioEntity usuario = new UsuarioEntity();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				usuarios.add(usuario);
			}

		} catch (SQLException e) {

			LOGGER.log(Level.SEVERE, "Error saving finding all User " + e.getMessage());
		}

		return usuarios;
	}

	/**
	 * Método para actualizar un usuario.
	 * @param usuario Usuario a actualizar.
	 * @return Usuario actualizado, si existe.
	 */
	public Optional<UsuarioEntity> update(UsuarioEntity usuario) {

		try {
			String updateUsuarioSQL = "UPDATE usuarios SET email=?, nombre=?, password=? WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(updateUsuarioSQL);

			pstmt.setString(1, usuario.getEmail());
			pstmt.setString(2, usuario.getNombre());
			pstmt.setString(3, usuario.getPassword());
			pstmt.setInt(4, usuario.getId());

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows > 0) {
				return Optional.of(usuario);
			}
		} catch (SQLException e) {

			LOGGER.log(Level.SEVERE, "Error updating User " + e.getMessage());
		}

		return Optional.empty();
	}

	/**
	 * Método para eliminar un usuario por su identificador.
	 * @param id Identificador del usuario.
	 * @return Verdadero si el usuario fue eliminado exitosamente, falso en caso contrario.
	 */
	public boolean deleteById(int id) {
		try {
			String deleteUsuarioSQL = "DELETE FROM usuarios WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(deleteUsuarioSQL);

			pstmt.setLong(1, id);

			int affectedRows = pstmt.executeUpdate();

			return affectedRows > 0;
		} catch (SQLException e) {
			
			LOGGER.log(Level.SEVERE, "Error deleting User " + e.getMessage());
		}

		return false;
	}

	/**
	 * Método para verificar si existe un usuario por su identificador.
	 * @param id Identificador del usuario.
	 * @return Verdadero si el usuario existe, falso en caso contrario.
	 */
    public boolean existsById(int id) {
        try {
            String countUsuariosSQL = "SELECT COUNT(*) FROM usuarios WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(countUsuariosSQL);

            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int rowCount = rs.getInt(1);
                return rowCount > 0;
            }
        } catch (SQLException e) {
        	
			LOGGER.log(Level.SEVERE, "Error cheking User " + e.getMessage());
        }

        return false;
    }

	/**
	 * Método para encontrar un usuario por su correo electrónico.
	 * @param email Correo electrónico del usuario.
	 * @return Usuario encontrado, si existe.
	 */
    public Optional<UsuarioEntity> findByEmail(String email) {
		try {
			String selectUsuarioSQL = "SELECT * FROM usuarios WHERE email = ?";
			PreparedStatement pstmt = con.prepareStatement(selectUsuarioSQL);
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UsuarioEntity usuario = new UsuarioEntity();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setPassword(rs.getString("password"));
				return Optional.of(usuario);
			}
		} catch (SQLException e) {

			LOGGER.log(Level.SEVERE, "Error finding User by email " + e.getMessage());
		}

		return Optional.empty();
	}
}
