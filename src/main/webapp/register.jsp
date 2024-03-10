<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrarse</title>
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
<h1>Aplicación de las hipotecas | Registrarse </h1>
    <form action="AuthController" method="post">
        <input type="text" name="correo" placeholder="correo">
        <input type="text" name="usuario" placeholder="usuario">
        <input type="text" name="contraseña" placeholder="contraseña">
        <button type="submit" name="action" value="Registrarse">Login</button>
    </form>
<a href="index-hipotecas.jsp">Inicio</a>
<a href="register.jsp">Registrarse</a>
</body>
</html>