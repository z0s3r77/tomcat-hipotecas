package prestamos.dominio.puerto.in;

import prestamos.dominio.modelos.Prestamo;

public interface CreatePrestamoUseCase {

    Prestamo createPrestamo(Prestamo prestamo);

}
