package usuarios.dominio.puertos.in;

/**
 * Interfaz para el caso de uso de eliminación de un usuario.
 * Esta interfaz define el contrato para la eliminación de un usuario en el sistema.
 */
public interface DeleteUsuarioUseCase {

	/**
	 * Método para eliminar un usuario.
	 * @param id Identificador del usuario a ser eliminado.
	 * @return Verdadero si el usuario fue eliminado exitosamente, falso en caso contrario.
	 */
	boolean deleteUsuario(int id);
}
