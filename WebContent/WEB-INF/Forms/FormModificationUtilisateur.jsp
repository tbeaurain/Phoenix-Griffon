<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <div class="row">
            	<!-- Colonne vide pour centrer le formulaire sur les grands écrans -->
            	<div class="col-md-1">
        		</div>
        		<!-- /.col-lg-6 -->
                <div class="col-md-8">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Modifier mes informations générales</h4>
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
                                    <form role="form" action="FormModificationUtilisateur" method="POST">
                                    		<div class="alert alert-info alert-dismissable">
                                				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                				<i>Les champs sont préremplis avec les valeurs actuellement stockées.</i>
                                				<i>Modifiez les valeurs que vous souhaitez puis validez.</i>
                            				</div>
                            				<fieldset disabled>
	                                            <div class="form-group">
	                                                <label for="disabledSelect">login (ne peut être modifié)</label>
	                                                <input class="form-control" id="disabledInput" type="text" placeholder="mon login TODO" disabled>
	                                            </div>
                                            </fieldset>
	                                        <div class="form-group<c:if test="${form.erreurs['prenom']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Prénom*</label>
	                                            <input id="prenom" name="prenom" class="form-control" value="<c:out value="${utilisateur.prenom}"/>">
	                                            <p class="help-block">${form.erreurs['prenom']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['nom']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Nom*</label>
	                                            <input id="nom" name="nom" class="form-control" value="<c:out value="${utilisateur.nom}"/>">
	                                            <p class="help-block">${form.erreurs['nom']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['dateNaissance']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Date de naissance (jj/mm/aaaa)</label>
	                                            <div class='input-group date'>
	                                            	<input type="date" id="dateNaissance" name="dateNaissance" class="form-control" value="<c:out value="${utilisateur.dateNaissance}"/>">
                    								<div class="input-group-addon">
         												<i class="fa fa-calendar"></i>
        											</div>
                    							</div>
	                                            <p class="help-block">${form.erreurs['dateNaissance']}</p>
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
            