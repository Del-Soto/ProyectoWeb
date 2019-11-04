<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
HttpSession misesion=request.getSession();
Integer codigo= 0;
codigo=(Integer)misesion.getAttribute("codigo");
if(codigo!=null && codigo==-1 ){
	
	out.write("<p>El nombre es un dato obligatorio, debe usted llenarlo</p>");
	
	}else if(codigo!=null && codigo==1 ) {
	out.write("<p>El usuario se registro correctamente</p>");
}else{
	
}

misesion.removeAttribute("codigo");
	
%>    
    
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>Modificar tutor</title>
  </head>
  <body>
    <header>
      <h1>Primero busque el nombre del tutor</h1>
    </header>

    <article>
      <section aria-label="Formulario" id="FormularioDireccion">
        <form name="modificarTutor" action="modificarTutor" method="get">
          <input type="text" name="tutor.nombre" value="">
          <br>
          <input type="submit" name="buscar" value="buscar">
          
        </form>

      </section>

    </article>

  </body>
</html>