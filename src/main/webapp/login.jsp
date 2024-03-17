<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
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


        .form-control {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
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
    
               .button-link-blue {
        display: inline-block;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        background-color: blue; 
        color: white;
        border: 1px solid #4CAF50; 
        border-radius: 5px;
        cursor: pointer;
    }
    </style>
</head>
<body>
<h1>Aplicación de las hipotecas | Login </h1>
    <br>
    <br>
    <!-- Formulario de Login  -->
    <form action="AuthController" method="post">
        <input type="text" name="usuario" placeholder="correo">
        <input type="password" name="contraseña" placeholder="contraseña">
        <button type="submit" name="action" value="login" class="button-link-blue" >Login</button>
    </form>
    <br>
    <br>
    
<a href="index-hipotecas.jsp"  class="button-link">Inicio</a>
<a href="register.jsp"  class="button-link">Registrarse</a>
</body>
</html>