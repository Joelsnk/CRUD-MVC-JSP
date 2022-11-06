<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTAR BASE DATOS LIBRO</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<h1>LISTA DE LIBROS</h1>
	<div class="container mt-3">
		<div class="navbar">
			<!-- <form method="get" action="ControladorLibro">
				<input type="hidden" name="accion" value="agregar">
				<button class="btn btn-success btn-lg">Agregar Nuevo</button>
			</form> -->
			<a class="btn btn-success btn-bg"
				href="ControladorLibro?accion=Agregar">Agregar Nuevo</a>
			<form action="ControladorLibro" method="get" class="form-inline">
				<input type="search" name="buscar" class="form-control" /> <input
					type="submit" name="accion" value="buscar"
					class="btn btn-outline-success" />
			</form>
		</div>
		<br>
		<table class="table table-responsive table-striped table-bordered">
			<thead>
				<tr class="info">
					<th class="text-center">ID</th>
					<th class="text-center">Nombre</th>
					<th class="text-center">Género</th>
					<th class="text-center">Autor</th>
					<th class="text-center" colspan="2">Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listLibro}" var="libro">
					<tr>
						<td class="text-center"><c:out value="${libro.id}" /></td>
						<td class="text-center"><c:out value="${libro.nombre}" /></td>
						<td class="text-center"><c:out value="${libro.genero}" /></td>
						<td class="text-center"><c:out value="${libro.autor}" /></td>
						<td class="text-center"><a class="btn btn-warning btn-lg"
							href="ControladorLibro?accion=Actualizar&id=<c:out value="${libro.id}"/>">Actualizar</a></td>
						<td class="text-center"><a class="btn btn-danger btn-lg"
							onclick="javascript:if(!confirm('Desea eliminar el registro?')) return false"
							href="ControladorLibro?accion=Eliminar&id=<c:out value="${libro.id}"/>">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="ControladorLibro?accion=Principal">Volver a página	principal</a>
		</div>
	</div>

</body>
</html>