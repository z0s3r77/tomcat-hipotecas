package usuarios.aplicacion.usecases;

import java.util.List;
import java.util.Optional;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.in.RetriveUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

public class RetriveUsuarioUseCaseImpl implements RetriveUsuarioUseCase {
	
	private final UsuarioRepositoryPort usuarioRepositoryPort;

	public RetriveUsuarioUseCaseImpl() {
		this.usuarioRepositoryPort = UsuarioRepositoryImpl.getInstance();
	}
	
	public RetriveUsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort = usuarioRepositoryPort;
	}

	@Override
	public Optional<Usuario> getUsuarioById(int id) {
		
		return usuarioRepositoryPort.findById(id);
	}

	@Override
	public List<Usuario> getAllUsuario() {
		return usuarioRepositoryPort.findAll();
	}

	@Override
	public Optional<Usuario> getUsuarioByEmail(String email) {
		return usuarioRepositoryPort.findByEmail(email);
	}

}
