import java.util.List;


import auth.aplicacion.services.AuthService;
import prestamos.aplicacion.service.PrestamoService;
import prestamos.dominio.modelos.Prestamo;
import usuarios.aplicacion.services.UsuarioService;
import usuarios.dominio.modelos.Usuario;



public class MainApplication {
	

	// Esta apliación solo y exclusivamente debería acceder a la capa de aplicación y si un caso dominio
    public static void main(String[] args) {


        // Cargamos los servicios de la aplicación.
        PrestamoService prestamoService = new PrestamoService();
        UsuarioService usuarioService = new UsuarioService();
        AuthService authService = new AuthService();

        // Autenticamos un usuario
        authService.authenticateUsuario("usuario1@example.com", "contraseña123");

        // Cargamos un usuario
        List<Usuario> usuarios = usuarioService.getAllUsuario();
        usuarios.forEach(usuario -> System.out.println(usuario.toString()));
        Usuario juanPerez =  usuarios.get(0);
        System.out.println("");
        System.out.println("");
        System.out.println("------------------- obtenemos los prestamos de  juan -----------------------");

        //Obtenemos los prestamos del usuario
        List<Prestamo> prestamosDeJuan = prestamoService.getPrestamosFromUsuario(juanPerez.getId());
        prestamosDeJuan.forEach(prestamo -> System.out.println(prestamosDeJuan));

        System.out.println("");
        System.out.println("");
        System.out.println("------------------- Seteamos los prestamos de  juan -----------------------");
        juanPerez.setPrestamos(prestamosDeJuan);
        juanPerez.getPrestamos().forEach(System.out::println);
        System.out.println(juanPerez);




    }

}
