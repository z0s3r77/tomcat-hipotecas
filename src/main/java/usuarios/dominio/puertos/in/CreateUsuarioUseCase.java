package usuarios.dominio.puertos.in;

import usuarios.dominio.modelos.Usuario;

/**
 * Interfaz para el caso de uso de creación de un usuario.
 * Esta interfaz define el contrato para la creación de un usuario en el sistema.
 */
public interface CreateUsuarioUseCase {

	/**
	 * Método para crear un usuario.
	 * @param usuario Usuario a ser creado.
	 * @return Usuario creado.
	 */
	Usuario createUsuario(Usuario usuario);

	/**
	 * Crea un nuevo usuario con los parámetros proporcionados.
	 * @param correo El correo del usuario.
	 * @param usuario El nombre de usuario.
	 * @param password La contraseña del usuario.
	 * @return Un objeto de usuario con los detalles proporcionados.
	 */
	Usuario createUsuario(String correo, String usuario, String password);

}