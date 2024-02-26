/**
 * Puerto de salida para la gestión de préstamos en el dominio del sistema.
 *
 * <p>
 * Este puerto proporciona métodos para la persistencia y recuperación de objetos {@link Prestamo}. Las implementaciones
 * concretas de este puerto se encuentran en la capa de infraestructura y son responsables de interactuar con el
 * almacenamiento de datos, como una base de datos, para llevar a cabo operaciones relacionadas con préstamos.
 * </p>
 *
 * @see Prestamo
 * @since [Fecha de creación]
 */
package prestamos.dominio.puerto.out;

import prestamos.dominio.modelos.Prestamo;

import java.util.List;

/**
 * Puerto de salida para la gestión de préstamos en el dominio del sistema.
 *
 * <p>
 * Este puerto proporciona métodos para la persistencia y recuperación de objetos {@link Prestamo}. Las implementaciones
 * concretas de este puerto se encuentran en la capa de infraestructura y son responsables de interactuar con el
 * almacenamiento de datos, como una base de datos, para llevar a cabo operaciones relacionadas con préstamos.
 * </p>
 *
 * @see Prestamo
 * @since [Fecha de creación]
 */
public interface PrestamoRepositoryPort {

	/**
	 * Guarda un préstamo en el repositorio.
	 *
	 * @param prestamo El objeto {@link Prestamo} que se desea guardar.
	 * @return El préstamo guardado.
	 */
	Prestamo save(Prestamo prestamo);

	/**
	 * Elimina un préstamo del repositorio.
	 *
	 * @param prestamo El objeto {@link Prestamo} que se desea eliminar.
	 * @return `true` si la eliminación fue exitosa, `false` si no se pudo eliminar.
	 */
	boolean deletePrestamo(Prestamo prestamo);

	/**
	 * Obtiene todos los préstamos asociados a un usuario.
	 *
	 * @param usuarioEmail El correo electrónico del usuario para el cual se desean obtener los préstamos.
	 * @return Lista de préstamos asociados al usuario.
	 */
	List<Prestamo> getAllPrestamosfromUsuario(String usuarioEmail);

}
