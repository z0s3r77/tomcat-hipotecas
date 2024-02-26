package usuarios.infraestructura.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.modelos.UsuarioRegistrado;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.entities.UsuarioRegistradoEntity;

public class UsuarioRepositoryImpl implements UsuarioRepositoryPort {

	private static UsuarioRepositoryImpl instanciaSingleton;
	private final UsuarioRegistradoEntityMysqlRepositoryImpl usuarioMysqlRepositoryImpl;

	private UsuarioRepositoryImpl() {

		this.usuarioMysqlRepositoryImpl = new UsuarioRegistradoEntityMysqlRepositoryImpl();

	}


	public static UsuarioRepositoryImpl getInstance() {

		if (instanciaSingleton == null) {
			synchronized (UsuarioRepositoryImpl.class) {
				if (instanciaSingleton == null) {
					instanciaSingleton = new UsuarioRepositoryImpl();
				}
			}
		}
		return instanciaSingleton;
	}


	@Override
	public Usuario save(Usuario usuario) {

		UsuarioRegistrado usuarioRegistrado = (UsuarioRegistrado) usuario;
		UsuarioRegistradoEntity usuarioRegistradoEntity = UsuarioRegistradoEntity.fromDomainModel(usuarioRegistrado);
		System.out.println(usuario.toString());
		UsuarioRegistradoEntity usuarioSaved =  usuarioMysqlRepositoryImpl.save(usuarioRegistradoEntity);
		System.out.println(usuarioSaved.toString());

		return usuarioSaved.toDomainModel();
	}

	@Override
	public Optional<Usuario> findById(int id) {

		return usuarioMysqlRepositoryImpl.findById(id).map(UsuarioRegistradoEntity::toDomainModel);
	}

	@Override
	public List<Usuario> findAll() {

		return usuarioMysqlRepositoryImpl.findAll().stream()
				.map(UsuarioRegistradoEntity::toDomainModel)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Usuario> update(Usuario usuario) {

		UsuarioRegistrado usuarioRegistrado = (UsuarioRegistrado) usuario;

		if(usuarioMysqlRepositoryImpl.existsById(usuarioRegistrado.getId())) {
			
			UsuarioRegistradoEntity usuarioRegistradoEntity = UsuarioRegistradoEntity.fromDomainModel(usuarioRegistrado);
			UsuarioRegistradoEntity usuarioUpdated =  usuarioMysqlRepositoryImpl.save(usuarioRegistradoEntity);
			return Optional.of(usuarioUpdated.toDomainModel());
			
		}
		
		return Optional.empty();
	}

	@Override
	public boolean deleteById(int id) {

		if (usuarioMysqlRepositoryImpl.existsById((int) id)) {
			usuarioMysqlRepositoryImpl.deleteById(id);
			return true;
		}
		
		return false;
	}


	@Override
	public Optional<Usuario> findByEmail(String email) {
		
		return usuarioMysqlRepositoryImpl.findByEmail(email).map(UsuarioRegistradoEntity::toDomainModel);

	}




}
