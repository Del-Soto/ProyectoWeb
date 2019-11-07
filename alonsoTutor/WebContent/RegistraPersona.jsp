<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cursos IPN</title>
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
<h2>Ingresa tus datos.</h2><br>
        <form method="get" action="PersonaServlet">
            <p>Nombre: <input type="text" maxlength="50" required name="nombre" id="nombre"></p>
            <p>Primer Apellido: <input type="text" name="primerApellido" id="primerApellido"></p>
            <p>Segundo Apellido: <input type="text" name="segundoApellido" id="segundoApellido"></p>
            <p>CURP: <input type="text" maxlength="18" name="curp" id="curp"></p>
            <!--<p>Folio: <input type="text" name="persona.segundoApellido" id="persona.segundoApellido"></p>--> 
            <p>Género: <select name="genero" id="genero">
            <option>Seleccionar</option>
            <option value="masculino">Masculino</option>
            <option value="femenino">Femenino</option>
            </select>
            </p>
            <p>Tipo de Sangre: <input type="text" name="tipoSangre" id="tipoSangre"></p>
            <input type="submit" value="Registrar">
        </form>
</body>
</html>