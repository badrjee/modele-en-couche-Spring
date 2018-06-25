<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mise à jour</title>
</head>
<body>
	<h2>Créer un nouvel article</h2>
	<form method="post">
		<c:if test="${not empty client}">
			<input type="hidden" name="id" value="${client.id}" />
		</c:if>
		<div>
			<label for="name">Nom :</label>
			<input id="name" name="name" value="${not empty client ? client.name : '' }" />
		</div>
		<button>Valider</button>
	</form>
</body>
</html>