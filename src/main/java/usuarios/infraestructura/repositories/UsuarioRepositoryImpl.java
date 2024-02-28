package usuarios.infraestructura.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import usuarios.dominio.modelos.UsuarioComportamiento;
import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.entities.UsuarioRegistradoEntity;

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
	public UsuarioComportamiento save(UsuarioComportamiento usuario) {

		Usuario usuarioRegistrado = (Usuario) usuario;
		UsuarioRegistradoEntity usuarioRegistradoEntity = UsuarioRegistradoEntity.fromDomainModel(usuarioRegistrado);
		UsuarioRegistradoEntity usuarioSaved =  usuarioMysqlRepositoryImpl.save(usuarioRegistradoEntity);

		return usuarioSaved.toDomainModel();
	}

	@Override
	public Optional<UsuarioComportamiento> findById(int id) {

		return usuarioMysqlRepositoryImpl.findById(id).map(UsuarioRegistradoEntity::toDomainModel);
	}

	@Override
	public List<UsuarioComportamiento> findAll() {

		return usuarioMysqlRepositoryImpl.findAll().stream()
				.map(UsuarioRegistradoEntity::toDomainModel)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<UsuarioComportamiento> update(UsuarioComportamiento usuario) {

		Usuario usuarioRegistrado = (Usuario) usuario;

		if(usuarioMysqlRepositoryImpl.existsById(usuarioRegistrado.getId())) {
			
			UsuarioRegistradoEntity usuarioRegistradoEntity = UsuarioRegistradoEntity.fromDomainModel(usuarioRegistrado);
			UsuarioRegistradoEntity usuarioUpdated =  usuarioMysqlRepositoryImpl.save(usuarioRegistradoEntity);
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
	public Optional<UsuarioComportamiento> findByEmail(String email) {
		
		return usuarioMysqlRepositoryImpl.findByEmail(email).map(UsuarioRegistradoEntity::toDomainModel);

	}




}
