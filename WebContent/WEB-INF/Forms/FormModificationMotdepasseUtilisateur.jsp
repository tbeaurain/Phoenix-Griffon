<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <div class="row">
            	<!-- Colonne vide pour centrer le formulaire sur les grands écrans -->
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
                                    <form role="form" action="FormModificationMotdepasseUtilisateur" method="POST">
                                    		<div class="alert alert-info alert-dismissable">
                                				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                				<i>Si vous souhaitez changer votre mot de passe, saisissez votre ancien mot de passe, puis choisissez en un nouveau et confirmez le à l'identique.</i>
                            				</div>
	                                        <div class="form-group<c:if test="${form.erreurs['motdepasse']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Ancien mot de passe</label>
	                                            <input type="password" id="motdepasse" name="motdepasse" class="form-control">
	                                            <p class="help-block">${form.erreurs['motdepasse']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['nouveau_motdepasse']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Nouveau mot de passe</label>
	                                            <input type="password" id="nouveau_motdepasse" name="nouveau_motdepasse" class="form-control">
	                                            <p class="help-block">${form.erreurs['nouveau_motdepasse']}</p>
	                                        </div>
	                                        <div class="form-group<c:if test="${form.erreurs['confirmation_motdepasse']!=null}" var="maVariable" scope="session"> has-error</c:if>">
	                                            <label>Confirmation du nouveau mot de passe</label>
	                                            <input type="password" id="confirmation_motdepasse" name="confirmation_motdepasse" class="form-control" >
	                                            <p class="help-block">${form.erreurs['confirmation_motdepasse']}</p>
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