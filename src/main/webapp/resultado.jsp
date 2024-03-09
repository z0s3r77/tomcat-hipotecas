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
<%
    if (usuarioLogueado.equals("Anónimo")) {
%>
<a href="login.jsp">Login</a>
<%
} else {
%>
<div>
<form action="HipotecaController" method="post">
    <input type="hidden" name="action" value="Guardar hipoteca">
    <input type="hidden" name="capital" value="<%= hipoteca.getCapital() %>">
    <input type="hidden" name="interes" value="<%= hipoteca.getInteres() %>">
    <input type="hidden" name="frecuenciaDePagoEnMeses" value="<%= hipoteca.getFrecuenciaDePagoEnMeses() %>">
    <input type="hidden" name="plazoDeAmortizacionEnAnnos" value="<%= hipoteca.getPlazoDeAmortizacionEnMeses() %>">
    <input type="hidden" name="usuarioId" value="<%= userId %>">
    <input type="submit" value="Guardar hipoteca">
</form>
    <a href="AuthController?conf=0">Logout</a>
	<a href="user-hipotecas.jsp">Ver mis hipotecas</a>
</div>
<%
    }
%>

    <a href="index-hipotecas.jsp">Calcular otra hipoteca</a>

