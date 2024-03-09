<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrarse</title>
</head>
<body>
<h1>Aplicación de las hipotecas | Registrarse </h1>
    <form action="AuthController" method="post">
    	<input type="text" name="correo" placeholder="correo">
        <input type="text" name="usuario" placeholder="usuario">
        <input type="text" name="contraseña" placeholder="contraseña">
        <button type="submit" name="action" value="login">Login</button>
    </form>
    
    <a href="index-hipotecas.jsp">Inicio</a>
    <a href="register.jsp">Registrarse</a>
</body>
</html>
