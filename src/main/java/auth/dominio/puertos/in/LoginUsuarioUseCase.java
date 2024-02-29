package auth.dominio.puertos.in;

import usuarios.dominio.modelos.Usuario;

public interface LoginUsuarioUseCase {

    boolean authenticateUsuario(String email, String password);

}
