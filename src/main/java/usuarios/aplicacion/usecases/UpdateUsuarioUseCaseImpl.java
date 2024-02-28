package usuarios.aplicacion.usecases;

import java.util.Optional;

import usuarios.dominio.modelos.UsuarioComportamiento;
import usuarios.dominio.puertos.in.UpdateUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

public class UpdateUsuarioUseCaseImpl implements UpdateUsuarioUseCase {
	
	private final UsuarioRepositoryPort usuarioRepositoryPort;
		
	
	public UpdateUsuarioUseCaseImpl() {
		this.usuarioRepositoryPort = UsuarioRepositoryImpl.getInstance();
	}

	public UpdateUsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort = usuarioRepositoryPort;
	}


	@Override
	public Optional<UsuarioComportamiento> updatesUsuario(Long id, UsuarioComportamiento usuarioActualizado) {
		
		return usuarioRepositoryPort.update(usuarioActualizado);
	}

}
