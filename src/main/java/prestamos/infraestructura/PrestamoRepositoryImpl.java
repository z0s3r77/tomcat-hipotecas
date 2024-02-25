package prestamos.infraestructura;

import prestamos.dominio.Prestamo;
import prestamos.dominio.PrestamoRepository;

import java.util.List;

public class PrestamoRepositoryImpl  implements PrestamoRepository {

    private final PrestamoMysqlRepositoryImpl prestamoMysqlRepositoryImpl;

    public PrestamoRepositoryImpl(){

        this.prestamoMysqlRepositoryImpl = new PrestamoMysqlRepositoryImpl();
    }

    public PrestamoRepositoryImpl(PrestamoMysqlRepositoryImpl prestamoMysqlRepository){

        this.prestamoMysqlRepositoryImpl = prestamoMysqlRepository;
    }


    @Override
    public void guardarPrestamo(Prestamo prestamo) {
        this.prestamoMysqlRepositoryImpl.guardarPrestamo(prestamo);
    }

    @Override
    public void eliminarPrestamo(Prestamo prestamo) {
        this.prestamoMysqlRepositoryImpl.eliminarPrestamo(prestamo);
    }

    @Override
    public List<Prestamo> obtenerTodosLosPrestamosDeUnUsuario(String usuarioEmail) {
        return this.prestamoMysqlRepositoryImpl.obtenerTodosLosPrestamosDeUnUsuario(usuarioEmail);
    }
}
