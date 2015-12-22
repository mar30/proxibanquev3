<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="fr.gtm.proxibanquev2.metier.User"%>
 <%@ page import="fr.gtm.proxibanquev2.metier.Conseiller"%>
 <%@ page import="fr.gtm.proxibanquev2.service.ClientService"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultat Login</title>
<link href="bootstrap-3.3.6-dist/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<style>
.jumbotron {
    background-color: #f4511e; /* Orange */
    color: #ffffff;
}
</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Proxibanque</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="Accueil.html">Accueil</a></li>
        <li><a href="#">A propos de Proxibanque</a></li>
        <li><a href="#">Gallerie de photos</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      </div>
  </div>
</nav>



<div class="jumbotron text-center">
  <h1>Proxibanque</h1>
  <p>La banque de proximité</p>
</div>

    <% 
	  Conseiller c=(Conseiller) session.getAttribute("conseiller");
      boolean verif = (boolean) session.getAttribute("verif");
      Exception exception = (Exception) session.getAttribute("exception");
     User loggeduser = (User) session.getAttribute("login");
      
	%>
	
	<%
    
    	
    if(verif&&loggeduser.getType().equals("C")){
    %>
	<center><h1>Bienvenue <c:out value="${sessionScope.conseiller.nom}"/> !</h1><br/>
	<h3><a href="listeClient.jsp">Consulter Liste Clients</a></h3></center>
	<%} 
    else if(verif&&loggeduser.getType().equals("A")){%>
	<center><h1>Bienvenue user!</h1><br/>
	<p>
	Ce use case reste à implementer:
	<a href="Logout.jsp"><span class="glyphicon glyphicon-remove"></span> Logout</a>
	</center>
	<%
	}
    else {
	%>
	<center><h1>Echec authentification</h1><br/>
	<p>
	<p>Un problème s'est verifié: <c:out value="${sessionScope.exception.message}"/></p>
	<p>
	<h3><a href="login.html">Essayer à nouveau.</a></h3></center>
	<%
		} 
	%>
	
	  
</body>
</html>