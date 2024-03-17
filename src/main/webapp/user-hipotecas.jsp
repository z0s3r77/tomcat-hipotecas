<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="prestamos.dominio.modelos.Prestamo"%>
<%@ page import="java.util.List"%>
<%@ page import="prestamos.aplicacion.service.PrestamoService"%>
<%@ page import="java.util.logging.Logger"%>


<%
Logger LOGGER = Logger.getLogger("user-hipotecas.jsp");
PrestamoService prestamoService = PrestamoService.getInstance();

String user = null;
int userId = 0;
List<Prestamo> prestamos = null;

try {
	user = (String) request.getSession().getAttribute("usuario");
	userId = (int) request.getSession().getAttribute("usuarioId");
	prestamos = prestamoService.getPrestamosFromUsuario(userId);
} catch (Exception e) {
	LOGGER.warning("There is not user logged");
	response.sendRedirect("index-hipotecas.jsp");
}
%>

<html>
<head>
<title>Hipotecas del Usuario</title>
<style>
a {
	color: #333;
	text-decoration: none;
}

a:hover {
	color: #007BFF;
	text-decoration: underline;
}

body {
	font-family: Arial, sans-serif;
}

.container {
	width: 80%;
	margin: auto;
}

.form-control {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
}

.btn {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 10px 2px;
	cursor: pointer;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

.button-link-logout {
	display: inline-block;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	background-color: orange;
	color: white;
	border: 1px solid #4CAF50;
	border-radius: 5px;
	cursor: pointer;
}

.button-link-delete {
	display: inline-block;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	background-color: red;
	color: white;
	border: 1px solid #4CAF50;
	border-radius: 5px;
	cursor: pointer;
}

.button-link {
	display: inline-block;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
	<h1>
		Hipotecas del Usuario | Usuario:
		<%=user%>
	</h1>
	<%
	if (prestamos != null && !prestamos.isEmpty()) {
	%>
	<table>
		<tr>
			<th>Capital</th>
			<th>Interés</th>
			<th>Frecuencia de Pago (Meses)</th>
			<th>Plazo de Amortización (Meses)</th>
			<th>Fecha de Creación</th>
		</tr>
		<%
		for (Prestamo prestamo : prestamos) {
		%>
		<tr>
			<td><%=prestamo.getCapital()%></td>
			<td><%=prestamo.getInteres()%></td>
			<td><%=prestamo.getFrecuenciaDePagoEnMeses()%></td>
			<td><%=prestamo.getPlazoDeAmortizacionEnMeses()%></td>
			<td><%=prestamo.getFechaCreacion()%></td>
			<td><form action="HipotecaController" method="post">
					<input type="hidden" name="prestamoId"
						value="<%=prestamo.getId()%>"> <input type="submit" class="button-link-delete"
						name="action" value="Borrar hipoteca">
				</form></td>
			<td>
				<form action="HipotecaController" method="post">
					<input type="hidden" name="prestamoId"
						value="<%=prestamo.getId()%>"> <input type="hidden"
						name="capital" value="<%=prestamo.getCapital()%>"> <input
						type="hidden" name="interes" value="<%=prestamo.getInteres()%>">
					<input type="hidden" name="frecuenciaDePagoEnMeses"
						value="<%=prestamo.getFrecuenciaDePagoEnMeses()%>"> <input
						type="hidden" name="plazoDeAmortizacionEnAnnos"
						value="<%=prestamo.getPlazoDeAmortizacionEnMeses()%>"> <input
						type="submit" name="action" class="button-link" value="Recalcular hipoteca">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<br>
	<h1><i>No hay Hipotecas</i></h1>
	<%
	}
	%>
	<br>
	<br>
	<a href="AuthController?conf=0" class="button-link-logout">Logout</a>
	<a href="index-hipotecas.jsp" class="button-link">Calcular Hipoteca</a>
</body>
</html>