<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='<c:url value="/res/js/jQuery.js" />'></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h1>
		Direccion para el admin:
		<c:out value="${idAdmin}"></c:out>
	</h1>
	<a href="${pageContext.request.contextPath}/showAdmins">Listado de
		Admins</a>
	<sf:form action="${pageContext.request.contextPath}/direccion/save"
		method="post" commandName="direccion">
		<table>
			<tr>
				<td>Calle</td>
				<td><sf:input path="calle" type="text" required="required"
						placeHolder="Escriba la calle..." /></td>
			</tr>
			<tr>
				<td>C.P.</td>
				<td><sf:input path="cp" type="text" required="required"
						placeHolder="Escriba el codigo postal..." /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios" /></td>
			</tr>
		</table>
	</sf:form>
	<br />
	<c:out value="${resultado}"></c:out>
	<br />
	<br />
</body>
</html>