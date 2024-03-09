package usuarios.aplicacion.usecases;

import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.puertos.in.CreateUsuarioUseCase;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateUsuarioUseCaseImpl implements CreateUsuarioUseCase {
	
	private final UsuarioRepositoryPort  usuarioRepositoryPort;
	private static final Logger LOGGER = Logger.getLogger(CreateUsuarioUseCaseImpl.class.getName());


	public CreateUsuarioUseCaseImpl() {

		this.usuarioRepositoryPort = UsuarioRepositoryImpl.getInstance();
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		Usuario savedUsuario = usuarioRepositoryPort.save(usuario);
		if (savedUsuario == null) {
			LOGGER.log(Level.SEVERE,"Error creating Usuario " + usuario);
		}else {
			LOGGER.log(Level.INFO, "Usuario created with id: " + savedUsuario.getId());
		}
		return savedUsuario;
	}

	@Override
	public Usuario createUsuario(String correo, String usuario, String password) {
		
		Usuario newUsuario = new Usuario(correo, usuario, password, null);
		Usuario savedUsuario = usuarioRepositoryPort.save(newUsuario);
		if (savedUsuario == null) {
			LOGGER.log(Level.SEVERE, "Error creating Usuario " + usuario);
		}else {
			LOGGER.log(Level.INFO, "Usuario created with id: " + savedUsuario.getId());
		}
		
		return savedUsuario;
	}
	

}
