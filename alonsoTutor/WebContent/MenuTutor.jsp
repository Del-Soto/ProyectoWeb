<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>Menu de tutor</title>
  </head>
  <body>
    <header>
      <h1>Seleccione lo que desea realizar</h1>
    </header>

    <article>
      <section>

        <form action="MenuTutor" method="get">
          <input type="submit" name="buscarTutorN" value="Buscar tutor por nombre">
          <br>
          <input type="submit" name="buscarTutorA" value="Buscar tutor por apellido">
          <br>
          <input type="submit" name="eliminarTutor" value="Eliminar tutor">
          <br>
          <input type="submit" name="registrarTutor" value="registrar tutor">
          <br>
          <input type="submit" name="modificarTutor" value="modificar tutor">
          <br>

        </form>


      </section>

    </article>

  </body>
</html>
