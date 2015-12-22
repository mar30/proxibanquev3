<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.gtm.proxibanquev2.metier.User"%>
    <%@ page import="fr.gtm.proxibanquev2.metier.Client"%>
    <%@ page import="fr.gtm.proxibanquev2.service.ConseillerService"%>
    <%@ page import="fr.gtm.proxibanquev2.service.ClientService"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Client</title>
<link href="bootstrap-3.3.6-dist/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet" type="text/css" />
<style>
.jumbotron {
    background-color: #f4511e; /* Orange */
    color: #ffffff;
}
</style>
</head>
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
        <li class="active"><a href="Acceuil.html">Acceuil</a></li>
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

    <% 
      Client cl=(Client) session.getAttribute("cl");
	%>
	
<div class="container">
<div class="col-md-4 col-md-offset-4">
  
  <form method="post" class="form-horizontal" role="form" action="MajClient">
    <div class="form-group">
    <label for="prenom">Prénom : </label>
      <input type="text" class="form-control" id="prenom" name="prenom" value="<%=cl.getPrenom() %>">
    </div>
    <div class="form-group">
    <label for="nom">Nom : </label>
      <input type="text" class="form-control" id="nom" name="nom" value="<%=cl.getNom() %>">
    </div>
    <div class="form-group">
    <label for="adresse">Adresse : </label>
      <input type="text" class="form-control" id="adresse" name="adresse" value="<%=cl.getAdresse() %>">
    </div>
    <div class="form-group">
    <label for="codePostal">Code Postal : </label>
      <input type="text" class="form-control" id="codePostal" name="codePostal" value="<%=cl.getCodePostal() %>">
    </div>
    <div class="form-group">
    <label for="ville">Ville : </label>
      <input type="text" class="form-control" id="ville" name="ville" value="<%=cl.getVille() %>">
    </div>
    <div class="form-group">
    <label for="tel">Téléphone : </label>
      <input type="text" class="form-control" id="tel" name="tel" value="<%=cl.getTel() %>">
    </div>
    <div class="form-group">
    <label for="tel">Email : </label>
      <input type="text" class="form-control" id="email" name="email" value="<%=cl.getEmail() %>">
    </div>
    <input type="hidden" name="idcli" value="<%=cl.getIdcli() %>">
    <button type="submit" class="btn btn-default">Mettre à jour</button>
    
  </form>
  </div>
</div>
	
	  
</body>
</html>