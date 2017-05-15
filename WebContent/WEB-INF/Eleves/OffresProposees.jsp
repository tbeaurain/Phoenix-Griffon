<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Mes offres proposées">
    <meta name="author" content="Phoenix + Griffon">

    <title>JobISEP - Mes Offres Proposées</title>

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
                        <h1 class="page-header">Mes Offres Proposées</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row --> 
                <c:if test="${form.resultat!=null}" var="maVariable" scope="session">
	                <div class="row">
	                	<div class="col-lg-1">
	                	</div>
	                	<div class="col-lg-10">
	                		
		                    	<div class="alert alert-warning alert-dismissable">
		                        	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		                            ${form.resultat}
		                        </div>
	                        
		                    <div class="panel panel-default">
		                        <div class="panel-heading">
		                            Récapitulatif de l'offre créée :
		                        </div>
		                        <div class="panel-body">
		                            <p>Titre : <c:out value="${offre.titre}"/></p>
		                            <p>Description : <c:out value="${offre.description}"/></p>
		                            <p>Lieu : <c:out value="${offre.lieu}"/></p>
		                            <c:if test="${offre.dates!=null}" var="maVariable" scope="session">
		                            	<p>Dates : <c:out value="${offre.dates}"/></p>
		                           	</c:if>
		                            <p>Contact : <c:out value="${offre.contact}"/></p>
		                            <p>Mise en ligne : ...</p>
		                            <p>Créateur : ...</p>
		                        </div>
		                        <div class="panel-footer">
		                            En attente de validation : ...
		                        </div>
		                    </div>
		                    <!-- /.pannel -->
		                </div>
		                <!-- /.col -->
	                </div>
	                <!-- /.row -->
                </c:if>
                <div class="row">
	            	<div class="col-lg-12">
	            		Mettre les offres en attente de validation, les offres validées.
	            		Rajouter la possibilité de supprimer (ou au moins rendre non valide) une offre.
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
