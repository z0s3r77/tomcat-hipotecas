package prestamos.dominio.puerto.in;

import prestamos.dominio.modelos.Prestamo;

import java.util.List;

/**
 * Interfaz para el caso de uso de obtención de préstamos asociados a un usuario en la capa de aplicación.
 *
 * En el contexto de arquitectura hexagonal, esta interfaz representa el puerto de entrada que será implementado
 * por un adaptador en la capa de aplicación de la aplicación. La implementación concreta de esta interfaz se
 * encargará de interactuar con la capa de dominio para obtener la lista de préstamos asociados a un usuario.
 *
 * @see Prestamo
 * @see RetrivePrestamosUseCaseImpl
 * @see PrestamoService
 */
public interface RetrivePrestamosUseCase {

    /**
     * Método que define la obtención de la lista de préstamos asociados a un usuario.
     *
     * @param usuarioEmail El correo electrónico del usuario para el cual se desean obtener los préstamos.
     * @return Lista de préstamos asociados al usuario.
     */
    List<Prestamo> getPrestamosFromUsuario(int usuarioId);

}
