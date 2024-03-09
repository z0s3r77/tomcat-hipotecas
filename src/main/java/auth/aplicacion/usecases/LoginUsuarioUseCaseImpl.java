package auth.aplicacion.usecases;

import auth.dominio.puertos.in.LoginUsuarioUseCase;
import usuarios.aplicacion.services.UsuarioService;
import usuarios.dominio.modelos.Usuario;

import java.util.Optional;
import java.util.logging.Logger;

public class LoginUsuarioUseCaseImpl implements LoginUsuarioUseCase {

    private final UsuarioService usuarioService;
    private static final Logger LOGGER = Logger.getLogger(LoginUsuarioUseCaseImpl.class.getName());


    public LoginUsuarioUseCaseImpl() {
        this.usuarioService = new UsuarioService();
    }

    @Override
    public Usuario authenticateUsuario(String email, String password) {

        Optional<Usuario> usuario = this.usuarioService.getUsuarioByEmail(email);
        		
        if (usuario.isPresent()) {
        	if (usuario.get().getContraseña().equals(password)) {
                LOGGER.info("Login successful for user: " + email);
                return usuario.get();
        	}
        }
        
        LOGGER.warning("Login failed for user: " + email);

       
        return null;
    }

	@Override
	public boolean registerUsuario(String email, String usuario, String password) {
		
		var newUsuario = this.usuarioService.createUsuario(email,usuario, password);
	
		if(newUsuario == null) {
			return false;
		}
		
		return true;
	}
}
