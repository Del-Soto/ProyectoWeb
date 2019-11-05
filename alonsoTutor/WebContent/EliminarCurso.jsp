<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Rokkitt|Source+Sans+Pro&display=swap" rel="stylesheet"> 
<link rel="stylesheet" href="css/estilos.css">
<title>Insert title here</title>
</head>
<body>
<article class="main-container">
	<section class="box-form">
		<header><h1>Eliminar Curso</h1></header>
		<form class="form" action="EliminarCursoControl" method="get">
			<label>Nombre:</label>
			<input type="text" name="curso.nombre" id="curso.nombre">
			<label>Fecha Inicio:</label>
			<input type="date" name="curso.fechaInicio" id="fechaInicio">
			<label>Fecha Final:</label>
			<input type="date" name="curso.fechaFin" id="curso.fechaFin">
			<input type="submit" id="boton-form" value="Eliminar">
		</form>
	</section>		
	</article>
</html>