package prestamos.infraestructura.repositories;

import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.entities.PrestamoEntity;

import java.util.List;

/**
 * Implementación concreta del puerto de repositorio de préstamos ({@link PrestamoRepositoryPort}) que utiliza
 * persistencia en una base de datos MySQL mediante {@link PrestamoMysqlRepositoryImpl}.
 *
 *
 * Esta implementación proporciona métodos para guardar, eliminar y obtener préstamos desde una base de datos MySQL.
 * Utiliza el patrón Singleton para garantizar una única instancia de la clase.
 *
 *
 *
 * Se espera que esta clase sea utilizada en la capa de aplicación para interactuar con el repositorio de préstamos.
 *
 *
 * @see PrestamoRepositoryPort
 * @see PrestamoMysqlRepositoryImpl
 *
 */
public class PrestamoRepositoryPortImpl implements PrestamoRepositoryPort {

    private  static PrestamoRepositoryPortImpl instaciaSingleton;
    private final PrestamoMysqlRepositoryImpl prestamoMysqlRepositoryImpl;

    /**
     * Constructor privado para aplicar el patrón Singleton.
     *
     * @param prestamoMysqlRepositoryImpl La implementación concreta de {@link PrestamoMysqlRepositoryImpl} a utilizar.
     */
    public PrestamoRepositoryPortImpl(PrestamoMysqlRepositoryImpl prestamoMysqlRepositoryImpl) {

        this.prestamoMysqlRepositoryImpl = prestamoMysqlRepositoryImpl;
    }

    /**
     * Método para obtener la única instancia de la clase utilizando el patrón Singleton.
     *
     * @return La instancia única de {@link PrestamoRepositoryPortImpl}.
     */
    public static PrestamoRepositoryPortImpl getInstance(){
        if (instaciaSingleton == null){
            synchronized (PrestamoRepositoryPortImpl.class){
                if (instaciaSingleton == null ){
                    instaciaSingleton = new PrestamoRepositoryPortImpl(new PrestamoMysqlRepositoryImpl());
                }
            }
        }
        return instaciaSingleton;
    }


    /**
     * Guarda un préstamo en la base de datos MySQL.
     *
     * @param prestamo El préstamo ({@link Prestamo}) que se desea guardar.
     * @return El préstamo guardado después de la persistencia.
     */
    @Override
    public Prestamo save(Prestamo prestamo) {

        String prestamoClass = prestamo.getClass().toString();
        prestamo.setTipoPrestamo(prestamoClass);

        PrestamoEntity prestamoEntity = PrestamoEntity.fromDomainModel(prestamo);
        PrestamoEntity prestamoSaved = this.prestamoMysqlRepositoryImpl.guardarPrestamo(prestamoEntity);

        return prestamoSaved.toDomainModel(prestamo);
    }

    /**
     * Elimina un préstamo de la base de datos MySQL.
     *
     * @param prestamo El préstamo ({@link Prestamo}) que se desea eliminar.
     * @return `true` si la eliminación fue exitosa, `false` si no se pudo eliminar.
     */
    @Override
    public boolean deletePrestamo(int prestamoId) {
        return this.prestamoMysqlRepositoryImpl.eliminarPrestamo(prestamoId);

    }

    /**
     * Obtiene todos los préstamos asociados a un usuario desde la base de datos MySQL.
     *
     * @param usuarioId El correo electrónico del usuario para el cual se desean obtener los préstamos.
     * @return Lista de préstamos asociados al usuario.
     */
    @Override
    public List<Prestamo> getAllPrestamosfromUsuario(int usuarioId) {
        return this.prestamoMysqlRepositoryImpl.obtenerTodosLosPrestamosDeUnUsuario(usuarioId);
    }
}
