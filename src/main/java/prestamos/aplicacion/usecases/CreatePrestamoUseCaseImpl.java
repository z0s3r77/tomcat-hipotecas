package prestamos.aplicacion.usecases;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.CreatePrestamoUseCase;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.repositories.PrestamoRepositoryPortImpl;

public class CreatePrestamoUseCaseImpl implements CreatePrestamoUseCase {

    private  final PrestamoRepositoryPort prestamoRepositoryPort;

    public CreatePrestamoUseCaseImpl(){
        this.prestamoRepositoryPort = PrestamoRepositoryPortImpl.getInstance();
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        return prestamoRepositoryPort.save(prestamo);
    }
}
