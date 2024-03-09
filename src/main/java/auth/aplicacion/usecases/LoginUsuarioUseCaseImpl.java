package auth.aplicacion.usecases;

import auth.dominio.puertos.in.LoginUsuarioUseCase;
import usuarios.aplicacion.services.UsuarioService;
import usuarios.dominio.modelos.Usuario;

import java.util.Optional;
import java.util.logging.Level;
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
        	if (usuario.get().getPassword().equals(password)) {
                LOGGER.log(Level.INFO, "Login successful for user: " + email);
                return usuario.get();
        	}
        }
        
        LOGGER.log(Level.SEVERE, "Login failed for user: " + email);
        return null;
    }

	@Override
	public boolean registerUsuario(String email, String usuario, String password) {
		
		var newUsuario = this.usuarioService.createUsuario(email,usuario, password);
	
		if(newUsuario == null) {
			LOGGER.log(Level.SEVERE, "Error creating user - Email: " + email + ", Usuario: " + usuario + ", Password: " + password);
			return false;
		}
		
		LOGGER.log(Level.INFO, "User created - Email: " + email + ", Usuario: " + usuario + ", Password: " + password);
		return true;
	}
}
