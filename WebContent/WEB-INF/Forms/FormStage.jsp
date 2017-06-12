<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<!-- Colonne vide pour centrer le formulaire sur les grands écrans -->
	<div class="col-md-1"></div>
	<!-- /.col-lg-6 -->
	<div class="col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Informations relatives à la convention de stage :</h4>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-12">
						<c:if test="${form.resultat!=null}" var="maVariable"
							scope="session">
							<div class="alert alert-warning alert-dismissable">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								${form.resultat}
							</div>
						</c:if>
						<form role="form" action="FormStage" method="POST">
							<div class="alert alert-info alert-dismissable">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								<i>Les champs marqués d'un astérisque sont obligatoires.</i>
							</div>
							<div class="alert alert-info alert-dismissable">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								<i>Modifier une convention validée entrainera une nouvelle demande de validation.</i>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['description']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Description*</label>
								<textarea id="description" name="description"
									class="form-control" rows="10"><c:out
										value="${stage.description}" /></textarea>
								<p class="help-block">${form.erreurs['description']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['dateDebut']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Date debut du stage*</label> <input id="dateDebut"
									name="dateDebut" class="form-control" type = "date"
									value="<c:out value="${stage.dateDebut}"/>">
								<p class="help-block">${form.erreurs['dateDebut']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['dateFin']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Date fin du stage*</label> <input id="dateFin"
									name="dateFin" class="form-control" type = "date"
									value="<c:out value="${stage.dateFin}"/>">
								<p class="help-block">${form.erreurs['dateFin']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['adresseLieu']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Adresse du stage*</label> <input id="adresseLieu"
									name="adresseLieu" class="form-control"
									value="<c:out value="${stage.adresseLieu}"/>">
								<p class="help-block">${form.erreurs['adresseLieu']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['villeLieu']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Ville du stage</label> <input id="villeLieu"
									name="villeLieu" class="form-control"
									value="<c:out value="${stage.villeLieu}"/>">
								<p class="help-block">${form.erreurs['villeLieu']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['codePostalLieu']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Code Postal du stage</label> <input id="codePostalLieu"
									name="codePostalLieu" class="form-control"
									value="<c:out value="${stage.codePostalLieu}"/>">
								<p class="help-block">${form.erreurs['codePostalLieu']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['nomService']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Nom du service*</label> <input id="nomService"
									name="nomService" class="form-control"
									value="<c:out value="${stage.nomService}"/>">
								<p class="help-block">${form.erreurs['nomService']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['telephoneStandardLieu']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Telephone du lieu du stage</label> <input
									id="telephoneStandardLieu" name="telephoneStandardLieu"
									class="form-control" type="tel"
									value="<c:out value="${stage.telephoneStandardLieu}"/>">
								<p class="help-block">${form.erreurs['telephoneStandardLieu']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['nomContactConvention']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Nom du contact pour la convention*</label> <input
									id="nomContactConvention" name="nomContactConvention"
									class="form-control"
									value="<c:out value="${stage.nomContactConvention}"/>">
								<p class="help-block">${form.erreurs['nomContactConvention']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['adresseContactConvention']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Adresse contact de la convention</label> <input
									id="adresseContactConvention" name="adresseContactConvention"
									class="form-control"
									value="<c:out value="${stage.adresseContactConvention}"/>">
								<p class="help-block">${form.erreurs['adresseContactConvention']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['codePostalContactConvention']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Code postal pour la convention</label> <input
									id="codePostalContactConvention"
									name="codePostalContactConvention" class="form-control"
									value="<c:out value="${stage.codePostalContactConvention}"/>">
								<p class="help-block">${form.erreurs['codePostalContactConvention']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['villeContactConvention']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Ville contact pour la convention*</label> <input
									id="villeContactConvention" name="villeContactConvention"
									class="form-control"
									value="<c:out value="${stage.villeContactConvention}"/>">
								<p class="help-block">${form.erreurs['villeContactConvention']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['CodePostalLieu']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Telephone contact pour convention*</label> <input
									id="telContactConvention" name="telContactConvention"
									class="form-control" type="tel"
									value="<c:out value="${stage.telContactConvention}"/>">
								<p class="help-block">${form.erreurs['telContactConvention']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['mailContactConvention']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Mail contact convention*</label> <input
									id="mailContactConvention" name="mailContactConvention"
									class="form-control" type="email"
									value="<c:out value="${stage.mailContactConvention}"/>">
								<p class="help-block">${form.erreurs['mailContactConvention']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['nomMaitreStage']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Nom du maitre de stage*</label> <input
									id="nomMaitreStage" name="nomMaitreStage" class="form-control"
									value="<c:out value="${stage.nomMaitreStage}"/>">
								<p class="help-block">${form.erreurs['nomMaitreStage']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['telephoneMaitreStage']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Telephone du maitre de stage*</label> <input
									id="telephoneMaitreStage" name="telephoneMaitreStage"
									class="form-control" type="tel"
									value="<c:out value="${stage.telephoneMaitreStage}"/>">
								<p class="help-block">${form.erreurs['telephoneMaitreStage']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['mailMaitreStage']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Mail du maitre de stage*</label> <input
									id="mailMaitreStage" name="mailMaitreStage"
									class="form-control" type="email"
									value="<c:out value="${stage.mailMaitreStage}"/>">
								<p class="help-block">${form.erreurs['mailMaitreStage']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['fonctionMaitreStage']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Fonction du maitre de stage*</label> <input
									id="fonctionMaitreStage" name="fonctionMaitreStage"
									class="form-control"
									value="<c:out value="${stage.fonctionMaitreStage}"/>">
								<p class="help-block">${form.erreurs['fonctionMaitreStage']}</p>
							</div>

							<div
								class="form-group<c:if test="${form.erreurs['remuneration']!=null}" var="maVariable" scope="session"> has-error</c:if>">
								<label>Remuneration</label> <input id="remuneration"
									name="nomMaitreStage" class="form-control" type = 'number'
									value="<c:out value="${stage.remuneration}"/>">
								<p class="help-block">${form.erreurs['remuneration']}</p>
							</div>

							<button type="submit" class="btn btn-primary">Envoyer</button>
							<button type="reset" class="btn btn-default">Remettre à
								zéro</button>
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