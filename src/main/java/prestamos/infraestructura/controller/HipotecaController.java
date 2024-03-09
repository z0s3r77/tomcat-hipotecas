package prestamos.infraestructura.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prestamos.aplicacion.service.PrestamoService;
import prestamos.dominio.modelos.Hipoteca;

/**
 * Servlet implementation class PrestamoController
 */
@WebServlet(description = "Controlador para calcular y obtener prestamos.", urlPatterns = { "/HipotecaController" })
public class HipotecaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrestamoService prestamoService;

	public HipotecaController() {
		this.prestamoService = PrestamoService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.sendRedirect("index.jsp");

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		double capital = Double.parseDouble(req.getParameter("capital"));
		double interes = Double.parseDouble(req.getParameter("interes"));
		int frecuenciaDePagoEnMeses = Integer.parseInt(req.getParameter("frecuenciaDePagoEnMeses"));
		int plazoDeAmortizacionEnAnnos = Integer.parseInt(req.getParameter("plazoDeAmortizacionEnAnnos"));
		
		plazoDeAmortizacionEnAnnos = plazoDeAmortizacionEnAnnos * 12;
		
		if (req.getSession().getAttribute("userId") != null) {
			int usuarioId = (Integer) req.getSession().getAttribute("userId");
			Hipoteca hipoteca = new Hipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, usuarioId);
		}
		
		Hipoteca hipoteca = new Hipoteca(capital, interes, frecuenciaDePagoEnMeses, plazoDeAmortizacionEnAnnos, 0);

		hipoteca.calcularCuadroAmortizacion();

		req.setAttribute("hipoteca", hipoteca);
		req.getRequestDispatcher("resultado.jsp").forward(req, resp);
	}



}
