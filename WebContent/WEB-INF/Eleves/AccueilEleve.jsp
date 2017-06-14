<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Page d'accueil de l'élève">
<meta name="author" content="Phoenix + Griffon">

<title>JobISEP - Accueil élève</title>
<jsp:include page="/WEB-INF/Commun/IncludeCSS.jsp" />

<jsp:include page="/WEB-INF/Commun/IncludeJS.jsp" />

</head>

<body>

	<div id="wrapper">

		<!-- Barre de navigation -->
		<jsp:include page="/WEB-INF/Eleves/BarreNavigationEleve.jsp" />

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Accueil</h1>
					</div>
					<!-- /.col-lg-12 -->
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-body" style="marging-top: 20%;">
								<ul class="timeline">
									<li>
										<div class="timeline-badge">
											<i class="fa fa-check"></i>
										</div>
										<div class="timeline-panel">
											<div class="timeline-heading">
												<h4 class="timeline-title">Nouvelle Offre : Developper</h4>
											</div>
											<div class="timeline-body">
												<p>Description: "belongs to those who fail in their duty through weakness of will, which 
												is the same as saying through shrinking from toil and pain. These cases 
												are perfectly simple and easy to distinguish. In a free hour, when our 
												power of choice is untrammelled and when nothing prevents our being able 
												to do what we like best, every pleasure is to be welcomed and every pain avoided. 
												But in certain circumstances and owing to the claims of duty or the obligations of business it will freque"</p>
											</div>
										</div>
									</li>
									<li class="timeline-inverted">
										<div class="timeline-badge warning">
											<i class="fa fa-credit-card"></i>
										</div>
										<div class="timeline-panel">
											<div class="timeline-heading">
												<h4 class="timeline-title">Info : Convention de Stage</h4>
											</div>
											<div class="timeline-body">
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Autem dolorem quibusdam, tenetur commodi provident
													cumque magni voluptatem libero, quis rerum. Fugiat esse
													debitis optio, tempore. Animi officiis alias, officia
													repellendus.</p>
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Laudantium maiores odit qui est tempora eos, nostrum
													provident explicabo dignissimos debitis vel! Adipisci eius
													voluptates, ad aut recusandae minus eaque facere.</p>
											</div>
										</div>
									</li>
									<li>
										<div class="timeline-badge danger">
											<i class="fa fa-bomb"></i>
										</div>
										<div class="timeline-panel">
											<div class="timeline-heading">
												<h4 class="timeline-title">Lorem ipsum dolor</h4>
											</div>
											<div class="timeline-body">
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Repellendus numquam facilis enim eaque, tenetur nam
													id qui vel velit similique nihil iure molestias aliquam,
													voluptatem totam quaerat, magni commodi quisquam.</p>
											</div>
										</div>
									</li>
									<li class="timeline-inverted">
										<div class="timeline-panel">
											<div class="timeline-heading">
												<h4 class="timeline-title">Lorem ipsum dolor</h4>
											</div>
											<div class="timeline-body">
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Voluptates est quaerat asperiores sapiente, eligendi,
													nihil. Itaque quos, alias sapiente rerum quas odit! Aperiam
													officiis quidem delectus libero, omnis ut debitis!</p>
											</div>
										</div>
									</li>
									<li>
										<div class="timeline-badge info">
											<i class="fa fa-save"></i>
										</div>
										<div class="timeline-panel">
											<div class="timeline-heading">
												<h4 class="timeline-title"></h4>
											</div>
											<div class="timeline-body">
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Nobis minus modi quam ipsum alias at est molestiae
													excepturi delectus nesciunt, quibusdam debitis amet, beatae
													consequuntur impedit nulla qui! Laborum, atque.</p>
												<hr>
												<div class="btn-group">
													
													<ul class="dropdown-menu" role="menu">
														<li><a href="#">Action</a></li>
														<li><a href="#">Another action</a></li>
														<li><a href="#">Something else here</a></li>
														<li class="divider"></li>
														<li><a href="#">Separated link</a></li>
													</ul>
												</div>
											</div>
										</div>
									</li>
									<li>
										<div class="timeline-panel">
											<div class="timeline-heading">
												<h4 class="timeline-title">Lorem ipsum dolor</h4>
											</div>
											<div class="timeline-body">
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Sequi fuga odio quibusdam. Iure expedita, incidunt
													unde quis nam! Quod, quisquam. Officia quam qui adipisci
													quas consequuntur nostrum sequi. Consequuntur, commodi.</p>
											</div>
										</div>
									</li>
									<li class="timeline-inverted">
										<div class="timeline-badge success">
											<i class="fa fa-graduation-cap"></i>
										</div>
										<div class="timeline-panel">
											<div class="timeline-heading">
												<h4 class="timeline-title">Lorem ipsum dolor</h4>
											</div>
											<div class="timeline-body">
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Deserunt obcaecati, quaerat tempore officia voluptas
													debitis consectetur culpa amet, accusamus dolorum fugiat,
													animi dicta aperiam, enim incidunt quisquam maxime neque
													eaque.</p>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
					
					
				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

		<!-- jQuery -->
		<jsp:include page="/WEB-INF/Commun/IncludeJS.jsp" />

		<!-- /#wrapper -->
	</div>
</body>

</html>

