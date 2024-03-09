package prestamos.infraestructura.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prestamos.aplicacion.service.PrestamoService;
import prestamos.dominio.modelos.Prestamo;

/**
 * Servlet implementation class PrestamoController
 */
@WebServlet(description = "Controlador para calcular y obtener prestamos.", urlPatterns = { "/HipotecaController" })
public class HipotecaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrestamoService prestamoService;
	
    private static final Logger log = Logger.getLogger(HipotecaController.class.getName());
    
	public HipotecaController() {
		this.prestamoService = PrestamoService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.sendRedirect("index-hipotecas.jsp");

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
			case "getHipoteca":
				makeHipoteca(req, resp);
				break;

			case "saveHipoteca":
				System.out.println(req.getParameter("usuarioId") + " Action");
				saveHipoteca(req, resp);
				break;
			default:
				resp.sendRedirect("error.jsp");

		}
	}

	private void saveHipoteca(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		double capital = Double.parseDouble(req.getParameter("capital"));
		double interes = Double.parseDouble(req.getParameter("interes"));
		int frecuenciaDePagoEnMeses = Integer.parseInt(req.getParameter("frecuenciaDePagoEnMeses"));
		int plazoDeAmortizacionEnAnnos = Integer.parseInt(req.getParameter("plazoDeAmortizacionEnAnnos"));
		plazoDeAmortizacionEnAnnos = plazoDeAmortizacionEnAnnos * 12;

		if (req.getSession().getAttribute("usuarioId") == null) {
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}

		System.out.println(req.getParameter("usuarioId") + " Parametros");
		
		int usuarioId = Integer.parseInt(req.getParameter("usuarioId")) ;

		Prestamo hipoteca = prestamoService.makeHipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, usuarioId);

		prestamoService.createPrestamo(hipoteca);
		List<Prestamo> prestamosDelUsuario = prestamoService.getPrestamosFromUsuario(usuarioId);
		req.setAttribute("prestamos", prestamosDelUsuario);
		req.getRequestDispatcher("user-hipotecas.jsp").forward(req, resp);
	}
	
	
	

	private void makeHipoteca(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		double capital = Double.parseDouble(req.getParameter("capital"));
		double interes = Double.parseDouble(req.getParameter("interes"));
		int frecuenciaDePagoEnMeses = Integer.parseInt(req.getParameter("frecuenciaDePagoEnMeses"));
		int plazoDeAmortizacionEnAnnos = Integer.parseInt(req.getParameter("plazoDeAmortizacionEnAnnos"));

		plazoDeAmortizacionEnAnnos = plazoDeAmortizacionEnAnnos * 12;

		int usuarioId = (req.getSession().getAttribute("usuarioId") != null) ? (Integer) req.getSession().getAttribute("usuarioId") : 0;

		Prestamo hipoteca = prestamoService.makeHipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, usuarioId);
		prestamoService.calculatePrestamo(hipoteca);

		req.setAttribute("hipoteca", hipoteca);
		req.getRequestDispatcher("resultado.jsp").forward(req, resp);
	}


}
