import java.util.List;

import infraestructuracomun.ApplicationContext;
import infraestructuracomun.ApplicationContextImpl;
import prestamos.aplicacion.service.PrestamoService;
import prestamos.dominio.modelos.Hipoteca;
import prestamos.dominio.modelos.Prestamo;
import prestamos.dominio.puerto.out.PrestamoRepositoryPort;
import prestamos.infraestructura.repositories.PrestamoRepositoryPortImpl;
import usuarios.aplicacion.services.UsuarioService;
import usuarios.dominio.modelos.Usuario;
import usuarios.dominio.modelos.UsuarioRegistrado;
import usuarios.dominio.puertos.out.UsuarioRepositoryPort;
import usuarios.infraestructura.repositories.UsuarioRegistradoEntityMysqlRepositoryImpl;
import usuarios.infraestructura.repositories.UsuarioRepositoryImpl;


public class MainApplication {
	

	// Esta apliación solo y exclusivamente debería acceder a la capa de aplicación y si un caso dominio
    public static void main(String[] args) {


        PrestamoService prestamoService = new PrestamoService();
        UsuarioService usuarioService = new UsuarioService();
        


    }

}
