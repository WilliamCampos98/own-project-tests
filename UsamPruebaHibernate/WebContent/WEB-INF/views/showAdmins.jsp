<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<head>
<title>Lista de Admins</title>
<script type="text/javascript" src='<c:url value="/res/js/jQuery.js" />'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".confirm").on("click", function() {
			return confirm("El administrador se eliminara, ¿Continuar?");
		});
	});
</script>
</head>
<body>
	<h2>Listado de Administradores</h2>
	<p>
		<strong>Ir al Inicio | <a
			href="${pageContext.request.contextPath}/admin">Crear Admin</a><a
			href="./showAllDireccions">| Direcciones</a></strong>
	</p>
	<c:out value="${resultado}"></c:out>
	<table border="1">
		<tr>
			<th>Id Admin</th>
			<th>Nombre</th>
			<th>Cargo</th>
			<th>Fecha Creacion</th>
			<th>Accion</th>
		</tr>
		<c:forEach var="admin" items="${listAdmins}">
			<tr>
				<td>${admin.idAd}</td>
				<td>${admin.nombre}</td>
				<td>${admin.cargo}</td>
				<td>${admin.fechaCreacion}</td>
				<td><a href="updateAdmin/<c:out value='${admin.idAd}'/>/update">Update</a>
					| <a href="direccion/<c:out value='${admin.idAd}'/>">Direcciones</a>
					| <a class="confirm"
					href="deleteAdmin/<c:out value='${admin.idAd}'/>/delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>