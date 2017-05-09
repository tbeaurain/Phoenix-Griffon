<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-header">
    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        	<span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="AccueilAdmin">KAZI-AOUL Zakia</a>
	</div>
	<img src="<c:url value="/Images/LogoJobIsep2.png"/>" class="nav navbar-top-links navbar-right" style="width: 5em; height: 3em; padding-top:1em;margin-right:1em">	
        <div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="AccueilAdmin"><i class="fa fa-home fa-fw"></i> Accueil</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Suivit des élèves<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="SuiviEleve">Elèves sans stage</a>
                                </li>
                                <li>
                                    <a href="ValidationEleve">Demande de validation en attente</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-list-alt fa-fw"></i> Les offres<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="ProposerOffre">Proposer une offre</a>
                                </li>
                                <li>
                                    <a href="ValidationOffre">Validation d'offre pour le parcours</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-envelope fa-fw"></i> Messageries<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="EcrireMessageAdmin">Envoyer un message</a>
                                </li>
                                <li>
                                    <a href="BoiteReceptionAdmin">Boite de reception</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li class="active">
                            <a href="ProfilAdmin"><i class="fa fa-user fa-fw"></i> Mon profil</a>
                        </li>
                        <li class="active">
                            <a href="Deconnexion"><i class="fa fa-sign-out fa-fw"></i> Déconnexion</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
	</div>
</nav>
