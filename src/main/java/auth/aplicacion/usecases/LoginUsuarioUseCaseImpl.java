package auth.aplicacion.usecases;

import auth.dominio.puertos.in.LoginUsuarioUseCase;
import usuarios.aplicacion.services.UsuarioService;

import java.util.logging.Logger;

public class LoginUsuarioUseCaseImpl implements LoginUsuarioUseCase {

    private final UsuarioService usuarioService;
    private static final Logger LOGGER = Logger.getLogger(LoginUsuarioUseCaseImpl.class.getName());


    public LoginUsuarioUseCaseImpl() {
        this.usuarioService = new UsuarioService();
    }

    @Override
    public boolean authenticateUsuario(String email, String password) {

        boolean isAuthenticated = this.usuarioService.getUsuarioByEmail(email).isPresent()
                && this.usuarioService.getUsuarioByEmail(email).get().getContraseña().equals(password);

        if (isAuthenticated) {
            LOGGER.info("Login successful for user: " + email);
        } else {
            LOGGER.warning("Login failed for user: " + email);
        }

        return isAuthenticated;
    }
}
