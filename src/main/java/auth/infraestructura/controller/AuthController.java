package auth.infraestructura.controller;

import auth.aplicacion.services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import usuarios.dominio.modelos.Usuario;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "Controlador para autenticar login", urlPatterns = { "/AuthController" })
public class AuthController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    AuthService authService;

    public AuthController() {
        this.authService = AuthService.getInstance();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath() +"</h1>" );
            out.println("</body>");
            out.println("</html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion =  request.getSession();
        int conf = Integer.parseInt(request.getParameter("conf"));
        if (conf == 0) {

            sesion.removeAttribute("usuario");
            sesion.invalidate();
            response.sendRedirect("index-hipotecas.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "login":
			loginUser(request, response);
			break;
		case "Registrarse":
			registerUser(request, response);
			break;

		default:
			response.sendRedirect("error.jsp");

	}


    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("contraseña");
    	
        boolean userIsCreated = this.authService.registerUsuario(correo, usuario, password);
        
        if (userIsCreated) {
            response.sendRedirect("login.jsp");

        }else {
            response.sendRedirect("error.jsp");
        }
    	
    }

    
    private void loginUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        HttpSession sesion = request.getSession();

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("contraseña");

        Usuario usuarioAutenticado = authService.authenticateUsuario(usuario, password);

        if (usuarioAutenticado != null) {
        	sesion.setAttribute("usuarioId", usuarioAutenticado.getId());
            sesion.setAttribute("usuario", usuario);
            response.sendRedirect("index-hipotecas.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
    
}
