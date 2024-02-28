package usuarios.dominio.modelos;

import java.util.List;

import prestamos.dominio.modelos.Prestamo;

public class Usuario implements UsuarioComportamiento {

	private String ip;
	private int id;
	private String contraseña;
	private String email;
	private String nombre;
	private List<Prestamo> prestamos;
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String ip) {
		this.ip = ip;
	}
	public Usuario(String email, String nombre, List<Prestamo> prestamos) {
		
		this.email = email;
		this.nombre = nombre;
		this.prestamos = prestamos;

	}
	
	public Usuario(String email, String nombre, String contraseña,
				   List<Prestamo> prestamos) {

		this.contraseña = contraseña;
		this.email = email;
		this.nombre = nombre;
		this.prestamos = prestamos;
	}
	
	public Usuario(int id, String email, String nombre, String contraseña,
				   List<Prestamo> prestamos) {

		this.id = id;
		this.contraseña = contraseña;
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


	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UsuarioRegistrado [ip=" + ip + ", id=" + id + ", contraseña=" + contraseña + ", email=" + email
				+ ", nombre=" + nombre + ", prestamos=" + prestamos + "]";
	}
	
	
	
	
}
