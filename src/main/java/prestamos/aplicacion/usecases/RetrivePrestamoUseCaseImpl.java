package prestamos.aplicacion.usecases;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.RetrivePrestamosUseCase;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.repositories.PrestamoRepositoryPortImpl;

import java.util.List;

public class RetrivePrestamoUseCaseImpl implements RetrivePrestamosUseCase {

    private  final PrestamoRepositoryPort prestamoRepositoryPort;

    public RetrivePrestamoUseCaseImpl(){
        this.prestamoRepositoryPort = PrestamoRepositoryPortImpl.getInstance();
    }

    @Override
    public List<Prestamo> getPrestamosFromUsuario(String usuarioEmail) {
        return prestamoRepositoryPort.getAllPrestamosfromUsuario(usuarioEmail);
    }
}
