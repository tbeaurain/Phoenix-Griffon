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
	        				<h1 class="page-header">Contenu de l'offre :</h1>
	        				
	        			</div>
	        		</div>
	        		<div class="row">
	        			<div class="col-lg-1">
	        			</div>
	        			<div class="col-lg-8">
	        				<c:if test="${offreExiste==false}" var="maVariable" scope="session">
	        					<div class="alert alert-danger ">
		                        	Désolé. Il semble que l'offre demandée n'existe pas.
		                        </div>
	        				</c:if>
	        				<c:if test="${offreExiste==true}" var="maVariable" scope="session">
	        					<div class="panel panel-primary">
			                        <div class="panel-heading">
			                            <h4>${offre.titre}</h4>
			                        </div>
			                        <div class="panel-body">
			                            <div class="table-responsive">
						                	<table class="table table-bordered">
						                      	<tbody>
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
						                        </tbody>
						                    </table>
						                </div>
						            </div>
						        </div>
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