<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*"%>
<%@ page import="org.phoenixgriffon.JobIsep.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

	<head>
	
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="Recherche d'offre de stage">
	    <meta name="author" content="Phoenix + Griffon">
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
	    <title>JobISEP - Recherche d'offre de stage</title>

	    <!-- Bootstrap Core CSS -->
	    <jsp:include page="/WEB-INF/Commun/IncludeCSS.jsp"/>
	</head>
	
	<body>
	
	    <div id="wrapper">
	
	        <!-- Barre de navigation -->
	        <c:if test="${typeUtilisateur==1}" var="maVariable" scope="session">
        		<jsp:include page="/WEB-INF/Eleves/BarreNavigationEleve.jsp"/>
            </c:if>
            <c:if test="${typeUtilisateur==2}" var="maVariable" scope="session">
        		<jsp:include page="/WEB-INF/Admin/BarreNavigationAdmin.jsp"/>
            </c:if>
	
	        <!-- Page Content -->
	        <div id="page-wrapper">
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-lg-12">
	                        <h1 class="page-header">Recherche d'offre de stage</h1>
	                    </div>
	                    <!-- /.col-lg-12 -->
	                </div>
	                <jsp:include page="/WEB-INF/Forms/FormRecherche.jsp"/>   
	            </div>
	            <% if(request.getAttribute("liste_offres")!=null){
		               	ArrayList<Offre> liste = (ArrayList<Offre>) request.getAttribute("liste_offres");
		               	if(liste.size()!=0){
			               	System.out.println("test de récup pour voir ce que donne la liste : " + liste.get(0).getLieu());
			     	      	for(Offre offre : liste){
			     	      		String description_short = offre.getDescription();
			     	      		try {
				     	      		description_short = offre.getDescription().substring(0, 230) + "...";
			     	      		} catch (IndexOutOfBoundsException e){}
			     	      		out.print("<div class=\"col-md-1\"></div><div class=\"col-md-8\"><div class=\"panel panel-info\"><div class=\"panel-heading\"><h4>" + offre.getTitre() + "</h4></div><div class=\"panel-body\"><div class=\"row\"><div class=\"col-lg-12\">" + description_short + "<br><a href=\"AffichageOffre?id=" + offre.getId() +"\">Voir l'offre</a>" +  "</div></div></div></div></div><hr style=\"clear:both;\">");
			               	}
		               	}
		               	else {
			           		out.print("<div class=\"col-md-1\"></div><div class=\"col-md-8\"><h2 style=\"color:red\">Pas de résultat...</h2></div>");
		               	}
		           	} %>
	            <!-- /.container-fluid -->
	        </div>
	        <!-- /#page-wrapper -->
	    </div>
	    <!-- /#wrapper -->
	
	    <!-- jQuery -->
	    <jsp:include page="/WEB-INF/Commun/IncludeJS.jsp"/>
	</body>
</html>