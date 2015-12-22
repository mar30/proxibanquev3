<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.gtm.proxibanquev2.metier.User"%>
    <%@ page import="fr.gtm.proxibanquev2.metier.Conseiller"%>
    <%@ page import="fr.gtm.proxibanquev2.service.ConseillerService"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Valider Virement</title>
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
        <li class="active"><a href="Accueil.html">Acceuil</a></li>
        <li><a href="#">A propos de Proxibanque</a></li>
        <li><a href="#">Gallerie de photos</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="resultatLoginConseiller.jsp"><span class="glyphicon glyphicon-share-alt"></span> Retour</a></li>
        <li><a href="Logout.jsp"><span class="glyphicon glyphicon-remove"></span> Logout</a></li> 
       
      </ul>
    </div>
  </div>
</nav>



<div class="jumbotron text-center">
  <h1>Proxibanque</h1>
  <p>La banque de proximité</p>
</div>

	<center><h1>Virement pris en compte</h1><br/>
	<h3><a href="listeClient.jsp">Retour à la liste des clients</a></h3></center>
	
	  
</body>
</html>