<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                                	<c:if test="${form.resultat!=null}" var="maVariable" scope="session">
	                                	<div class="alert alert-warning alert-dismissable">
	                                		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	                                		${form.resultat}
	                            		</div>
                            		</c:if>
                                    <form role="form" action="FormRecherche" method="POST">
	                                        <div class="form-group<c:if test="${form.erreurs['titre']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Titre / mot dans la description</label>
	                                            <input id="titre" name="titre" class="form-control" value="<c:out value="${offre.titre}"/>">
	                                            <p class="help-block">${form.erreurs['titre']}</p>
	                                        </div>
	                                    <button type="submit" class="btn btn-primary">Envoyer</button>
	                                    <button type="reset" class="btn btn-default">Remettre à zéro</button>
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