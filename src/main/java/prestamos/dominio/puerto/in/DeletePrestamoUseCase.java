package prestamos.dominio.puerto.in;

import prestamos.dominio.modelos.Prestamo;

/**
 * Interfaz para el caso de uso de eliminación de préstamos en la capa de aplicación.
 *
 * En el contexto de arquitectura hexagonal, esta interfaz representa el puerto de entrada que será implementado
 * por un adaptador en la capa de infraestructura de la aplicación. La implementación concreta de esta interfaz se
 * encargará de interactuar con la capa de dominio para llevar a cabo la lógica de eliminación de préstamos.
 *
 * @see Prestamo
 * @see DeletePrestamoUseCaseImpl
 * @see PrestamoService
 */
public interface DeletePrestamoUseCase {

    /**
     * Método que define la eliminación de un préstamo existente.
     *
     * @param prestamo El objeto {@link Prestamo} que se desea eliminar.
     * @return `true` si la eliminación fue exitosa, `false` si no se pudo eliminar.
     */
    boolean deletePrestamo(Prestamo prestamo);

}
