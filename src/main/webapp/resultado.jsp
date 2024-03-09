<%@ page import="prestamos.dominio.modelos.Hipoteca" %>
<%@ page import="prestamos.dominio.modelos.RegistroAmortizacion" %>
<%
    Hipoteca hipoteca = (Hipoteca) request.getAttribute("hipoteca");
%>
<h1>Resultados</h1>
<p>Cuota mensual: <%= hipoteca.getCuotaMensual() %></p>
<h2>Registro de amortizaci�n</h2>
<table>
    <tr>
        <th>N�mero de pago</th>
        <th>Saldo pendiente</th>
        <th>Amortizaci�n</th>
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