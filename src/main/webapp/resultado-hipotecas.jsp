<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="prestamos.dominio.modelos.Hipoteca"%>
<%@ page import="prestamos.dominio.modelos.RegistroAmortizacion"%>
<%@ page import="java.util.logging.Logger"%>
<%
Logger LOGGER = Logger.getLogger("resultado-hipotecas.jsp");

Hipoteca hipoteca = null;
String usuarioLogueado;
String user = null;
int userId = 0;

try {
	hipoteca = (Hipoteca) request.getAttribute("hipoteca");
	user = (String) request.getSession().getAttribute("usuario");
	usuarioLogueado = user;
	userId = (int) request.getSession().getAttribute("usuarioId");
} catch (Exception e) {
	LOGGER.warning("There is not user logged");
	response.sendRedirect("index-hipotecas.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
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

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<h1>Resultados</h1>
	<p>
		Cuota mensual:
		<%=hipoteca.getCuotaMensual()%> €
	</p>
	<h2>Registro de amortización</h2>
	<table>
		<tr>
			<th>Número de pago</th>
			<th>Saldo pendiente</th>
			<th>Amortización</th>
			<th>Intereses pendientes</th>
			<th>Cuota mensual</th>
		</tr>
		<%
		for (RegistroAmortizacion registro : hipoteca.getCuadroDeAmortizacion()) {
		%>
		<tr>
			<td><%=registro.getNumeroDePago()%></td>
			<td><%=registro.getCantidadPendiente()%></td>
			<td><%=registro.getCantidadAmortizada()%></td>
			<td><%=registro.getIntereses()%></td>
			<td><%=registro.getCuota()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<h2>Resumen de la hipoteca</h2>
	<h3>Características:</h3>
	<ul>
		<li>Importe: <%=hipoteca.getCapital()%> €
		</li>
		<li>Tipo de interés: <%=hipoteca.getInteres()%> %
		</li>
		<li>Plazo de amortzación en meses:  <%=hipoteca.getPlazoDeAmortizacionEnMeses()%> </li>
		<li>Frecuencia de amortización:  <%=hipoteca.getFrecuenciaAmortizacion()%>
		</li>
	</ul>

	<div>
		<br> <br> <a href="AuthController?conf=0"
			class="button-link-logout">Logout</a> <a href="index-hipotecas.jsp"
			class="button-link">Calcular otra hipoteca</a> <a
			href="user-hipotecas.jsp" class="button-link">Ver mis hipotecas</a>

	</div>
</body>
</html>