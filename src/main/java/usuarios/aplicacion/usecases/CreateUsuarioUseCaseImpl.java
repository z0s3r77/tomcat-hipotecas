package usuarios.aplicacion.usecases;

import usuarios.dominio.modelos.UsuarioComportamiento;
import usuarios.dominio.puertos.in.CreateUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

public class CreateUsuarioUseCaseImpl implements CreateUsuarioUseCase {

	
	private final UsuarioRepositoryPort  usuarioRepositoryPort;
	
	public CreateUsuarioUseCaseImpl() {
		this.usuarioRepositoryPort = UsuarioRepositoryImpl.getInstance();
	}
	
	public CreateUsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
		this.usuarioRepositoryPort = usuarioRepositoryPort;
	}
	
	
	@Override
	public UsuarioComportamiento createUsuario(UsuarioComportamiento usuario) {
		System.out.println(usuario.toString());
		return usuarioRepositoryPort.save(usuario);
	}
	

}
