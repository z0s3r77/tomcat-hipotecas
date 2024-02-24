package usuarios.dominio;

import interfaces.Usuario;

public class UsuarioNoRegistrado implements Usuario  {

	private String ip;
	
	public UsuarioNoRegistrado() {}
	
	public UsuarioNoRegistrado(String ip) {
		this.ip = ip;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
}