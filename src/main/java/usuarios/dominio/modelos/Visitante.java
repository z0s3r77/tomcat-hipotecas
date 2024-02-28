package usuarios.dominio.modelos;

public class Visitante implements UsuarioComportamiento {

	private String ip;
	
	public Visitante() {}
	
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