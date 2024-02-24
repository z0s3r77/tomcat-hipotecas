package usuarios.aplicacion;

import java.util.List;

import interfaces.Usuario;
import interfaces.Prestamo;


public class UsuarioRegistrado extends Usuario {
	
	private String email;
	private String nombre;
	private List<Prestamo> prestamos;
	
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
