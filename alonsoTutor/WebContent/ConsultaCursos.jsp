<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession misesion=request.getSession();
String nombre = "";
nombre = (String)misesion.getAttribute("nombre");

	
	out.write("<p>"+nombre+"</p>");


misesion.removeAttribute("nombre");
	
%>
	<form class="form" action="ConsultarCursoControl" method="get">
			<input type="submit" id="boton" value="Eliminar">
		</form>
</body>
</html>