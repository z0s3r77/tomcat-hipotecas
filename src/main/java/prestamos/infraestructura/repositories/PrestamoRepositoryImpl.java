package prestamos.infraestructura.repositories;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.PrestamoRepository;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

import java.util.List;

public class PrestamoRepositoryImpl  implements PrestamoRepository {

private  static PrestamoRepositoryImpl instaciaSingleton;
    private final PrestamoMysqlRepositoryImpl prestamoMysqlRepositoryImpl;



    public PrestamoRepositoryImpl(PrestamoMysqlRepositoryImpl prestamoMysqlRepositoryImpl) {

        this.prestamoMysqlRepositoryImpl = prestamoMysqlRepositoryImpl;


    }

    public static PrestamoRepositoryImpl getInstance(){
        if (instaciaSingleton == null){
            synchronized (PrestamoRepositoryImpl.class){
                if (instaciaSingleton == null ){
                    instaciaSingleton = new PrestamoRepositoryImpl(new PrestamoMysqlRepositoryImpl(UsuarioRepositoryImpl.getInstance()));
                }
            }
        }
        return instaciaSingleton;
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
