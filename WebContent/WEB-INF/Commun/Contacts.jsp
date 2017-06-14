<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*"%>
<%@ page import="org.phoenixgriffon.JobIsep.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

	<head>
	
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="Recherche de contact">
	    <meta name="author" content="Phoenix + Griffon">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
	    <title>JobISEP - Recherche de contact</title>

	    <!-- Bootstrap Core CSS -->
	    <jsp:include page="/WEB-INF/Commun/IncludeCSS.jsp"/>
	</head>
	
	<body>
	
	    <div id="wrapper">
	
	        <!-- Barre de navigation -->
	        <jsp:include page="/WEB-INF/Eleves/BarreNavigationEleve.jsp"/>
	
	        <!-- Page Content -->
	        <div id="page-wrapper">
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-lg-12">
	                        <h1 class="page-header">Recherche de contact</h1>
	                    </div>
	                    <!-- /.col-lg-12 -->
	                </div>
	             <jsp:include page="/WEB-INF/Forms/FormContact.jsp"/>   
	            </div>
	            <% if(request.getAttribute("liste_utilisateurs")!=null){
	            	
	            	System.out.println("ok");
		               	ArrayList<Utilisateur> liste = (ArrayList<Utilisateur>) request.getAttribute("liste_utilisateurs");
		               	if(liste.size()!=0){
			     	      	for(Utilisateur utilisateur : liste){
			     	      		out.print("<div class=\"col-md-1\"></div><div class=\"col-md-8\"><div class=\"panel panel-info\"><div class=\"panel-heading\"><h4> Voici le contact : " + utilisateur.getNom() + " </h4></div><div class=\"panel-body\"><div class=\"row\"><div class=\"col-lg-12\"> Le nom du contact est " + utilisateur.getNom() + " et son prenom est " + utilisateur.getPrenom() +"<br><a href=\"ProfilEleve?id=" + utilisateur.getId() +"\">Voir le contact</a>" +  "</div></div></div></div></div><hr style=\"clear:both;\">");
			               
			               	}
		               	}
		               	else {
			           		out.print("<div class=\"col-md-1\"></div><div class=\"col-md-8\"><h2 style=\"color:red\">Pas de résultat...</h2></div>");
		               	}
		           	} %>
	            <!-- /.container-fluid -->
	        </div>
	        <!-- /#page-wrapper -->
	    </div>
	    <!-- /#wrapper -->
	
	    <!-- jQuery -->
	    <jsp:include page="/WEB-INF/Commun/IncludeJS.jsp"/>
	</body>
</html>x	