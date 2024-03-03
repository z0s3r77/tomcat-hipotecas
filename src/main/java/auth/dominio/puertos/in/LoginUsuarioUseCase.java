package auth.dominio.puertos.in;

/**
 * Interfaz para el caso de uso de autenticación de un usuario.
 * Esta interfaz define el contrato para la autenticación de un usuario en el sistema.
 */
public interface LoginUsuarioUseCase {

    /**
     * Método para autenticar un usuario.
     * @param email El email del usuario a autenticar.
     * @param password La contraseña del usuario a autenticar.
     * @return `true` si la autenticación fue exitosa, `false` en caso contrario.
     */
    boolean authenticateUsuario(String email, String password);

}
