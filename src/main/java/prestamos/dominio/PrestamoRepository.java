package prestamos.dominio;

import java.util.List;

public interface PrestamoRepository {

	void guardarPrestamo(Prestamo prestamo);
	void eliminarPrestamo(Prestamo prestamo);
	List<Prestamo> obtenerTodosLosPrestamosDeUnUsuario(int usuarioId);

	
}
