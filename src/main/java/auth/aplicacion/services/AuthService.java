package auth.aplicacion.services;

import auth.aplicacion.usecases.LoginUsuarioUseCaseImpl;
import auth.dominio.puertos.in.LoginUsuarioUseCase;

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
    public boolean authenticateUsuario(String email, String password) {
        return this.loginUsuarioUseCase.authenticateUsuario(email, password);
    }

}
