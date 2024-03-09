package usuarios.dominio.modelos;

import java.util.List;

import prestamos.dominio.modelos.Prestamo;

/**
 * Modelo de dominio para un usuario.
 * Esta clase representa a un usuario en el sistema
 */
public class Usuario  {

	private int id;
	private String password;
	private String email;
	private String nombre;
	private List<Prestamo> prestamos;

	/**
	 * Constructor vacío de un usuario.
	 */
	public Usuario() {
		super();
	}


	/**
	 * Constructor de un usuario con un correo electrónico, nombre y lista de préstamos.
	 * @param email Correo electrónico del usuario.
	 * @param nombre Nombre del usuario.
	 * @param prestamos Lista de préstamos del usuario.
	 */
	public Usuario(String email, String nombre, List<Prestamo> prestamos) {
		
		this.email = email;
		this.nombre = nombre;
		this.prestamos = prestamos;

	}

	/**
	 * Constructor de un usuario con un correo electrónico, nombre, contraseña y lista de préstamos.
	 * @param email Correo electrónico del usuario.
	 * @param nombre Nombre del usuario.
	 * @param password Contraseña del usuario.
	 * @param prestamos Lista de préstamos del usuario.
	 */
	public Usuario(String email, String nombre, String password,
				   List<Prestamo> prestamos) {

		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.prestamos = prestamos;
	}

	/**
	 * Constructor de un usuario con un identificador, correo electrónico, nombre, contraseña y lista de préstamos.
	 * @param id Identificador del usuario.
	 * @param email Correo electrónico del usuario.
	 * @param nombre Nombre del usuario.
	 * @param password Contraseña del usuario.
	 * @param prestamos Lista de préstamos del usuario.
	 */
	public Usuario(int id, String email, String nombre, String password,
				   List<Prestamo> prestamos) {

		this.id = id;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [ id=" + id + ", contraseña=" + password + ", email=" + email
				+ ", nombre=" + nombre + ", prestamos=" + prestamos + "]";
	}

}
