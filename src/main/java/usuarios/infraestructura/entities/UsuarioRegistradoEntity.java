package usuarios.infraestructura.entities;

import java.util.List;

import prestamos.dominio.modelos.Prestamo;
import usuarios.dominio.modelos.Usuario;

public class UsuarioRegistradoEntity {

	private int id;
	private String contraseña;
	private String email;
	private String nombre;
	private List<Prestamo> prestamos;

	

	public UsuarioRegistradoEntity() {
	}
	
	public UsuarioRegistradoEntity(int id, String contraseña, String email, String nombre, List<Prestamo> prestamos) {
		this.id = id;
		this.contraseña = contraseña;
		this.email = email;
		this.nombre = nombre;
		this.prestamos = prestamos;
	}


	public static UsuarioRegistradoEntity fromDomainModel(Usuario usuario) {

		return new UsuarioRegistradoEntity(usuario.getId(), usuario.getContraseña(),
				usuario.getEmail(), usuario.getNombre(), usuario.getPrestamos());

	}
	
	public Usuario toDomainModel() {
		return new Usuario(this.id, this.email, this.nombre, this.contraseña, this.prestamos);
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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

}
