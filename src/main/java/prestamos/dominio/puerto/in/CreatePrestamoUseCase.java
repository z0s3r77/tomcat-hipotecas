/**
 * Interfaz para el caso de uso de creación de préstamos en la capa de aplicación.
 *
 * <p>En el contexto de arquitectura hexagonal, esta interfaz representa el puerto de entrada que será implementado
 * por un adaptador en la capa de infraestructura.</p>
 *
 * @see Prestamo
 * @see CreatePrestamoUseCaseImpl
 *
 */
package prestamos.dominio.puerto.in;

import prestamos.dominio.modelos.Prestamo;

/**
 * Interfaz para el caso de uso de creación de préstamos en la capa de aplicación.
 *
 * <p>En el contexto de arquitectura hexagonal, esta interfaz representa el puerto de entrada que será implementado
 * por un adaptador en la capa de infraestructura.</p>
 *
 * @see Prestamo
 * @see CreatePrestamoUseCaseImpl
 * @see PrestamoService
 *
 */
public interface CreatePrestamoUseCase {

    /**
     * Método que define la creación de un nuevo préstamo.
     *
     * @param prestamo El objeto {@link Prestamo} que se desea crear.
     * @return El préstamo creado.
     */
    Prestamo createPrestamo(Prestamo prestamo);

}
