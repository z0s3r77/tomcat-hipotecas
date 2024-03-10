<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="prestamos.dominio.modelos.Hipoteca" %>
<%@ page import="prestamos.dominio.modelos.RegistroAmortizacion" %>
<%
    Hipoteca hipoteca = (Hipoteca) request.getAttribute("hipoteca");


    String user = (String) request.getSession().getAttribute("usuario");
    String usuarioLogueado;
    int userId;

    if (request.getSession() != null && user != null) {
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
    <title>Hipoteca</title>
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

<h1>Resultados</h1>
<p>Cuota mensual: <%= hipoteca.getCuotaMensual() %>
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
    <% for (RegistroAmortizacion registro : hipoteca.getCuadroDeAmortizacion()) { %>
    <tr>
        <td><%= registro.getNumeroDePago() %>
        </td>
        <td><%= registro.getCantidadPendiente() %>
        </td>
        <td><%= registro.getCantidadAmortizada() %>
        </td>
        <td><%= registro.getIntereses() %>
        </td>
        <td><%= registro.getCuota() %>
        </td>
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