package auth.aplicacion.services;

import auth.aplicacion.usecases.LoginUsuarioUseCaseImpl;
import auth.dominio.puertos.in.LoginUsuarioUseCase;
import usuarios.dominio.modelos.Usuario;

public class AuthService implements LoginUsuarioUseCase {

    private static AuthService instance = null;
    private final LoginUsuarioUseCase loginUsuarioUseCase;

    public AuthService() {
        this.loginUsuarioUseCase = new LoginUsuarioUseCaseImpl();
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    @Override
    public Usuario authenticateUsuario(String email, String password) {
        return this.loginUsuarioUseCase.authenticateUsuario(email, password);
    }

	@Override
	public boolean registerUsuario(String email, String usuario, String password) {
		return this.loginUsuarioUseCase.registerUsuario(email, usuario, password);
	}

}
