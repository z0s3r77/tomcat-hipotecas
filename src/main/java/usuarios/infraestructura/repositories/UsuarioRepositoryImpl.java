package usuarios.infraestructura.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.entities.UsuarioEntity;

public class UsuarioRepositoryImpl implements UsuarioRepositoryPort {

	private static UsuarioRepositoryImpl instanciaSingleton;
	private final UsuarioRegistradoEntityMysqlRepositoryImpl usuarioMysqlRepositoryImpl;


	public UsuarioRepositoryImpl(UsuarioRegistradoEntityMysqlRepositoryImpl usuarioMysqlRepositoryImpl) {

		this.usuarioMysqlRepositoryImpl = usuarioMysqlRepositoryImpl;
	}


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

		Usuario usuarioRegistrado = (Usuario) usuario;
		UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuarioRegistrado);
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

		Usuario usuarioRegistrado = (Usuario) usuario;

		if(usuarioMysqlRepositoryImpl.existsById(usuarioRegistrado.getId())) {
			
			UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuarioRegistrado);
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


	@Override
	public Optional<Usuario> findByEmailAndPassword(String email, String password) {

		Usuario usuario = usuarioMysqlRepositoryImpl.findByEmailAndPassword(email, password).map(UsuarioEntity::toDomainModel).orElse(null);
		return Optional.ofNullable(usuario);
	}
}
