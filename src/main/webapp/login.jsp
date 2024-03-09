<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String sUsuario = (String) request.getSession().getAttribute("sUsuario");

%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Aplicación de las hipotecas | Login </h1>
    <form action="AuthController" method="post">
        <input type="text" name="usuario" placeholder="usuario">
        <input type="text" name="contraseña" placeholder="contraseña">
        <button type="submit" name="action" value="login">Login</button>
    </form>
    
    <a href="index-hipotecas.jsp">Inicio</a>
</body>
</html>
