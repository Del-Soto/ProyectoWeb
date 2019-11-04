<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <form name="modificarTutor2" action="modificarTutor2" method="get">
          <input type="text" name="tutor.nombre" value="">
          <br>
          <input type="text" name="tutor.primerApellido" value="">
          <br>
          <input type="text" name="tutor.segundoApellido" value="">
          <br>
          <input type="submit" name="guardar" value="guardar">
          
        </form>

      </section>

    </article>

  </body>
</html>