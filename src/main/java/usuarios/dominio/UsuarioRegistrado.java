package usuarios.dominio;

import java.util.List;

import prestamos.dominio.Prestamo;

public class UsuarioRegistrado implements Usuario {

	private String ip;
	private String email;
	private String nombre;
	private List<Prestamo> prestamos;
	
	public UsuarioRegistrado() {
		super();
	}
	
	public UsuarioRegistrado(String ip) {
		this.ip = ip;
	}
	public UsuarioRegistrado(String email, String nombre, List<Prestamo> prestamos) {
		
		this.email = email;
		this.nombre = nombre;
		this.prestamos = prestamos;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
}
