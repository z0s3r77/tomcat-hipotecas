package prestamos.dominio.puerto.in;

import prestamos.dominio.modelos.Prestamo;

public interface CalculatePrestamoUseCase {

    /**
     * Calcula los detalles de un préstamo dado un objeto de préstamo.
     *
     * @param prestamo El objeto de préstamo que contiene los detalles iniciales del préstamo.
     * @return Un objeto de préstamo que contiene los detalles calculados del préstamo.
     */
    Prestamo calculatePrestamo(Prestamo prestamo);
}
