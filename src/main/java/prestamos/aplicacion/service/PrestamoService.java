package prestamos.aplicacion.service;

import prestamos.aplicacion.usecases.CreatePrestamoUseCaseImpl;
import prestamos.aplicacion.usecases.DeletePrestamoUseCaseImpl;
import prestamos.aplicacion.usecases.RetrivePrestamoUseCaseImpl;
import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.CreatePrestamoUseCase;
import prestamos.dominio.puerto.in.DeletePrestamoUseCase;
import prestamos.dominio.puerto.in.RetrivePrestamosUseCase;

import java.util.List;


public class PrestamoService implements CreatePrestamoUseCase, DeletePrestamoUseCase, RetrivePrestamosUseCase {

    private final CreatePrestamoUseCase createPrestamoUseCase;
    private final DeletePrestamoUseCase deletePrestamoUseCase;
    private final RetrivePrestamosUseCase retrivePrestamosUseCase;

    public PrestamoService(){
        this.createPrestamoUseCase = new CreatePrestamoUseCaseImpl();
        this.deletePrestamoUseCase = new DeletePrestamoUseCaseImpl();
        this.retrivePrestamosUseCase = new RetrivePrestamoUseCaseImpl();
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        return this.createPrestamoUseCase.createPrestamo(prestamo);
    }

    @Override
    public boolean deletePrestamo(Prestamo prestamo) {
        return this.deletePrestamoUseCase.deletePrestamo(prestamo);
    }

    @Override
    public List<Prestamo> getPrestamosFromUsuario(String usuarioEmail) {
        return this.retrivePrestamosUseCase.getPrestamosFromUsuario(usuarioEmail);
    }
}
