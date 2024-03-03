package usuarios.dominio.puertos.in;

import java.util.Optional;

import usuarios.dominio.modelos.Usuario;

/**
 * Interfaz para el caso de uso de actualización de un usuario.
 * Esta interfaz define el contrato para la actualización de un usuario en el sistema.
 */
public interface UpdateUsuarioUseCase {


	/**
	 * Método para actualizar un usuario.
	 * @param id Identificador del usuario a ser actualizado.
	 * @param usuarioActualizado Datos actualizados del usuario.
	 * @return Usuario actualizado, si existe.
	 */
	Optional<Usuario> updatesUsuario(Long id, Usuario usuarioActualizado);
	
}

