package prestamos.aplicacion.usecases;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.DeletePrestamoUseCase;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.repositories.PrestamoRepositoryPortImpl;

public class DeletePrestamoUseCaseImpl implements DeletePrestamoUseCase {

    private  final PrestamoRepositoryPort prestamoRepositoryPort;

    public DeletePrestamoUseCaseImpl(){
        this.prestamoRepositoryPort = PrestamoRepositoryPortImpl.getInstance();
    }
    @Override
    public boolean deletePrestamo(Prestamo prestamo) {
        return this.prestamoRepositoryPort.deletePrestamo(prestamo);
    }
}
