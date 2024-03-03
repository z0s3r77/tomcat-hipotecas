package usuarios.dominio.modelos;

/**
 * Interfaz para el comportamiento de un usuario.
 * Esta interfaz define el contrato para el comportamiento de un usuario en el sistema.
 */
public interface UsuarioComportamiento {

	/**
	 * Método para obtener la dirección IP del usuario.
	 * @return Dirección IP del usuario.
	 */
	public String getIp();

}
