<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<h2>Vista de humano</h2>
	<br>
	<label>Atributos de la session:</label>
	<br>
	<c:out value="${mensaje}" />
	<br>
	<br>
	<label>Atributos del modelo:</label>
	<c:out value="${humano}" />
</body>
</html>