<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="prestamos.dominio.modelos.Prestamo" %>
<%@ page import="java.util.List" %>
<%@ page import="prestamos.aplicacion.service.PrestamoService" %>
<%@ page import="java.util.logging.Logger" %>


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
	} catch (Exception e){
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
    </style>
</head>
<body>
<h1>Hipotecas del Usuario | Usuario: <%=user%>
</h1>
<% if (prestamos != null && !prestamos.isEmpty()) { %>
<table>
    <tr>
        <th>Capital</th>
        <th>Interés</th>
        <th>Frecuencia de Pago (Meses)</th>
        <th>Plazo de Amortización (Meses)</th>
        <th>Fecha de Creación</th>
    </tr>
    <% for (Prestamo prestamo : prestamos) { %>
    <tr>
        <td><%= prestamo.getCapital() %></td>
        <td><%= prestamo.getInteres() %></td>
        <td><%= prestamo.getFrecuenciaDePagoEnMeses() %></td>
        <td><%= prestamo.getPlazoDeAmortizacionEnMeses() %></td>
        <td><%= prestamo.getFechaCreacion() %></td>
        <td><form action="HipotecaController" method="post">
            <input type="hidden" name="prestamoId" value="<%=prestamo.getId()%>">
            <input type="submit" name="action" value="Borrar hipoteca">
        </form></td>
        <td> <form action="HipotecaController" method="post">
            <input type="hidden" name="prestamoId" value="<%=prestamo.getId()%>">
            <input type="hidden" name="capital" value="<%=prestamo.getCapital()%>">
            <input type="hidden" name="interes" value="<%=prestamo.getInteres()%>">
            <input type="hidden" name="frecuenciaDePagoEnMeses" value="<%= prestamo.getFrecuenciaDePagoEnMeses()%>">
            <input type="hidden" name="plazoDeAmortizacionEnAnnos" value="<%= prestamo.getPlazoDeAmortizacionEnMeses()%>">
            <input type="submit" name="action" value="Recalcular hipoteca">
        </form></td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>No hay Hipotecas</p>
<% } %>

<a href="index-hipotecas.jsp">Inicio</a>
</body>
</html>