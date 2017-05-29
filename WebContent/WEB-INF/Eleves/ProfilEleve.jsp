<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Mon profil">
    <meta name="author" content="Phoenix + Griffon">

    <title>JobISEP - Mon profil</title>

    <!-- Bootstrap Core CSS -->
    <jsp:include page="/WEB-INF/Commun/IncludeCSS.jsp"/>

</head>

<body>

    <div id="wrapper">

        <!-- Barre de navigation -->
        <jsp:include page="/WEB-INF/Eleves/BarreNavigationEleve.jsp"/>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Mon profil</h1>
                        <p>ID : ${utilisateur.id}</p>
                        <p>Prénom : ${utilisateur.prenom}</p>
                        <p>Nom : ${utilisateur.nom} </p>
                        <p>Date de naissance : ${utilisateur.dateNaissance} </p>
                        <p>Identifiant : ${utilisateur.identifiant} </p>
                        <p>Mot de passe : ${utilisateur.motdepasse} </p>
                        <p>Statut utilisateur : ${utilisateur.statutUtilisateur.libelle}  </p>              
                    </div>
                    <!-- /.col-lg-12 -->
                </div>   
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <jsp:include page="/WEB-INF/Commun/IncludeJS.jsp"/>

</body>

</html>
