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
        </div>
        	<c:if test="${typeUtilisateur==1}" var="maVariable" scope="session">
        		<jsp:include page="/WEB-INF/Eleves/BarreNavigationEleve.jsp"/>
            </c:if>
            <c:if test="${typeUtilisateur==2}" var="maVariable" scope="session">
        		<jsp:include page="/WEB-INF/Admin/BarreNavigationAdmin.jsp"/>
            </c:if>
 
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                	<div class="col-lg-1">
                	</div>
                    <div class="col-lg-8">
                        <h1 class="page-header">Mon profil</h1>
                    </div>
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
                            	<!-- /.table-responsive -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.pannel primary -->
                    </div>
                    <!-- /.col-lg-8 -->
                </div>   
            	<!-- /.row -->
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