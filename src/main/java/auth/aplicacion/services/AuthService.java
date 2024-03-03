package auth.aplicacion.services;

import auth.aplicacion.usecases.LoginUsuarioUseCaseImpl;
import auth.dominio.puertos.in.LoginUsuarioUseCase;

public class AuthService implements LoginUsuarioUseCase {

    private final LoginUsuarioUseCase loginUsuarioUseCase;

    public AuthService() {
        this.loginUsuarioUseCase = new LoginUsuarioUseCaseImpl();
    }

    @Override
    public boolean authenticateUsuario(String email, String password) {
        return this.loginUsuarioUseCase.authenticateUsuario(email, password);
    }

}
