package prestamos.dominio.puerto;

import prestamos.dominio.modelos.Prestamo;

import java.util.List;

public interface PrestamoRepository {

	void guardarPrestamo(Prestamo prestamo);
	void eliminarPrestamo(Prestamo prestamo);
	List<Prestamo> obtenerTodosLosPrestamosDeUnUsuario(String usuarioEmail);

	
}
