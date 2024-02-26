package prestamos.infraestructura.repositories;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.PrestamoRepositoryPort;
import prestamos.infraestructura.entities.PrestamoEntity;
import usuarios.dominio.modelos.Usuario;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

import java.util.List;

public class PrestamoRepositoryPortImpl implements PrestamoRepositoryPort {

private  static PrestamoRepositoryPortImpl instaciaSingleton;
    private final PrestamoMysqlRepositoryImpl prestamoMysqlRepositoryImpl;

    public PrestamoRepositoryPortImpl(PrestamoMysqlRepositoryImpl prestamoMysqlRepositoryImpl) {

        this.prestamoMysqlRepositoryImpl = prestamoMysqlRepositoryImpl;
    }

    public static PrestamoRepositoryPortImpl getInstance(){
        if (instaciaSingleton == null){
            synchronized (PrestamoRepositoryPortImpl.class){
                if (instaciaSingleton == null ){
                    instaciaSingleton = new PrestamoRepositoryPortImpl(new PrestamoMysqlRepositoryImpl(UsuarioRepositoryImpl.getInstance()));
                }
            }
        }
        return instaciaSingleton;
    }



    @Override
    public Prestamo save(Prestamo prestamo) {
        PrestamoEntity prestamoEntity = PrestamoEntity.fromDomainModel(prestamo);
        this.prestamoMysqlRepositoryImpl.guardarPrestamo(prestamoEntity);

        return prestamoEntity.toDomainModel(prestamo);
    }

    @Override
    public boolean deletePrestamo(Prestamo prestamo) {
        PrestamoEntity prestamoEntity = PrestamoEntity.fromDomainModel(prestamo);
        return this.prestamoMysqlRepositoryImpl.eliminarPrestamo(prestamoEntity);

    }

    @Override
    public List<Prestamo> getAllPrestamosfromUsuario(String usuarioEmail) {
        return this.prestamoMysqlRepositoryImpl.obtenerTodosLosPrestamosDeUnUsuario(usuarioEmail);
    }
}
