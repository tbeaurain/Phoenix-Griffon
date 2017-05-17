<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <div class="row">
            	<!-- Colonne vide pour centrer le formulaire sur les grands �crans -->
            	<div class="col-md-1">
        		</div>
        		<!-- /.col-lg-6 -->
                <div class="col-md-8">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Mofifier mes informations g�n�rales</h4>
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
                                				<i>Les champs sont pr�remplis avec les valeurs actuellement stock�es.</i>
                                				<i>Modifiez les valeurs que vous souhaitez puis validez.</i>
                            				</div>
                            				<fieldset disabled>
	                                            <div class="form-group">
	                                                <label for="disabledSelect">login (ne peut �tre modifi�)</label>
	                                                <input class="form-control" id="disabledInput" type="text" placeholder="mon login TODO" disabled>
	                                            </div>
                                            </fieldset>
	                                        <div class="form-group<c:if test="${form.erreurs['titre']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Pr�nom</label>
	                                            <input id="prenom" name="prenom" class="form-control" value="<c:out value="${offre.prenom}"/>">
	                                            <p class="help-block">${form.erreurs['prenom']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['nom']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Nom</label>
	                                            <input id="nom" name="nom" class="form-control" value="<c:out value="${offre.nom}"/>">
	                                            <p class="help-block">${form.erreurs['nom']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['date_naissance']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <div class='input-group date' id='datetimepicker1'>
	                                            	<label>Date de naissance</label>
	                                            	<input id="date_naissance" name="date_naissance" class="form-control" value="<c:out value="${offre.date_naissance}"/>">
	                                            	<span class="input-group-addon">
                        								<span class="glyphicon glyphicon-calendar"></span>
                    								</span>
                    						</div>
	                                            <p class="help-block">${form.erreurs['date_naissance']}</p>
	                                            <script type="text/javascript">
            										$(function () {
                										$('#datetimepicker1').datetimepicker();
            										});
        										</script>
	                                        </div>
	                                        
	                                        
	                                        
	                                    <button type="submit" class="btn btn-primary">Envoyer</button>
	                                    <button type="reset" class="btn btn-default">Remettre � z�ro</button>
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
            <div class="row">
            	<!-- Colonne vide pour centrer le formulaire sur les grands �crans -->
            	<div class="col-md-1">
        		</div>
        		<!-- /.col-lg-6 -->
                <div class="col-md-8">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Modifier mon mot de passe</h4>
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
                                				<i>Les champs sont pr�remplis avec les valeurs actuellement stock�es.</i>
                                				<i>Modifiez les valeurs que vous souhaitez puis validez.</i>
                            				</div>
                            				<fieldset disabled>
	                                            <div class="form-group">
	                                                <label for="disabledSelect">login (ne peut �tre modifi�)</label>
	                                                <input class="form-control" id="disabledInput" type="text" placeholder="mon login TODO" disabled>
	                                            </div>
                                            </fieldset>
	                                        <div class="form-group<c:if test="${form.erreurs['titre']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Pr�nom</label>
	                                            <input id="prenom" name="prenom" class="form-control" value="<c:out value="${offre.prenom}"/>">
	                                            <p class="help-block">${form.erreurs['prenom']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['nom']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Nom</label>
	                                            <input id="prenom" name="prenom" class="form-control" value="<c:out value="${offre.nom}"/>">
	                                            <p class="help-block">${form.erreurs['nom']}</p>
	                                        </div>
	                                        
	                                        
	                                        
	                                    <button type="submit" class="btn btn-primary">Envoyer</button>
	                                    <button type="reset" class="btn btn-default">Remettre � z�ro</button>
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