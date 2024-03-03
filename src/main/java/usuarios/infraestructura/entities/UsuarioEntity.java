package usuarios.infraestructura.entities;

import java.util.List;

import prestamos.dominio.modelos.Prestamo;
import usuarios.dominio.modelos.Usuario;

/**
 * Entidad de usuario para la infraestructura de persistencia.
 * Esta entidad representa la estructura de un usuario en la base de datos.
 */
public class UsuarioEntity {

	private int id;
	private String contraseña;
	private String email;
	private String nombre;
	private List<Prestamo> prestamos;



	/**
	 * Constructor vacío de la entidad de usuario.
	 */
	public UsuarioEntity() {
	}

	/**
	 * Constructor de la entidad de usuario.
	 * @param id Identificador del usuario.
	 * @param contraseña Contraseña del usuario.
	 * @param email Correo electrónico del usuario.
	 * @param nombre Nombre del usuario.
	 * @param prestamos Lista de préstamos del usuario.
	 */
	public UsuarioEntity(int id, String contraseña, String email, String nombre, List<Prestamo> prestamos) {
		this.id = id;
		this.contraseña = contraseña;
		this.email = email;
		this.nombre = nombre;
		this.prestamos = prestamos;
	}

	/**
	 * Método para convertir un modelo de dominio de usuario a una entidad de usuario.
	 * @param usuario Modelo de dominio de usuario.
	 * @return Entidad de usuario.
	 */
	public static UsuarioEntity fromDomainModel(Usuario usuario) {
		return new UsuarioEntity(usuario.getId(), usuario.getContraseña(),
				usuario.getEmail(), usuario.getNombre(), usuario.getPrestamos());
	}

	/**
	 * Método para convertir una entidad de usuario a un modelo de dominio de usuario.
	 * @return Modelo de dominio de usuario.
	 */
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
