package prestamos.infraestructura.repositories;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.entities.PrestamoEntity;
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

        String prestamoClass = prestamo.getClass().toString();
        prestamo.setTipoPrestamo(prestamoClass);

        PrestamoEntity prestamoEntity = PrestamoEntity.fromDomainModel(prestamo);
        PrestamoEntity prestamoSaved = this.prestamoMysqlRepositoryImpl.guardarPrestamo(prestamoEntity);

        return prestamoSaved.toDomainModel(prestamo);
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
