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

    <title>JobISEP - Ma Convention de stage</title>

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
                	<div class="col-lg-1">
                	</div>
                    <div class="col-lg-8">
                        <h1 class="page-header">Ma convention de stage</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-1">
                    </div>
                    <div class="col-lg-8">
                        <div class="panel panel-primary">
                        	<div class="panel-heading">
                                Informations contenues dans votre convention de stage
                            </div>
                            <div class="panel-body">
                            	<c:if test="${messageErreur!=''}" var="maVariable" scope="session">
	                               	<div class="alert alert-danger alert-dismissable">
	                               		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	                               		${messageErreur}
	                            	</div>
                            	</c:if>
                            	
                            	<c:if test="${erreur==false}" var="maVariable" scope="session">
                            		<c:if test="${stage_valide_flag==true}" var="maVariable" scope="session">
	                               		<div class="alert alert-success">
	                               			Votre convention a bien été validée.
	                            		</div>
                            		</c:if>
                            		<c:if test="${stage_valide_flag==false}" var="maVariable" scope="session">
	                               		<div class="alert alert-danger">
	                               			Votre convention de stage est en attente de validation.
	                            		</div>
                            		</c:if>
	                            	<div class="table-responsive">
		                                <table class="table table-bordered">
		                                    <tbody>
		                                    	<tr>
		                                            <th>Description</th>
		                                            <td>${stage.description}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Date de début du stage</th>
		                                            <td>${stage.dateDebut}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Date de fin du stage</th>
		                                            <td>${stage.dateFin}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Adresse du stage</th>
		                                            <td>${stage.adresseLieu}, ${stage.codePostalLieu} ${stage.villeLieu}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Nom du service</th>
		                                            <td>${stage.nomService}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Téléphone lieu du stage</th>
		                                            <td>${stage.telephoneStandardLieu}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Contact pour la convention</th>
		                                            <td>${stage.nomContactConvention}, ${stage.mailContactConvention}, ${stage.telContactConvention}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Adresse du contact pour la convention</th>
		                                            <td>${stage.adresseContactConvention}, ${stage.codePostalContactConvention} ${stage.villeContactConvention}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Nom du maitre de stage</th>
		                                            <td>${stage.nomMaitreStage}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Nom du maitre de stage</th>
		                                            <td>${stage.nomMaitreStage}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Fonction du maitre de stage</th>
		                                            <td>${stage.fonctionMaitreStage}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Contact maitre de stage</th>
		                                            <td>${stage.telephoneMaitreStage}, ${stage.mailMaitreStage}</td>
		                                        </tr>
		                                        <tr>
		                                            <th>Rémunération</th>
		                                            <td>${stage.remuneration}</td>
		                                        </tr>
		                                    </tbody>
		                                </table>
	                            	</div>
	                            	<!-- /.table-responsive -->
	                            </c:if>
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