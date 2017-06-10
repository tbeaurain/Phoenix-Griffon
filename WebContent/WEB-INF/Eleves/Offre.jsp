<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="org.phoenixgriffon.JobIsep.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

	<head>
	
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="Recherche d'offre de stage">
	    <meta name="author" content="Phoenix + Griffon">
	
	    <title>JobISEP - Recherche d'offre de stage</title>
	
	    <!-- Bootstrap Core CSS -->
	    <jsp:include page="/WEB-INF/Commun/IncludeCSS.jsp"/>
	    
	</head>
	
	<body>
	
	    <div id="wrapper">
	
	        <!-- Barre de navigation -->
	        <jsp:include page="/WEB-INF/Eleves/BarreNavigationEleve.jsp"/>
	
	        <!-- Page Content -->
	        <div id="page-wrapper">
	            <% if(request.getAttribute("offre")!=null){
	               	Offre offre = (Offre) request.getAttribute("offre");
	               	Utilisateur user = (Utilisateur) request.getAttribute("utilisateur");
	            	out.print("<div class=\"col-md-1\"></div><div class=\"col-md-8\"><div class=\"panel panel-info\"><div class=\"panel-heading\"><h4>" + offre.getTitre() + "</h4></div><div class=\"panel-body\"><div class=\"row\"><div class=\"col-lg-12\"> Date / durée : " + offre.getDates() + "<br>Mis en ligne le : " + offre.getMiseEnLigne() + "</div><div class=\"col-lg-12\">Lieu : " + offre.getLieu() + "</div><br><div class=\"col-lg-12\">Offre proposée par : " + user.getPrenom() + " " + user.getNom() + "   /   " + user.getIdentifiant() + "</div><div class=\"col-lg-12\">" + offre.getDescription() + "</div></div></div></div></div><hr style=\"clear:both;\">");
	           	} else {
	           		out.print("Erreur, veuillez retourner sur une autre page...");
	           	}%>
	            <!-- /.container-fluid -->
	        </div>
	        <!-- /#page-wrapper -->
	    </div>
	    <!-- /#wrapper -->
	
	    <!-- jQuery -->
	    <jsp:include page="/WEB-INF/Commun/IncludeJS.jsp"/>
	</body>
</html>