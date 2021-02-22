<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<head>
<script type="text/javascript" src="WebContent/resources/js/jQuery.js"></script>
<title>Lista de Admins</title>
<script type="text/javascript" src="./res/js/jQuery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".confirm").on("click", function() {
			return confirm("La direccion se eliminara, ¿esta seguro?");
		});
	});
</script>

</head>
<body>
	<h2>Listado de Direcciones</h2>
	<p>
		<strong>Ir al Inicio | <a
			href="${pageContext.request.contextPath}/admin">Crear Admin</a></strong>
	</p>
	<c:out value="${resultado}"></c:out>
	<table border="1">
		<tr>
			<th>Id Direccion</th>
			<th>Calle</th>
			<th>Codigo postal</th>
			<th>Administrador</th>
			<th>Aciones</th>
		</tr>
		<c:forEach var="di" items="${listDireccions}">
			<tr>
				<td>${di.idDir}</td>
				<td>${di.calle}</td>
				<td>${di.cp}</td>
				<td>${di.idAd.nombre}</td>
				<td><a
					href="updateDireccion/<c:out value='${di.idDir}'/>/update">Update</a>
					| <a class="confirm"
					href="deleteDireccion/<c:out value='${di.idDir}'/>/delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>