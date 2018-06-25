<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tous les clients</title>
</head>
<c:url value="/show-client.html?clientId=" var="showClientUrl" />
<body>
	<h1>Liste des clients :</h1>
	<ul>
	<c:forEach items="${clients}" var="client">
		<li>
			<h3>${client.name} <a href="${showClientUrl}${client.id}">(Détails)</a></h3>
		</li>		
	</c:forEach>
	</ul>
</body>
</html>