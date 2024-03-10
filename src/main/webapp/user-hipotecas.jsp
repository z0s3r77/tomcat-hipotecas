<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="prestamos.dominio.modelos.Prestamo" %>
<%@ page import="java.util.List" %>
<%@ page import="prestamos.aplicacion.service.PrestamoService" %>

<%

    PrestamoService prestamoService = PrestamoService.getInstance();

    String user = (String) request.getSession().getAttribute("usuario");
    int userId = (int) request.getSession().getAttribute("usuarioId");

    List<Prestamo> prestamos = prestamoService.getPrestamosFromUsuario(userId);
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
<ul>
    <% for (Prestamo prestamo : prestamos) { %>
    <li><%= prestamo.toString() %>
    </li>
    <form action="HipotecaController" method="post">
        <input type="hidden" name="prestamoId" value="<%=prestamo.getId()%>">
        <input type="submit" name="action" value="Borrar hipoteca">
    </form>
    <form action="HipotecaController" method="post">
        <input type="hidden" name="prestamoId" value="<%=prestamo.getId()%>">
        <input type="hidden" name="capital" value="<%=prestamo.getCapital()%>">
        <input type="hidden" name="interes" value="<%=prestamo.getInteres()%>">
        <input type="hidden" name="frecuenciaDePagoEnMeses" value="<%= prestamo.getFrecuenciaDePagoEnMeses()%>">
        <input type="hidden" name="plazoDeAmortizacionEnAnnos" value="<%= prestamo.getPlazoDeAmortizacionEnMeses()%>">
        <input type="submit" name="action" value="Recalcular hipoteca">
    </form>
    <% } %>
</ul>
<% } else { %>
<p>No hay Hipotecas</p>
<% } %>

<a href="index-hipotecas.jsp">Calcular hipoteca</a>
</body>
</html>