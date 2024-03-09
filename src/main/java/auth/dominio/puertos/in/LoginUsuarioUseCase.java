package auth.dominio.puertos.in;

import usuarios.dominio.modelos.Usuario;

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
    Usuario authenticateUsuario(String email, String password);

    /**
     * Método para registrar un usuario.
     * @param email El email del usuario a registrar.
     * @param usuario El nombre de usuario del usuario a registrar.
     * @param password La contraseña del usuario a registrar.
     * @return `true` si el registro fue exitoso, `false` en caso contrario.
     */
    boolean registerUsuario(String email, String usuario, String password);
}
