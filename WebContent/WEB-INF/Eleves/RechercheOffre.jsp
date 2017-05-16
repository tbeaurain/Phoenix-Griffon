<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="org.phoenixgriffon.JobIsep.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

	<head>
	
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="Recherche d'offre de stage">
	    <meta name="author" content="Phoenix + Griffon">
	
	    <title>JobISEP - Recherche d'offre de stage</title>
	
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
	                        <h1 class="page-header">Recherche d'offre de stage</h1>
	                    </div>
	                    <!-- /.col-lg-12 -->
	                </div>
	                <jsp:include page="/WEB-INF/Forms/FormRecherche.jsp"/>   
	            </div>
	            <% if(request.getAttribute("liste_offres")!=null){
	               	ArrayList<Offre> liste = (ArrayList<Offre>) request.getAttribute("liste_offres");
	     	      	for(Offre offre : liste){
		            	out.print("<div class=\"col-md-1\"></div><div class=\"col-md-8\"><div class=\"panel panel-info\"><div class=\"panel-heading\"><h4>" + offre.getTitre() + "</h4></div><div class=\"panel-body\"><div class=\"row\"><div class=\"col-lg-12\">" + offre.getDescription() + "</div></div></div></div></div><hr style=\"clear:both;\">");
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