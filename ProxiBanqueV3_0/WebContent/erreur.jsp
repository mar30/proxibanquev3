<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erreur applicative</title>
</head>
<body>
<% Exception exception = (Exception) request.getAttribute("exception"); %>
<h3>Un erreur s'est verifié: <c:out value="${sessionScope.exception.message}"/></h3>
<p>
<a href="Accueil.html"><span class="glyphicon glyphicon-share-alt"></span>Retour à l'accueil</a>
</body>
</html>