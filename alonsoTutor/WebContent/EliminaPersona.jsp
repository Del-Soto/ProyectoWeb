<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession misesion=request.getSession();
Integer codigo= 0;
codigo=(Integer)misesion.getAttribute("codigo");
if(codigo!=null && codigo==-1 ){
	
	out.write("<p>El nombre es un dato obligatorio, debe usted llenarlo</p>");
	
	}else if(codigo!=null && codigo==1 ) {
	out.write("<p>Te has registrado con éxito.</p>");
}else{
	
}

misesion.removeAttribute("codigo");
	
%>
<h2>Ingresa tus datos para eliminar tu registro.</h2><br>
        <form method="get" action="DelPersonaServlet">
            <p>Nombre: <input type="text" maxlength="50" required name="nombre" id="nombre"></p>
            <p>Primer Apellido: <input type="text" name="primerApellido" id="primerApellido"></p>
            <p>Segundo Apellido: <input type="text" name="segundoApellido" id="segundoApellido"></p>
            
            <input type="submit" value="Eliminar">
        </form>
</body>
</html>