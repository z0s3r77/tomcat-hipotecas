package usuarios.dominio.puertos.in;

import java.util.List;
import java.util.Optional;

import usuarios.dominio.modelos.Usuario;


/**
 * Interfaz para el caso de uso de recuperación de un usuario.
 * Esta interfaz define el contrato para la recuperación de un usuario en el sistema.
 */
public interface RetriveUsuarioUseCase {

	/**
	 * Método para obtener un usuario por su identificador.
	 * @param id Identificador del usuario a ser recuperado.
	 * @return Usuario recuperado, si existe.
	 */
	Optional<Usuario> getUsuarioById(int id);

	/**
	 * Método para obtener todos los usuarios.
	 * @return Lista de todos los usuarios.
	 */
	List<Usuario> getAllUsuario();

	/**
	 * Método para obtener un usuario por su correo electrónico.
	 * @param email Correo electrónico del usuario a ser recuperado.
	 * @return Usuario recuperado, si existe.
	 */
	Optional<Usuario> getUsuarioByEmail(String email);

	/**
	 * Método para obtener un usuario por su correo electrónico y contraseña.
	 * @param email Correo electrónico del usuario a ser recuperado.
	 * @param password Contraseña del usuario a ser recuperado.
	 * @return Usuario recuperado, si existe.
	 */
	Optional<Usuario> getUsuarioByEmailAndPassword(String email, String password);
}
