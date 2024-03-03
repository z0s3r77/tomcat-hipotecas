package prestamos.aplicacion.usecases;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.DeletePrestamoUseCase;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.repositories.PrestamoRepositoryPortImpl;

import java.util.logging.Logger;

public class DeletePrestamoUseCaseImpl implements DeletePrestamoUseCase {

    private final PrestamoRepositoryPort prestamoRepositoryPort;
    private static final Logger LOGGER = Logger.getLogger(DeletePrestamoUseCaseImpl.class.getName());


    public DeletePrestamoUseCaseImpl(){
        this.prestamoRepositoryPort = PrestamoRepositoryPortImpl.getInstance();
    }
    @Override
    public boolean deletePrestamo(Prestamo prestamo) {
        boolean isDeleted = this.prestamoRepositoryPort.deletePrestamo(prestamo);
        if (isDeleted) {
            LOGGER.info("Prestamo deleted with id: " + prestamo.getId());
        } else {
            LOGGER.warning("Failed to delete prestamo with id: " + prestamo.getId());
        }
        return isDeleted;
    }
}
