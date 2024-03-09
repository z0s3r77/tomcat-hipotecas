package prestamos.dominio.puerto.in;

import prestamos.dominio.modelos.Prestamo;

/**
 * Interfaz para el caso de uso de creación de préstamos en la capa de aplicación.
 * En el contexto de arquitectura hexagonal, esta interfaz representa el puerto de entrada que será implementado
 * por un adaptador en la capa de infraestructura.
 *
 * @see Prestamo
 */
public interface CreatePrestamoUseCase {

    /**
     * Método que define la creación de un nuevo préstamo.
     *
     * @param prestamo El objeto {@link Prestamo} que se desea crear.
     * @return El préstamo creado.
     */
    Prestamo createPrestamo(Prestamo prestamo);

    /**
     * Crea un nuevo préstamo con los parámetros proporcionados.
     *
     * @param capital El capital inicial del préstamo.
     * @param interes La tasa de interés anual del préstamo.
     * @param frecuenciaDePagoEnMeses La frecuencia de pago en meses del préstamo.
     * @param plazoDeAmortizacionEnAnnos El plazo de amortización en años del préstamo.
     * @param usuarioId El identificador del usuario que solicita el préstamo.
     * @return Un objeto de préstamo con los detalles proporcionados.
     */
    Prestamo makeHipoteca(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnAnnos, int usuarioId);

}
