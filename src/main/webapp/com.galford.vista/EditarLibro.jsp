<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDITAR LIBRO</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<h1>EDITAR LIBRO</h1>
	<form action="ControladorLibro" method="post">
		<div class="form-group container col-lg=6">
			<fieldset>
				<div>
					<label for="id">ID</label> <input type="text" name="id"
						class="form-control" value="<c:out value="${libro.id}"/>"
						readonly="readonly" placeholder="Libro id" />
				</div>
				<div>
					<label for="nombre">Nombre Libro</label> <input type="text"
						name="nombre" class="form-control"
						value="<c:out value="${libro.nombre}"/>" placeholder="Nombre" />
				</div>
				<div>
					<label for="genero">Género</label> <input type="text" name="genero"
						class="form-control" value="<c:out value="${libro.genero}"/>"
						placeholder="Género" />
				</div>
				<div>
					<label for="autor">Autor</label> <input type="text" name="autor"
						class="form-control" value="<c:out value="${libro.autor}"/>"
						placeholder="Autor" />
				</div>
				<br>
				<div>
					<input type="submit" class="btn btn-primary" value="Aceptar" />
				</div>
			</fieldset>
		</div>
	</form>
	<!-- <form method="get" action="ControladorLibro">
		<input type="hidden" name="accion" value="listar">
		<button class="btn-primary">Regresar Lista</button>
	</form> -->
	<div>
		<a href="ControladorLibro?accion=Listar">Regresar a Lista</a>
	</div>
</body>
</html>
