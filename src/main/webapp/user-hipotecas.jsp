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
</head>
<body>
    <h1>Hipotecas del Usuario | Usuario: <%=user%></h1>

    <% if (prestamos != null) { %>
        <ul>
            <% for (Prestamo prestamo : prestamos) { %>
                <li><%= prestamo.toString() %></li><a href=""></a>
            <% } %>
        </ul>
    <%
    } else { 
    %>
		<h1>No hay Hipotecas</h1>
	<%
	    }
	%>

    <a href="index-hipotecas.jsp">Calcular hipoteca</a>
</body>
</html>
