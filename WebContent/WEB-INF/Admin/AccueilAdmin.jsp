<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Accueil - Admin</title>

    <!-- Bootstrap Core CSS -->
    <jsp:include page="../Commun/IncludeCSS.html"/>
</head>

<body>
	
	<div id="wrapper">
		<jsp:include page="BarreNavigationAdmin.html"/>
		
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Accueil - Responsable de parcours SI</h1>
                        <div class="col-lg-6">
                    		<div class="panel panel-default">
                        		<div class="panel-heading">
                            		Statut des élèves en parcours SI
                        		</div>                   	
                                <div id="piechart" style="width: 100%; height: 300px;"></div>
                    		</div>
                		</div>
                    </div>
                    <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            Collapsible Accordion Panel Group
	                        </div>
	                        <!-- .panel-heading -->
	                        <div class="panel-body">
	                            <div class="panel-group" id="accordion">
	                                <div class="panel panel-default">
	                                    <div class="panel-heading">
	                                        <h4 class="panel-title">
	                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Collapsible Group Item #1</a>
	                                        </h4>
	                                    </div>
	                                    <div id="collapseOne" class="panel-collapse collapse in">
	                                        <div class="panel-body">
	                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="panel panel-default">
	                                    <div class="panel-heading">
	                                        <h4 class="panel-title">
	                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Collapsible Group Item #2</a>
	                                        </h4>
	                                    </div>
	                                    <div id="collapseTwo" class="panel-collapse collapse">
	                                        <div class="panel-body">
	                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="panel panel-default">
	                                    <div class="panel-heading">
	                                        <h4 class="panel-title">
	                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Collapsible Group Item #3</a>
	                                        </h4>
	                                    </div>
	                                    <div id="collapseThree" class="panel-collapse collapse">
	                                        <div class="panel-body">
	                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- .panel-body -->
	                    </div>
	                </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
	</div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <jsp:include page="../Commun/IncludeJS.html"/>
</body>

</html>
