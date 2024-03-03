package usuarios.aplicacion.usecases;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.in.RetriveUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

public class RetriveUsuarioUseCaseImpl implements RetriveUsuarioUseCase {
	
	private final UsuarioRepositoryPort usuarioRepositoryPort;
	private static final Logger LOGGER = Logger.getLogger(RetriveUsuarioUseCaseImpl.class.getName());


	public RetriveUsuarioUseCaseImpl() {
		this.usuarioRepositoryPort = UsuarioRepositoryImpl.getInstance();
	}
	


	@Override
	public Optional<Usuario> getUsuarioById(int id) {

		Optional<Usuario> usuario = usuarioRepositoryPort.findById(id);
		if (usuario.isPresent()) {
			LOGGER.info("Usuario retrieved with id: " + id);
		} else {
			LOGGER.warning("Failed to retrieve usuario with id: " + id);
		}
		return usuario;
	}

	@Override
	public List<Usuario> getAllUsuario() {

		List<Usuario> usuarios = usuarioRepositoryPort.findAll();
		LOGGER.info("Retrieved " + usuarios.size() + " usuarios");
		return usuarios;
	}

	@Override
	public Optional<Usuario> getUsuarioByEmail(String email) {

		Optional<Usuario> usuario = usuarioRepositoryPort.findByEmail(email);
		if (usuario.isPresent()) {
			LOGGER.info("Usuario retrieved with email: " + email);
		} else {
			LOGGER.warning("Failed to retrieve usuario with email: " + email);
		}
		return usuario;
	}

}
