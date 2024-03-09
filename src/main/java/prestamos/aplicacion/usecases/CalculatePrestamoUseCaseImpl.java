package prestamos.aplicacion.usecases;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.CalculatePrestamoUseCase;

public class CalculatePrestamoUseCaseImpl implements CalculatePrestamoUseCase {


    /**
     * @param prestamo El objeto de préstamo que contiene los detalles iniciales del préstamo. 
     * @return
     */
    @Override
    public Prestamo calculatePrestamo(Prestamo prestamo) {

        prestamo.calcularCuadroAmortizacion();
        prestamo.calcularCuotaMensual();
        return prestamo;
    }
}
