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
                                    <form role="form" action="FormOffre" method="POST">
                                    		<div class="alert alert-info alert-dismissable">
                                				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                				<i>Les champs marqués d'un astérisque sont obligatoires.</i>
                            				</div>
	                                        <div class="form-group<c:if test="${form.erreurs['titre']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Titre*</label>
	                                            <input id="titre" name="titre" class="form-control" value="<c:out value="${offre.titre}"/>">
	                                            <p class="help-block">${form.erreurs['titre']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['description']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Description*</label>
	                                            <textarea id="description" name="description" class="form-control" rows="10"><c:out value="${offre.description}"/></textarea>
	                                        	<p class="help-block">${form.erreurs['descritption']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['lieu']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Lieu*</label>
	                                            <input id="lieu" name="lieu" class="form-control" value="<c:out value="${offre.lieu}"/>">
	                                            <p class="help-block">${form.erreurs['lieu']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['dates']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Dates</label>
	                                            <input id="dates" name="dates" class="form-control" value="<c:out value="${offre.dates}"/>">
	                                            <p class="help-block">${form.erreurs['dates']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['contact']!=null}" var="maVariable" scope="session"> has-error</c:if>" >
	                                            <label>Contact*</label>
	                                            <input id="contact" name="contact" class="form-control" value="<c:out value="${offre.contact}"/>">
	                                            <p class="help-block">${form.erreurs['contact']}</p>
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