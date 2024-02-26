package prestamos.dominio.puerto;

import prestamos.dominio.modelos.Prestamo;

import java.util.List;

public interface PrestamoRepositoryPort {

	Prestamo save(Prestamo prestamo);
	boolean deletePrestamo(Prestamo prestamo);
	List<Prestamo> getAllPrestamosfromUsuario(String usuarioEmail);

	
}
