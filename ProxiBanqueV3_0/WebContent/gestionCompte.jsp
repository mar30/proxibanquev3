<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.gtm.proxibanquev2.metier.Compte"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="fr.gtm.proxibanquev2.metier.Client"%>
    <%@ page import="fr.gtm.proxibanquev2.service.ConseillerService"%>
    <%@ page import="fr.gtm.proxibanquev2.service.ClientService"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Compte</title>
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
      Client cl = (Client) session.getAttribute("client");
      ArrayList<Compte> listeCompte = (ArrayList<Compte>) session.getAttribute("listeCompte");
	%>
	
	<div class="container">
  <h2>Liste des comptes de <c:out value="${sessionScope.client.prenom}"/> <c:out value="${sessionScope.client.nom}"/> :</h2>           
  <table class="table">
    <thead>
      <tr>
        <th>IdCompte</th>
        <th>Solde</th>
        <th>Date Ouverture</th>
        <th>Découvert Autorisé</th>
        <th>Taux</th>
      </tr>
    </thead>
    <%
    
    for (int i=0; i<=listeCompte.size()-1;i++) {
    	
	%>
    <tbody>
      <tr>
        <td><%=listeCompte.get(i).getIdcompte() %></td>
        <td><%=listeCompte.get(i).getSolde() %></td>
        <td><%=listeCompte.get(i).getDateOuverture() %></td>
        <td><%=listeCompte.get(i).getDecouvert() %></td>
        <td><%=listeCompte.get(i).getTaux() %></td>
       </tr>
    </tbody>
      </table>
</div>

<div class="container">
<div class="col-md-4 col-md-offset-4">
	<h3>Effectuer un virement compte à compte</h3>
  <form method="post" class="form-horizontal" role="form" action="virementServ">
    <div class="form-group">
    <label for="idCompteDepart">Compte depart ID:</label>
      <select class="form-control" name = "idCompteDepart" id="compteDep">
        <option><%=listeCompte.get(i).getIdcompte() %></option>
       </select>
      <br>
       </div>
     <%
    }
	%>
   <div class="form-group">
   
      Compte à crediter ID: <input type="text" class="form-control" id="idCompteArrivee" name="idCompteArrivee" placeholder="Id Compte Arrivée">
    </div>
    <div class="form-group">
      Montant: <input type="text" class="form-control" id="montant" name="montant" placeholder="Montant">
    </div>
    <input type="hidden" id="idcli" name="idcli" value="<%=cl.getIdcli() %>">
    <button type="submit" class="btn btn-default">Virement</button>
  </form>
  </div>
</div>

<center>
	<h3><a href="listeClient.jsp">Retour à la liste client</a></h3></center>
	  
  
 
	  
</body>
</html>