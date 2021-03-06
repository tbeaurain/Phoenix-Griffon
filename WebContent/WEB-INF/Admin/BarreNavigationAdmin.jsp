<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; position:fixed;">
	<div class="navbar-header">
    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        	<span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="AccueilAdmin">${sessionScope.sessionUtilisateur.prenom} ${sessionScope.sessionUtilisateur.nom}</a>
	</div>
	<img src="<c:url value="/Images/LogoJobIsep2.png"/>" class="nav navbar-top-links navbar-right" style="width: 5em; height: 3em; padding-top:1em;margin-right:1em">	
        <div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					
                        <li><a href="AccueilAdmin"><i class="fa fa-home fa-fw"></i> Accueil</a></li>
                        <li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Suivi des élèves<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="RechercheEleveSansStage"><i class="fa fa-search"></i>Elèves sans stage</a></li>
                            </ul>
                        </li>
                        <li><a href="#"><i class="fa fa-list-alt fa-fw"></i>Conventions de stage<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="ConventionAValider"><i class="fa fa-search"></i>Conventions en attente de validation</a></li>
								<li><a href="RechercheConvention"><i class="fa fa-search"></i>Rechercher une convention par élève</a></li>
                            </ul>
                        </li>
                        <li><a href="#"><i class="fa fa-list-alt fa-fw"></i>Les Offres<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="RechercheOffre"><i class="fa fa-search"></i>Rechercher une offre</a></li>
								<li><a href="OffresProposees"><i class="fa fa-list-ul fa-fw"></i> Mes offres Proposées</a></li>
								<li><a href="PropositionOffre"><i class="fa fa-plus-circle fa-fw"></i> Proposer une offre</a></li>
							</ul>
						</li>
                        <li><a href="Contacts"><i class="fa fa-users fa-fw"></i>Chercher un contact</a></li>
                        <li><a href="EcrireMessage"><i class="fa fa-envelope fa-fw"></i>Envoyer un message</a></li>
                        <li><a href="#"><i class="fa fa fa-user fa-fw fa-fw"></i>Profil<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="Profil"><i class="fa fa-user fa-fw"></i>Voir mon profil</a></li>
								<li><a href="ModifierProfil"><i class="fa fa-pencil fa-fw"></i> Modifier mon profil</a></li>
								<li><a href="ModifierMotdepasse"><i class="fa fa-key fa-fw"></i> Modifier mon mot de passe</a></li>
							</ul> <!-- /.nav-second-level -->
						</li>
                        <li class="active"><a href="Deconnexion"><i class="fa fa-sign-out fa-fw"></i> Déconnexion</a></li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
	</div>
</nav>
