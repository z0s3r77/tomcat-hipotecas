package auth.aplicacion.usecases;

import auth.dominio.puertos.in.LoginUsuarioUseCase;
import usuarios.aplicacion.services.UsuarioService;

public class LoginUsuarioUseCaseImpl implements LoginUsuarioUseCase {

    private final UsuarioService usuarioService;

    public LoginUsuarioUseCaseImpl() {
        this.usuarioService = new UsuarioService();
    }

    @Override
    public boolean authenticateUsuario(String email, String password) {

        return usuarioService.getUsuarioByEmailAndPassword(email, password).isPresent();
    }

}
