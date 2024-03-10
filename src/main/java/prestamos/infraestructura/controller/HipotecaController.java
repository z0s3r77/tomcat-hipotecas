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
@WebServlet(description = "Controlador para calcular y obtener hipotecas.", urlPatterns = { "/HipotecaController" })
public class HipotecaController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	PrestamoService prestamoService;
    private static final Logger LOGGER = Logger.getLogger(HipotecaController.class.getName());

    
	public HipotecaController() {
		this.prestamoService = PrestamoService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index-hipotecas.jsp");
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
			case "Calcular hipoteca":
				makeHipoteca(req, resp);
				break;

			case "Guardar hipoteca":
				saveHipoteca(req, resp);
				break;
			case "Borrar hipoteca":
				deleteHipoteca(req, resp);
				break;
				
			case "Recalcular hipoteca":
				recalculateHipoteca(req, resp);
				break;
			default:
				resp.sendRedirect("error.jsp");

		}
	}
	
	private void recalculateHipoteca(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		double capital = Double.parseDouble(req.getParameter("capital"));
		double interes = Double.parseDouble(req.getParameter("interes"));
		int frecuenciaDePagoEnMeses = Integer.parseInt(req.getParameter("frecuenciaDePagoEnMeses"));
		int plazoDeAmortizacionEnAnnos = Integer.parseInt(req.getParameter("plazoDeAmortizacionEnAnnos"));

		plazoDeAmortizacionEnAnnos = plazoDeAmortizacionEnAnnos * 12;

		int usuarioId = (req.getSession().getAttribute("usuarioId") != null) ? (Integer) req.getSession().getAttribute("usuarioId") : 0;

		Prestamo hipoteca = prestamoService.makeHipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, usuarioId);
		prestamoService.calculatePrestamo(hipoteca);

		req.setAttribute("hipoteca", hipoteca);
		req.getRequestDispatcher("resultado-hipotecas.jsp").forward(req, resp);
		
		
		
	}
	
	private void deleteHipoteca(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		int prestamoId = Integer.parseInt(req.getParameter("prestamoId")) ;

		boolean resultado = this.prestamoService.deletePrestamo(prestamoId);
		
		if (resultado) {
			req.getRequestDispatcher("user-hipotecas.jsp").forward(req, resp);
		
		}else {
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
