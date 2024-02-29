package usuarios.infraestructura.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import infraestructuracomun.H2DatabaseConnector;
import usuarios.infraestructura.entities.UsuarioEntity;

public class UsuarioRegistradoEntityMysqlRepositoryImpl {

	static Connection con = H2DatabaseConnector.getConnection();
	public UsuarioRegistradoEntityMysqlRepositoryImpl(){}

	//TODO pensar si está  clase puede ser Generalizada para todos los repositorios

    public UsuarioEntity save(UsuarioEntity usuario) {

		UsuarioEntity usuarioGuardado = null;

		try {
		    String insertUsuarioSQL = "INSERT INTO usuarios (nombre, email, contraseña) VALUES (?, ?, ?)";

		    PreparedStatement pstmt = con.prepareStatement(insertUsuarioSQL, Statement.RETURN_GENERATED_KEYS);

		    pstmt.setString(1, usuario.getNombre());
		    pstmt.setString(2, usuario.getEmail());
		    pstmt.setString(3, usuario.getContraseña());

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
		            usuarioGuardado.setContraseña(usuario.getContraseña());
		        }
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		return usuarioGuardado;

	}

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
				usuario.setContraseña(rs.getString("contraseña"));
				return Optional.of(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

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
				usuario.setContraseña(rs.getString("contraseña"));
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}


	public Optional<UsuarioEntity> update(UsuarioEntity usuario) {

		try {
			String updateUsuarioSQL = "UPDATE usuarios SET email=?, nombre=?, contraseña=? WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(updateUsuarioSQL);

			pstmt.setString(1, usuario.getEmail());
			pstmt.setString(2, usuario.getNombre());
			pstmt.setString(3, usuario.getContraseña());
			pstmt.setInt(4, usuario.getId());

			int affectedRows = pstmt.executeUpdate();

			if (affectedRows > 0) {
				return Optional.of(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public boolean deleteById(int id) {
		try {
			String deleteUsuarioSQL = "DELETE FROM usuarios WHERE id=?";
			PreparedStatement pstmt = con.prepareStatement(deleteUsuarioSQL);

			pstmt.setLong(1, id);

			int affectedRows = pstmt.executeUpdate();

			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
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
            e.printStackTrace();
        }

        return false;
    }
    
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
				usuario.setContraseña(rs.getString("contraseña"));
				return Optional.of(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public Optional<UsuarioEntity> findByEmailAndPassword(String email, String password) {
		try {
			String selectUsuarioSQL = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ?";
			PreparedStatement pstmt = con.prepareStatement(selectUsuarioSQL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UsuarioEntity usuario = new UsuarioEntity();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setContraseña(rs.getString("contraseña"));
				return Optional.of(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}
}
