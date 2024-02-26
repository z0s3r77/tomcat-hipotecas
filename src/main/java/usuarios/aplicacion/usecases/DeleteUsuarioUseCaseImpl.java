package usuarios.aplicacion.usecases;

import usuarios.dominio.puertos.in.DeleteUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

public class DeleteUsuarioUseCaseImpl implements DeleteUsuarioUseCase {
	
	
	private final UsuarioRepositoryPort usuarioRepositoryPort;


	public DeleteUsuarioUseCaseImpl() {
		this.usuarioRepositoryPort = UsuarioRepositoryImpl.getInstance();
	}
	
	public DeleteUsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort = usuarioRepositoryPort;
	}

	@Override
	public boolean deleteUsuario(int id) {

		return usuarioRepositoryPort.deleteById(id);
	}

}
