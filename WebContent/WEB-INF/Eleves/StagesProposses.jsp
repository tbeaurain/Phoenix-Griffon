<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Mes stages proposées">
    <meta name="author" content="Phoenix + Griffon">

    <title>JobISEP - Mon stage proposé</title>

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
                        <h1 class="page-header">Mon stage proposé</h1>
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
		                            Récapitulatif du stage créé :
		                        </div>
		                        <div class="panel-body">
		                            <p>Description : <c:out value="${stage.description}"/></p>
		                            <p>Date debut du stage : <c:out value="${stage.dateDebut}"/></p>
		                            <p>Date fin du stage : <c:out value="${stage.dateFin}"/></p>
		                            <p>Adresse du stage : <c:out value="${stage.adresseLieu}"/></p>
		                            <p>Ville du stage : <c:out value="${stage.villeLieu}"/></p>
		                            <p>Code Postal du stage : <c:out value="${stage.codePostalLieu}"/></p>
		                            <p>Nom du service : <c:out value="${stage.nomService}"/></p>
		                            <p>Telephone du lieu du stage : <c:out value="${stage.telephoneStandardLieu}"/></p>
		                            <p>Nom du contact pour la convention : <c:out value="${stage.nomContactConvention}"/></p>
		                            <p>Adresse contact de la convention : <c:out value="${stage.adresseContactConvention}"/></p>
		                            <p>Code postal pour la convention : <c:out value="${stage.codePostalContactConvention}"/></p>
		                            <p>Ville contact pour la convention : <c:out value="${stage.villeContactConvention}"/></p>
		                            <p>Telephone contact pour convention : <c:out value="${stage.telContactConvention}"/></p>
		                            <p>Mail contact convention : <c:out value="${stage.mailContactConvention}"/></p>
		                            <p>Nom du maitre de stage : <c:out value="${stage.nomMaitreStage}"/></p>
		                            <p>Telephone du maitre de stage* : <c:out value="${stage.telephoneMaitreStage}"/></p>
		                            <p>Mail du maitre de stage : <c:out value="${stage.mailMaitreStage}"/></p>
		                            <p>Fonction du maitre de stage : <c:out value="${stage.fonctionMaitreStage}"/></p>
		                            <p>Remuneration : <c:out value="${stage.remuneration}"/></p>
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
	            		Mettre mon stage en attente de validation, mon stage validé.
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
