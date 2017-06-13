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
		                            <div class="table-responsive">
					                	<table class="table table-bordered">
					                      	<tbody>
					                      		<tr>
					                               	<th>Titre</th>
					                                <td>${offre.titre}</td>
					                            </tr>
					                           	<tr>
					                               	<th>Description</th>
					                                <td>${offre.description}</td>
					                            </tr>
					                            <tr>
					                           	<th>Lieu</th>
					                                <td>${offre.lieu}</td>
					                            </tr>
					                            <c:if test="${offre.dates!=null}" var="maVariable" scope="session">
		                            				<tr>
					                    	       		<th>Dates</th>
					                                   	<td>${offre.dates}</td>
					                               	</tr>
		                            			</c:if>
		                            				<tr>
					                                	<th>Contact</th>
					                                    <td>${offre.contact}</td>
					                                </tr>
					                            </tbody>
					                        </table>
				                    	</div>
		                        </div>
		                    </div>
		                    <!-- /.pannel -->
		                </div>
		                <!-- /.col -->
	                </div>
	                <!-- /.row -->
                </c:if>
                <div class="row">
                	<div class="col-lg-1">
                	</div>
                	<div class="col-lg-8">
	                	<c:if test="${afficherOffre==false}" var="maVariable" scope="session">
		                	<div class="alert alert-danger">
		                    Vous n'avez encore proposé aucune offre.
		                    </div>
	                    </c:if>
	                    <c:if test="${afficherOffre==true}" var="maVariable" scope="session">
		                    <c:forEach items="${listeOffres}" var="monOffre">
			                    <div class="panel panel-primary">
	                        		<div class="panel-heading">
	                                ${monOffre.titre}
	                            	</div>
	                            	<div class="panel-body">
										<div class="table-responsive">
					                   		<table class="table table-bordered">
					                        	<tbody>
					                            	<tr>
					                                	<th>Description</th>
					                                    <td>${monOffre.description}</td>
					                                </tr>
					                                <tr>
					                                	<th>Lieu</th>
					                                    <td>${monOffre.lieu}</td>
					                                </tr>
					                                <c:if test="${monOffre.dates!=null}" var="maVariable" scope="session">
		                            					<tr>
					                                		<th>Dates</th>
					                                    	<td>${monOffre.dates}</td>
					                                	</tr>
		                            				</c:if>
		                            				<tr>
					                                	<th>Contact</th>
					                                    <td>${monOffre.contact}</td>
					                                </tr>
					                            </tbody>
					                        </table>
					                        <a href="SupprimerOffre?idOffre=${monOffre.id}"><button type="button" class="btn btn-danger">Supprimer l'offre</button></a>
				                    	</div>
				                   	</div>
				                </div>
							</c:forEach>
	                    </c:if>
	                    
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
