package usuarios.aplicacion.usecases;

import java.util.Optional;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.in.UpdateUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

public class UpdateUsuarioUseCaseImpl implements UpdateUsuarioUseCase {
	
	private final UsuarioRepositoryPort usuarioRepositoryPort;
		
	
	public UpdateUsuarioUseCaseImpl() {
		this.usuarioRepositoryPort = new UsuarioRepositoryImpl();
	}

	public UpdateUsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort = usuarioRepositoryPort;
	}


	@Override
	public Optional<Usuario> updatesUsuario(Long id, Usuario usuarioActualizado) {
		
		return usuarioRepositoryPort.update(usuarioActualizado);
	}

}
