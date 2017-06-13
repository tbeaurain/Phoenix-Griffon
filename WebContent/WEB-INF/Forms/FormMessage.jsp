<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<!-- Colonne vide pour centrer le formulaire sur les grands écrans -->
	<div class="col-md-1"></div>
	<!-- /.col-lg-6 -->
	<div class="col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Nouveau Message:</h4>
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
						<form role="form" action="FormMessage" method="POST">
							<div class="form-group">
								<label>Nom du destinataire</label> <input id="nom_recv"
									name="nom_recv" class="form-control"
									value='<c:out value="${message.nomRecv}"/>'>
								<p class="help-block">${form.erreurs['titre']}</p>
							</div>
							<div class="form-group">
								<label>Prénom du destinataire</label> <input id="prenom_recv"
									name="prenom_recv" class="form-control"
									value='<c:out value="${message.prenomRecv}"/>'>
								<p class="help-block">${form.erreurs['descritption']}</p>
							</div>
							<div class="form-group">
								<label>Objet</label> <input id="objet" name="lieu"
									class="form-control" value='<c:out value="${message.objMsg}"/>'>
								<p class="help-block">${form.erreurs['lieu']}</p>
							</div>
							<div class="form-group">
								<label>Message</label>
								<textarea id="message" name="message" class="form-control"
									rows="10" cols=""><c:out value="${message.msg}" /></textarea>

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