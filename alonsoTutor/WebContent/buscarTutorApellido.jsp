<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <meta charset="utf-8">
    <title>Buscar tutor por nombre</title>
  </head>
  <body>
    <header>
      <h1>Busque_al_tutor por apellido</h1>
    </header>

    <article>
      <section id="buscaTutorSec">
        <form action="buscaTutorApellido" method="get" name="Busca Tutor">
          <input type="text" name="tutor.Apellido" value="">
		  <br>

          <input type="submit" name="consultarTutor" value="consultarTutor">


        </form>

      </section>

    </article>

  </body>
</html>