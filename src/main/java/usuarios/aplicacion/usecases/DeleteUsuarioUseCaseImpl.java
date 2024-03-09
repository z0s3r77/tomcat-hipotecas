package usuarios.aplicacion.usecases;

import usuarios.dominio.puertos.in.DeleteUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteUsuarioUseCaseImpl implements DeleteUsuarioUseCase {

	private final UsuarioRepositoryPort usuarioRepositoryPort;
	private static final Logger LOGGER = Logger.getLogger(DeleteUsuarioUseCaseImpl.class.getName());

	public DeleteUsuarioUseCaseImpl() {
		this.usuarioRepositoryPort = UsuarioRepositoryImpl.getInstance();
	}


	@Override
	public boolean deleteUsuario(int id) {

		boolean isDeleted = usuarioRepositoryPort.deleteById(id);
		if (isDeleted) {
			LOGGER.log(Level.INFO,"Usuario deleted with id: " + id);
		} else {
			LOGGER.log(Level.SEVERE,"Failed to delete usuario with id: " + id);
		}
		return isDeleted;
	}

}
