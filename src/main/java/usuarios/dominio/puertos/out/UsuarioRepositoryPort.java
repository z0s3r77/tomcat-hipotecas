package usuarios.dominio.puertos.out;

import java.util.List;
import java.util.Optional;

import usuarios.dominio.modelos.Usuario;

/**
 * Interfaz para el puerto de repositorio de usuario.
 * Esta interfaz define el contrato para las operaciones de repositorio de un usuario en el sistema.
 */
public interface UsuarioRepositoryPort {

	/**
	 * Método para guardar un usuario.
	 * @param usuario Usuario a ser guardado.
	 * @return Usuario guardado.
	 */
	Usuario save(Usuario usuario);

	/**
	 * Método para encontrar un usuario por su identificador.
	 * @param id Identificador del usuario a ser encontrado.
	 * @return Usuario encontrado, si existe.
	 */
	Optional<Usuario> findById(int id);

	/**
	 * Método para encontrar todos los usuarios.
	 * @return Lista de todos los usuarios.
	 */
	List<Usuario> findAll();

	/**
	 * Método para actualizar un usuario.
	 * @param usuario Usuario a ser actualizado.
	 * @return Usuario actualizado, si existe.
	 */
	Optional<Usuario> update(Usuario usuario);

	/**
	 * Método para eliminar un usuario por su identificador.
	 * @param id Identificador del usuario a ser eliminado.
	 * @return Verdadero si el usuario fue eliminado exitosamente, falso en caso contrario.
	 */
	boolean deleteById(int id);

	/**
	 * Método para encontrar un usuario por su correo electrónico.
	 * @param email Correo electrónico del usuario a ser encontrado.
	 * @return Usuario encontrado, si existe.
	 */
	Optional<Usuario> findByEmail(String email);
}
