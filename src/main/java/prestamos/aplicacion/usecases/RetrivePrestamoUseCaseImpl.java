package prestamos.aplicacion.usecases;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.in.RetrivePrestamosUseCase;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.repositories.PrestamoRepositoryPortImpl;

import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class RetrivePrestamoUseCaseImpl implements RetrivePrestamosUseCase {

    private  final PrestamoRepositoryPort prestamoRepositoryPort;
    private static final Logger LOGGER = Logger.getLogger(RetrivePrestamoUseCaseImpl.class.getName());

    public RetrivePrestamoUseCaseImpl(){
        this.prestamoRepositoryPort = PrestamoRepositoryPortImpl.getInstance();

        try {
            // Crear un FileHandler para escribir los registros en un archivo
            FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            // Agregar el FileHandler al Logger
            LOGGER.addHandler(fileHandler);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al configurar el FileHandler.", e);
        }
    }

    @Override
    public List<Prestamo> getPrestamosFromUsuario(int usuarioId) {

        List<Prestamo> prestamos = prestamoRepositoryPort.getAllPrestamosfromUsuario(usuarioId);
        LOGGER.log(Level.INFO, "Retrieved " + prestamos.size() + " prestamos for user with id: " + usuarioId);
        return prestamos;
    }
}
