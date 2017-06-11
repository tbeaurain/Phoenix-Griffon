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
                                Ma convention de stage
                            </div>
                            <div class="panel-body">
                            	<div class="table-responsive">
	                                <table class="table table-bordered">
	                                    <tbody>
	                                    	<tr>
	                                            <th>Description</th>
	                                            <td>${stage.description}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Date de début du stage</th>
	                                            <td>${stage.date_debut}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Date de fin du stage</th>
	                                            <td>${stage.date_fin}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Adresse du stage</th>
	                                            <td>${stage.adresse_lieu}, ${stage.code_postal_lieu} ${stage.ville_lieu}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Nom du service</th>
	                                            <td>${stage.nom_service}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Nom du service</th>
	                                            <td>${stage.nom_service}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Téléphone lieu du stage</th>
	                                            <td>${stage.telephone_standard_lieu}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Contact pour la convention</th>
	                                            <td>${stage.nom_contact_convention}, ${stage.mail_contact_convention}, ${stage.tel_contact_convention}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Adresse du contact pour la convention</th>
	                                            <td>${stage.adresse_contact_convention}, ${stage.code_postal_contact_convention} ${stage.ville_contact_convention}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Nom du maitre de stage</th>
	                                            <td>${stage.nom_maitre_stage}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Nom du maitre de stage</th>
	                                            <td>${stage.nom_maitre_stage}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Fonction du maitre de stage</th>
	                                            <td>${stage.fonction_maitre_stage}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Contact maitre du stage</th>
	                                            <td>${stage.telephone_maitre_stage}, ${mail.telephone_maitre_stage}</td>
	                                        </tr>
	                                        <tr>
	                                            <th>Rémunération</th>
	                                            <td>${stage.remuneration}</td>
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