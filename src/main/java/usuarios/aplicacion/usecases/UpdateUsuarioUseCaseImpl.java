package usuarios.aplicacion.usecases;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.in.UpdateUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

public class UpdateUsuarioUseCaseImpl implements UpdateUsuarioUseCase {
	
	private final UsuarioRepositoryPort usuarioRepositoryPort;
	private static final Logger LOGGER = Logger.getLogger(UpdateUsuarioUseCaseImpl.class.getName());

	public UpdateUsuarioUseCaseImpl() {
		this.usuarioRepositoryPort = UsuarioRepositoryImpl.getInstance();
	}


	@Override
	public Optional<Usuario> updatesUsuario(Long id, Usuario usuarioActualizado) {

		Optional<Usuario> updatedUsuario = usuarioRepositoryPort.update(usuarioActualizado);
		if (updatedUsuario.isPresent()) {
			LOGGER.log(Level.INFO, "Usuario updated with id: " + id);
		} else {
			LOGGER.log(Level.INFO,"Failed to update usuario with id: " + id);
		}
		return updatedUsuario;
	}
}
