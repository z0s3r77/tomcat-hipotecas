package usuarios.dominio.modelos;

/**
 * Modelo de dominio para un visitante.
 * Esta clase representa a un visitante en el sistema, que implementa el comportamiento de un usuario.
 */
public class Visitante implements UsuarioComportamiento {

	private String ip;

	/**
	 * Constructor vacío de un visitante.
	 */
	public Visitante() {}

	/**
	 * Constructor de un visitante.
	 * @param ip Dirección IP del visitante.
	 */
	public Visitante(String ip) {
		this.ip = ip;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
}