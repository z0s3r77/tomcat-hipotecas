<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String user = (String) request.getSession().getAttribute("usuario");
    String usuarioLogueado;

    if (request.getSession() != null && user != null) {
        usuarioLogueado = user;
    } else {
        usuarioLogueado = "Anónimo";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
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
<h1> Aplicación de las hipotecas | Usuario: <%=usuarioLogueado%>
</h1>
<div class="container">
    <h2 class="text-center mb-4">Calculadora de Hipoteca</h2>
    <form action="HipotecaController" method="post" class="form-group">

        <label for="capital" class="form-label">Capital:</label>
        <input type="number" id="capital" name="capital" min="0" step="0.01" required class="form-control">

        <label for="interes" class="form-label mt-2">Interés:</label>
        <input type="number" id="interes" name="interes" min="0" step="0.01" required class="form-control">

        <label for="frecuenciaDePagoEnMeses" class="form-label mt-2">Frecuencia de pago en meses:</label>
        <select id="frecuenciaDePagoEnMeses" name="frecuenciaDePagoEnMeses" required class="form-control">
            <option value="1">Mensual</option>
            <option value="3">Trimestral</option>
            <option value="12">Anual</option>
        </select>

        <label for="plazoDeAmortizacionEnAnnos" class="form-label mt-2">Plazo de amortización en años:</label>
        <input type="number" id="plazoDeAmortizacionEnAnnos" name="plazoDeAmortizacionEnAnnos" min="0" required
               class="form-control">
        <input type="submit" name="action" value="Calcular hipoteca" class="btn btn-primary mt-3">
    </form>
</div>
<br>
<br>
<%
    if (usuarioLogueado.equals("Anónimo")) {
%>
<a href="login.jsp">Login</a>
<a href="register.jsp">Registrarse</a>
<%
} else {
%>
<p>
    <a href="AuthController?conf=0">Logout</a>
    <a href="user-hipotecas.jsp">Ver mis hipotecas</a>
</p>
<%
    }
%>
</body>
</html>