package prestamos.infraestructura;

import prestamos.dominio.Prestamo;
import prestamos.dominio.PrestamoRepository;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

import java.util.List;

public class PrestamoRepositoryImpl  implements PrestamoRepository {

    private static PrestamoRepositoryImpl instanciaSingleton;
    private final PrestamoMysqlRepositoryImpl prestamoMysqlRepositoryImpl;

    public static PrestamoRepositoryImpl getInstance(){
        if (instanciaSingleton == null){
            synchronized (UsuarioRepositoryImpl.class){
                if (instanciaSingleton == null){
                    instanciaSingleton = new PrestamoRepositoryImpl();
                }
            }
        }
        return instanciaSingleton;
    }

    public PrestamoRepositoryImpl(){

        this.prestamoMysqlRepositoryImpl = new PrestamoMysqlRepositoryImpl();
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
