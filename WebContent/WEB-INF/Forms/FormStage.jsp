<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Proposition de stage - Eleve</title>

    <!-- Bootstrap Core CSS -->
    <jsp:include page="/WEB-INF/Commun/IncludeCSS.jsp"/>

</head>

<body>

    <div id="wrapper">

		<jsp:include page="/WEB-INF/Eleves/BarreNavigationEleve.jsp"/>    
	        
        <!-- Page Content -->
        <div id="page-wrapper">
        		
            <div class="row">
            	<!-- Colonne vide pour centrer le titre sur les grands écrans -->
            	<div class="col-md-1">
        		</div>
        		<!-- /.col-lg-6 -->
                <div class="col-md-8">
                    <h1 class="page-header">Proposez une offre de stage :</h1>
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
            <div class="row">
            	<!-- Colonne vide pour centrer le formulaire sur les grands écrans -->
            	<div class="col-md-1">
        		</div>
        		<!-- /.col-lg-6 -->
                <div class="col-md-8">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Informations relatives à l'offre proposée :</h4>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form role="form" action="FormStage" method="POST">
                                    		<div class="alert alert-info alert-dismissable">
                                				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                				<i>Les champs marqués d'un astérisque sont obligatoires.</i>
                            				</div>
	                                        <div class="form-group<c:if test="${form.erreurs['titre']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Titre*</label>
	                                            <input id="titre" name="titre" class="form-control" value="<c:out value="${stage.titre}"/>">
	                                            <p class="help-block">${form.erreurs['titre']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['description']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Description*</label>
	                                            <textarea id="description" name="description" class="form-control" rows="10" value="<c:out value="${stage.description}"/>"></textarea>
	                                        	<p class="help-block">${form.erreurs['descritption']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['lieu']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Lieu*</label>
	                                            <input id="lieu" name="lieu" class="form-control" value="<c:out value="${stage.lieu}"/>">
	                                            <p class="help-block">${form.erreurs['lieu']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['dates']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Dates</label>
	                                            <input id="dates" name="dates" class="form-control" value="<c:out value="${stage.dates}"/>">
	                                            <p class="help-block">${form.erreurs['dates']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['contact']!=null}" var="maVariable" scope="session"> has-error</c:if>" >
	                                            <label>Contact*</label>
	                                            <input id="contact" name="contact" class="form-control" value="<c:out value="${stage.contact}"/>">
	                                            <p class="help-block">${form.erreurs['contact']}</p>
	                                        </div>
	                                    <button type="submit" class="btn btn-primary">Submit Button</button>
	                                    <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 -->
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <jsp:include page="/WEB-INF/Commun/IncludeJS.jsp"/>

</body>

</html>