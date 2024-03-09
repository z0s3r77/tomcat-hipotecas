package prestamos.aplicacion.usecases;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.CalculatePrestamoUseCase;

public class CalculatePrestamoUseCaseImpl implements CalculatePrestamoUseCase {

    @Override
    public Prestamo calculatePrestamo(Prestamo prestamo) {

        prestamo.calcularCuadroAmortizacion();
        prestamo.calcularCuotaMensual();
        return prestamo;
    }
}
