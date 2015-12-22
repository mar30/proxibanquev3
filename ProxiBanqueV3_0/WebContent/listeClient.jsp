<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.gtm.proxibanquev2.metier.User"%>
    <%@ page import="fr.gtm.proxibanquev2.metier.Conseiller"%>
    <%@ page import="fr.gtm.proxibanquev2.service.ConseillerService"%>
    <%@ page import="fr.gtm.proxibanquev2.service.ClientService"%>
    <%@ page import="fr.gtm.proxibanquev2.service.CompteService"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Clients</title>
<link href="bootstrap-3.3.6-dist/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="bootstrap-3.3.6-dist/bootstrap-3.3.6-dist/3.3.5/js/bootstrap.min.js"></script>
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
      Conseiller cn = (Conseiller) session.getAttribute("conseiller");
      
      ClientService cliServ = (ClientService) session.getAttribute("cliServ");
      
      CompteService compteServ = (CompteService) session.getAttribute("compteServ");
	%>
	
	<div class="container">
  <h2>Liste Client du Conseiller <c:out value="${sessionScope.conseiller.nom}"/> :</h2>           
  <table class="table">
    <thead>
      <tr>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Adresse</th>
        <th>Code Postal</th>
        <th>Ville</th>
        <th>Téléphone</th>
        <th>Email</th>
        <th></th>
      </tr>
    </thead>
    <%
    
    for (int i=0; i<=cliServ.findAllClientCn(cn.getIdCn()).size()-1;i++) {
    	
	%>
    <tbody>
      <tr>
        <td><%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getPrenom()%></td>
        <td><%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getNom()%></td>
        <td><%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getAdresse()%></td>
        <td><%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getCodePostal()%></td>
        <td><%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getVille()%></td>
        <td><%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getTel()%></td>
        <td><%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getEmail()%></td>
        <td>
        
        <form action="modifClientserv" method="post">
        <input type="hidden" name="idcli" value="<%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getIdcli()%>">
        <button type="submit" class="btn btn-warning">Modifier</button>
        </form>
        
        </td>
        <td>
        
        <form action="gestionCompteserv" method="post">
        <input type="hidden" name="idcli" value="<%=cliServ.findAllClientCn(cn.getIdCn()).get(i).getIdcli()%>">
        <button type="submit" class="btn btn-danger">Voir Comptes</button>
        </form>
        
        </td>
             </tr>
    </tbody>
    <%
    }
	%>
  </table>
</div>
	  
</body>
</html>