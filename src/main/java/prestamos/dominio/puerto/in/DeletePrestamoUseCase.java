package prestamos.dominio.puerto.in;

import prestamos.dominio.modelos.Prestamo;

public interface DeletePrestamoUseCase {

    boolean deletePrestamo(Prestamo prestamo);

}
