package prestamos.aplicacion.usecases;

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
    public boolean deletePrestamo(int prestamoId) {
        boolean isDeleted = this.prestamoRepositoryPort.deletePrestamo(prestamoId);
        if (isDeleted) {
            LOGGER.info("Prestamo deleted with id: " + prestamoId);
        } else {
            LOGGER.warning("Failed to delete prestamo with id: " + prestamoId);
        }
        return isDeleted;
    }
}
