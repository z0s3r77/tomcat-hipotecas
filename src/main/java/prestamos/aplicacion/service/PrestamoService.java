package prestamos.aplicacion.service;

import prestamos.aplicacion.usecases.CalculatePrestamoUseCaseImpl;
import prestamos.aplicacion.usecases.CreatePrestamoUseCaseImpl;
import prestamos.aplicacion.usecases.DeletePrestamoUseCaseImpl;
import prestamos.aplicacion.usecases.RetrivePrestamoUseCaseImpl;
import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.CalculatePrestamoUseCase;
import prestamos.dominio.puerto.in.CreatePrestamoUseCase;
import prestamos.dominio.puerto.in.DeletePrestamoUseCase;
import prestamos.dominio.puerto.in.RetrivePrestamosUseCase;

import java.util.List;

/**
 * Servicio para la gestión de préstamos.
 *
 * Esta clase implementa las interfaces CreatePrestamoUseCase, DeletePrestamoUseCase y RetrivePrestamosUseCase,
 * y delega la ejecución de las operaciones a las implementaciones correspondientes de estos casos de uso.
 *
 * @see CreatePrestamoUseCase
 * @see DeletePrestamoUseCase
 * @see RetrivePrestamosUseCase
 */
public class PrestamoService implements CreatePrestamoUseCase, DeletePrestamoUseCase, RetrivePrestamosUseCase, CalculatePrestamoUseCase {

    private static PrestamoService instance = null;

    private final CreatePrestamoUseCase createPrestamoUseCase;
    private final DeletePrestamoUseCase deletePrestamoUseCase;
    private final RetrivePrestamosUseCase retrivePrestamosUseCase;
    private final CalculatePrestamoUseCase calculatePrestamoUseCase;

    /**
     * Constructor del servicio de préstamos.
     *
     * Inicializa las implementaciones de los casos de uso de creación, eliminación y recuperación de préstamos.
     */
    public PrestamoService(){
        this.createPrestamoUseCase = new CreatePrestamoUseCaseImpl();
        this.deletePrestamoUseCase = new DeletePrestamoUseCaseImpl();
        this.retrivePrestamosUseCase = new RetrivePrestamoUseCaseImpl();
        this.calculatePrestamoUseCase = new CalculatePrestamoUseCaseImpl();
    }

    public static PrestamoService getInstance() {
        if (instance == null) {
            instance = new PrestamoService();
        }
        return instance;
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        return this.createPrestamoUseCase.createPrestamo(prestamo);
    }

    @Override
    public Prestamo makeHipoteca(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnAnnos, int usuarioId) {
        return this.createPrestamoUseCase.makeHipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, usuarioId);
    }

    @Override
    public boolean deletePrestamo(Prestamo prestamo) {
        return this.deletePrestamoUseCase.deletePrestamo(prestamo);
    }

    @Override
    public List<Prestamo> getPrestamosFromUsuario(int usuarioId) {
        return this.retrivePrestamosUseCase.getPrestamosFromUsuario(usuarioId);
    }

    @Override
    public Prestamo calculatePrestamo(Prestamo prestamo) {
        return this.calculatePrestamoUseCase.calculatePrestamo(prestamo);
    }
}
