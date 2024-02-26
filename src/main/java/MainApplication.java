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

        //ApplicationContext context = new ApplicationContextImpl();

        //Este tiene a el y mysql,  le falta a Mysql prestamoRepository
        //UsuarioRepositoryPort usuarioRepository = UsuarioRepositoryImpl.getInstance();
        //context.addBean(UsuarioRepositoryPort.class, usuarioRepository);

        // Este tiene impl y Mysql, le falta
        //PrestamoRepositoryPort prestamoRepositoryPort = PrestamoRepositoryPortImpl.getInstance();
       // context.addBean(PrestamoRepositoryPort.class, prestamoRepositoryPort);

        //Inicializamos el Mysql Repository
        // UsuarioRegistradoEntityMysqlRepositoryImpl usuarioEntityRepository = new UsuarioRegistradoEntityMysqlRepositoryImpl((PrestamoRepositoryPortImpl) prestamoRepositoryPort);


        PrestamoService prestamoService = new PrestamoService();
        UsuarioService usuarioService = new UsuarioService();
        
        System.out.println("---------- Usuario Juan cargado en la base de datos ------------- ");
        
        UsuarioRegistrado juanPerez = (UsuarioRegistrado) usuarioService.getUsuarioByEmail("usuario1@example.com").orElseThrow();
        System.out.println(juanPerez);
        
        System.out.println("");
        System.out.println("");   
        System.out.println("---------- Creamos un usario nuevo: Máximo ------------------ ");   
        UsuarioRegistrado maximoHernandez = new UsuarioRegistrado("maximo@gmail.com", "maximo hernandez", "secretoDeEstado", null);
        usuarioService.createUsuario(maximoHernandez);
        
        System.out.println("");
        System.out.println("");   
        System.out.println("---------- Listamos a los dos usuarios en H2 ------------------ ");   
        
        List<Usuario> usuariosEnBd = usuarioService.getAllUsuario();
        usuariosEnBd.stream().map(Usuario::toString).forEach(System.out::println);

        System.out.println("");
        System.out.println("");  
        System.out.println("---------- Obtenemos los prestamos de Juan -----------------");
        System.out.println("");
        System.out.println("");

       
        List<Prestamo> prestamosDeJuan = prestamoService.getPrestamosFromUsuario(juanPerez.getEmail());
        juanPerez.setPrestamos(prestamosDeJuan);
        juanPerez.getPrestamos().stream().map(Prestamo::toString).forEach(System.out::println);

        System.out.println("---------- Calculamos la cuota según el primer pretamos ---------------");
        System.out.println("");
        System.out.println("");


        Prestamo prestamoDeJuan = juanPerez.getPrestamos().get(0);
        System.out.println(prestamoDeJuan);
        prestamoDeJuan.calcularCuotaMensual();
        System.out.println("Cuota: " + prestamoDeJuan.getCuotaMensual());

        System.out.println("---------- Calculamos cuadro de amortizacion --------------------");

        prestamoDeJuan.calcularCuadroAmortizacion();

        System.out.println("---------- Primer registro del cuadro de amortizacion --------------------");
        System.out.println("");
        System.out.println("");
        System.out.println(prestamoDeJuan.getCuadroDeAmortizacion().get(0).toString());
        System.out.println("");
        System.out.println("");
        System.out.println("---------- Último registro del cuadro de amortizacion --------------------");
        System.out.println("");
        System.out.println("");
        System.out.println(prestamoDeJuan.getCuadroDeAmortizacion().get(prestamoDeJuan.getPlazoDeAmortizacionEnMeses()- 1).toString());
        System.out.println("");
        System.out.println(""); 
        System.out.println("");
        System.out.println(""); 
        System.out.println("");
        System.out.println(""); 
        System.out.println("");
        System.out.println("");
        System.out.println("---------- Máximo va al banco y pide una Hipoteca --------------------");
       // double capital, double interes, int frecuenciaDePagoEnMeses, int plazoDeAmortizacionEnAnnos, Usuario usuario
        Hipoteca hipotecaDeMáximo = new Hipoteca(200000,4.5,1,120, maximoHernandez);
        prestamoService.createPrestamo(hipotecaDeMáximo);
        List<Prestamo> prestamosDeMaximo = prestamoService.getPrestamosFromUsuario( maximoHernandez.getEmail());
        maximoHernandez.setPrestamos(prestamosDeMaximo);
        maximoHernandez.getPrestamos().stream().map(Prestamo::toString).forEach(System.out::println);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("---------- Cargamos a Máximo con su  hipoteca --------------------");

        usuariosEnBd = usuarioService.getAllUsuario();
        usuariosEnBd.stream().map(Usuario::toString).forEach(System.out::println);


    }

}
