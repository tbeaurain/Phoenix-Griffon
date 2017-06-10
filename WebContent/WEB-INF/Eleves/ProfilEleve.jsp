<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.phoenixgriffon.JobIsep.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Mon profil">
    <meta name="author" content="Phoenix + Griffon">

    <title>JobISEP - Mon profil</title>

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
                	<div class="col-lg-1"></div>
                    <div class="col-lg-8">
                    <% if(request.getAttribute("utilisateurID")!=null){
		               	Utilisateur user = (Utilisateur) request.getAttribute("utilisateurID");
		               	int Session = 2;
		               	if(user.getId()==Session)
			               	out.print("<div class=\"col-lg-12\"><h1 class=\"page-header:\">Mon profil</h1></div>");
		               	else
		               		out.print("<div class=\"col-lg-12\"><h1 class=\"page-header:\">Identifiant : " + user.getIdentifiant() + "</h1></div>");
		               	out.print("<div class=\"col-md-1\"></div>");
		               	out.print("<div class=\"col-md-8\">");
		               	out.print("<div class=\"panel panel-info\">");
		               	out.print("<div class=\"panel-body\"><div class=\"row\">");
		               	out.print("<div class=\"col-lg-12\"><h2>Prénom : " + user.getPrenom() + "</h2></div>");
		               	out.print("<div class=\"col-lg-12\"><h2>Nom : " + user.getNom() + "</h2></div>");
		               	//TODO récupérer le libéllé élève sur la table statut utilisateur
		               	out.print("<div class=\"col-lg-12\"><h2>Date de naissance : " + user.getDateNaissance() + "</h2></div>");
		               	out.print("</div></div></div></div><hr style=\"clear:both;\">");
		               } %>
                    
                    </div>
                    <div class="col-lg-12">
                        <h1 class="page-header">Mon profil</h1>
                    </div>
                <c:if test="${form.resultat!=null}" var="maVariable" scope="session">
	                <div class="row">
	                	<div class="col-lg-1">
	                	</div>
	                	<div class="col-lg-8">
	                		
		                    	<div class="alert alert-warning alert-dismissable">
		                        	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		                            ${form.resultat}
		                        </div>
		                </div>
		                <!-- /.col -->
	                </div>
	                <!-- /.row -->
                </c:if>
                <div class="row">
                    <div class="col-lg-1">
                    </div>
                    	<div class="col-lg-8">
                        <div class="panel panel-primary">
                        	<div class="panel-heading">
                                Informations générales sur mon profil
                            </div>
                            <div class="panel-body">
                            	<div class="table-responsive">
	                                <table class="table table-bordered">
	                                    <tbody>
	                                    	<tr>
	                                            <th>Nom</th>
	                                            <td>${utilisateur.nom}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Prénom</th>
	                                            <td>${utilisateur.prenom}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Date de naissance</th>
	                                            <td>${utilisateur.dateNaissance}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Identifiant</th>
	                                            <td>${utilisateur.identifiant}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Statut utilisateur</th>
	                                            <td>${utilisateur.statutUtilisateur.libelle}</td>
	                                        </tr>
	                                    </tbody>
	                                </table>
                            	</div>
                            </div>
                        </div>
                    </div>
                </div>   
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <jsp:include page="/WEB-INF/Commun/IncludeJS.jsp"/>

</body>

</html>
