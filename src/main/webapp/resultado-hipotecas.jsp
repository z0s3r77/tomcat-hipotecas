<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="prestamos.dominio.modelos.Hipoteca" %>
<%@ page import="prestamos.dominio.modelos.RegistroAmortizacion" %>
<%
    Hipoteca hipoteca = (Hipoteca) request.getAttribute("hipoteca");
	System.out.println(hipoteca);


    String user = (String) request.getSession().getAttribute("usuario");
    if (request.getSession() == null || user == null) {
        System.out.println("No hay usuario logueado");
    }
    String usuarioLogueado;
    int userId;

    if (request.getSession() != null && user != null) {
        System.out.println("Usuario logueado: " + user);
        usuarioLogueado = user;
        userId = (int) request.getSession().getAttribute("usuarioId");
    } else {
        usuarioLogueado = "Anónimo";
        userId = 0;
    }

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Resultados</h1>
<p>Cuota mensual: <%= hipoteca.getCuotaMensual() %></p>
<h2>Registro de amortización</h2>
<table>
    <tr>
        <th>Número de pago</th>
        <th>Saldo pendiente</th>
        <th>Amortización</th>
        <th>Intereses pendientes</th>
        <th>Cuota mensual</th>
    </tr>
    <% for (RegistroAmortizacion registro : hipoteca.getCuadroDeAmortizacion()) { %>
    <tr>
        <td><%= registro.getNumeroDePago() %></td>
        <td><%= registro.getCantidadPendiente() %></td>
        <td><%= registro.getCantidadAmortizada() %></td>
        <td><%= registro.getIntereses() %></td>
        <td><%= registro.getCuota() %></td>
    </tr>
    <% } %>
</table>
<div>
    <a href="AuthController?conf=0">Logout</a>
    <a href="index-hipotecas.jsp">Calcular otra hipoteca</a>
	<a href="user-hipotecas.jsp">Ver mis hipotecas</a>

</div>
</body>
</html>