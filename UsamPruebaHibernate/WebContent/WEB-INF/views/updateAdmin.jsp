<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar Admin</title>
</head>
<body>

	<h1>Admin.jsp</h1>

	<sf:form action="${pageContext.request.contextPath}/updateAdmin/update"
		method="post" commandName="adminUpdate">
		<table>
			<tr>
				<td>Id Admin</td>
				<td><sf:input path="idAd" type="text" readonly="true" /></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><sf:input path="nombre" type="text" /></td>
			</tr>
			<tr>
				<td>Cargo</td>
				<td><sf:input path="cargo" type="text" /></td>
			</tr>
			<tr>
				<td>Fecha creacion</td>
				<td><sf:input path="fechaCreacion" type="datetime" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios" /></td>
			</tr>
		</table>
	</sf:form>
	<br />
	<a href='<c:url value="/showAdmins"/>'>Listado de Admins</a>
	<c:out value="${resultado}"></c:out>
</body>
</html>