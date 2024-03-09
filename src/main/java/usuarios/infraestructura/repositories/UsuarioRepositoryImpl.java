package usuarios.infraestructura.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.entities.UsuarioEntity;

/**
 * Implementación del repositorio de usuarios.
 * Esta clase proporciona la implementación de las operaciones de repositorio para la entidad Usuario.
 */
public class UsuarioRepositoryImpl implements UsuarioRepositoryPort {

	private static UsuarioRepositoryImpl instanciaSingleton;
	private final UsuarioRegistradoEntityMysqlRepositoryImpl usuarioMysqlRepositoryImpl;


	/**
	 * Constructor del repositorio de usuarios.
	 * @param usuarioMysqlRepositoryImpl Implementación del repositorio de usuarios registrados para MySQL.
	 */
	public UsuarioRepositoryImpl(UsuarioRegistradoEntityMysqlRepositoryImpl usuarioMysqlRepositoryImpl) {

		this.usuarioMysqlRepositoryImpl = usuarioMysqlRepositoryImpl;
	}


	/**
	 * Método para obtener la instancia singleton del repositorio de usuarios.
	 * @return Instancia singleton del repositorio de usuarios.
	 */
	public static UsuarioRepositoryImpl getInstance() {

		if (instanciaSingleton == null) {
			synchronized (UsuarioRepositoryImpl.class) {
				if (instanciaSingleton == null) {
					instanciaSingleton = new UsuarioRepositoryImpl(new UsuarioRegistradoEntityMysqlRepositoryImpl());
				}
			}
		}
		return instanciaSingleton;
	}


	@Override
	public Usuario save(Usuario usuario) {

        UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuario);
		UsuarioEntity usuarioSaved =  usuarioMysqlRepositoryImpl.save(usuarioEntity);

		return usuarioSaved.toDomainModel();
	}

	@Override
	public Optional<Usuario> findById(int id) {

		return usuarioMysqlRepositoryImpl.findById(id).map(UsuarioEntity::toDomainModel);
	}

	@Override
	public List<Usuario> findAll() {

		return usuarioMysqlRepositoryImpl.findAll().stream()
				.map(UsuarioEntity::toDomainModel)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Usuario> update(Usuario usuario) {

        if(usuarioMysqlRepositoryImpl.existsById(((Usuario) usuario).getId())) {
			
			UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuario);
			UsuarioEntity usuarioUpdated =  usuarioMysqlRepositoryImpl.save(usuarioEntity);
			return Optional.of(usuarioUpdated.toDomainModel());
			
		}
		
		return Optional.empty();
	}

	@Override
	public boolean deleteById(int id) {

		if (usuarioMysqlRepositoryImpl.existsById(id)) {
			usuarioMysqlRepositoryImpl.deleteById(id);
			return true;
		}
		
		return false;
	}


	@Override
	public Optional<Usuario> findByEmail(String email) {
		
		return usuarioMysqlRepositoryImpl.findByEmail(email).map(UsuarioEntity::toDomainModel);
	}


}
