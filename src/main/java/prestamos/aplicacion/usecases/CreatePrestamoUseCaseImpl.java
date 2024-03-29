package prestamos.aplicacion.usecases;

import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.CreatePrestamoUseCase;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.repositories.PrestamoRepositoryPortImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreatePrestamoUseCaseImpl implements CreatePrestamoUseCase {

    private final PrestamoRepositoryPort prestamoRepositoryPort;
    private static final Logger LOGGER = Logger.getLogger(CreatePrestamoUseCaseImpl.class.getName());

    public CreatePrestamoUseCaseImpl(){
        this.prestamoRepositoryPort = PrestamoRepositoryPortImpl.getInstance();
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {

        Prestamo savedPrestamo = prestamoRepositoryPort.save(prestamo);
        LOGGER.log(Level.INFO, "Prestamo created with id: " + savedPrestamo.getId());

        return savedPrestamo;
    }

    @Override
    public Prestamo makeHipoteca(double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnAnnos, int usuarioId) {
        return new Hipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, usuarioId);
    }
}
