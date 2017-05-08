<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="AccueilEleve">JobISEP</a>
	</div>

	<!-- /.navbar-header -->



	<!-- Barre de navigation------------------------------------------- -->
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">

				<!-- Barre de recherche-->
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control"
							placeholder="Recherche rapide..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div> <!-- /input-group -->
				</li>
				<li><a href="AccueilEleve"><i
						class="fa fa-home fa-fw"></i> Accueil</a></li>
				<li>
					<!-- mettre class="active" si on veut que l'onglet soit d�pi� d�s le d�but-->
					<a href="#"><i class="fa fa-newspaper-o fa-fw"></i> Offres de
						stage<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="RechercheOffre"><i
								class="fa fa-search"></i> Rechercher une offre</a></li>
						<li><a href="OffresFavorites"><i
								class="fa fa-heart fa-fw"></i> Mes offres favorites</a></li>
						<li><a href="PropositionOffre"><i
								class="fa fa-plus-circle fa-fw"></i> Proposer une offre</a></li>
					</ul> <!-- /.nav-second-level -->
				</li>
				<li><a href="Convention"><i class="fa fa-edit fa-fw"></i>
						Ma convention de stage</a></li>
				<li><a href="Contacts"><i class="fa fa-users fa-fw"></i>
						Chercher un contact</a></li>
				<li><a href="#"><i class="fa fa-envelope fa-fw"></i>
						Messages<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="EcrireMessageEleve"><i
								class="fa fa-pencil"></i> Ecrire un message</a></li>
						<li><a href="BoiteReceptionEleve"><i class="fa fa-inbox fa-fw"></i>
								Boite de réception</a></li>
					</ul> <!-- /.nav-second-level --></li>
				<li><a href="ProfilEleve"><i class="fa fa-user fa-fw"></i>
						Mon profil</a></li>
				<li><a href="Deconnexion"><i
						class="fa fa-sign-out fa-fw"></i> Se déconnecter</a></li>

			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>