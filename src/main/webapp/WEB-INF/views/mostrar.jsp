<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<title>Ingreso de Usuario</title>
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:400,300|Raleway:300,400,900,700italic,700,300,600">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
input[type=number]::-webkit-outer-spin-button, input[type=number]::-webkit-inner-spin-button
	{
	-webkit-appearance: none;
	margin: 25;
}

input[type=number] {
	-moz-appearance: textfield;
}

input[type=number] {
	height: 35px;
	width: 145px;
}

input[type=date] {
	height: 35px;
	width: 290px;
}

input[type=password] {
	height: 35px;
	width: 290px;
}

input[list=tipoDocumento] {
	height: 35px;
}

input[list=rol] {
	height: 35px;
	width: 290px;
}

@import
	url(https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic)
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-font-smoothing: antialiased;
	-moz-font-smoothing: antialiased;
	-o-font-smoothing: antialiased;
	font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
}

body {
	font-family: "Roboto", Helvetica, Arial, sans-serif;
	font-weight: 100;
	font-size: 12px;
	line-height: 30px;
	color: #777;
	background-image:
		url("https://cadoonline.org/wp-content/uploads/2017/10/19757-football-stadium-1920x1080-sport-wallpaper.jpeg");
}

.container {
	max-width: 400px;
	width: 100%;
	margin: 0 auto;
	position: relative;
}

#contact input[type="text"], #contact input[type="email"], #contact input[type="tel"],
	#contact input[type="url"], #contact textarea, #contact button[type="submit"]
	{
	font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
}

#contact {
	background: #F9F9F9;
	padding: 25px;
	margin: 150px 0;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

#contact h3 {
	display: block;
	font-size: 30px;
	font-weight: 300;
	margin-bottom: 10px;
}

#contact h4 {
	margin: 5px 0 15px;
	display: block;
	font-size: 13px;
	font-weight: 400;
}

fieldset {
	border: medium none !important;
	margin: 0 0 10px;
	min-width: 100%;
	padding: 0;
	width: 100%;
}

#contact input[type="text"], #contact input[type="email"], #contact input[type="tel"],
	#contact input[type="url"], #contact textarea {
	width: 100%;
	border: 1px solid #ccc;
	background: #FFF;
	margin: 0 0 5px;
	padding: 10px;
}

#contact input[type="text"]:hover, #contact input[type="email"]:hover,
	#contact input[type="tel"]:hover, #contact input[type="url"]:hover,
	#contact textarea:hover {
	-webkit-transition: border-color 0.3s ease-in-out;
	-moz-transition: border-color 0.3s ease-in-out;
	transition: border-color 0.3s ease-in-out;
	border: 1px solid #aaa;
}

#contact textarea {
	height: 100px;
	max-width: 100%;
	resize: none;
}

#contact button[type="submit"] {
	cursor: pointer;
	width: 100%;
	border: none;
	background: #4CAF50;
	color: #FFF;
	margin: 0 0 5px;
	padding: 10px;
	font-size: 15px;
}

#contact button[type="submit"]:hover {
	background: #43A047;
	-webkit-transition: background 0.3s ease-in-out;
	-moz-transition: background 0.3s ease-in-out;
	transition: background-color 0.3s ease-in-out;
}

#contact button[type="submit"]:active {
	box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

.copyright {
	text-align: center;
}

#contact input:focus, #contact textarea:focus {
	outline: 0;
	border: 1px solid #aaa;
}

::-webkit-input-placeholder {
	color: #888;
}

:-moz-placeholder {
	color: #888;
}

::-moz-placeholder {
	color: #888;
}

:-ms-input-placeholder {
	color: #888;
}
</style>

</head>


<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container"
		ng-controller="MostrarController as ctrl">

		<div class="loader"></div>
		<div id="myDiv">
			<div class="header">
				<div class="bg-color">
					<header id="main-header">
						<nav class="navbar navbar-default navbar-fixed-top">
							<div class="container">
								<div class="navbar-header">
									<button type="button" class="navbar-toggle"
										data-toggle="collapse" data-target="#myNavbar">
										<span class="icon-bar"></span> <span class="icon-bar"></span>
										<span class="icon-bar"></span>
									</button>
									
								</div>
								<div class="collapse navbar-collapse" id="myNavbar">
									<ul class="nav navbar-nav navbar-right">
										<li class="active"><a
											href="${pageContext.request.contextPath}/admjugador">Inicio</a></li>
										
													
									<li class=""><a
											href="${pageContext.request.contextPath}" onclick="eliminar()">Cerrar Sesion</a></li>
									</ul>
								</div>
							</div>
						</nav>
					</header>

				</div>
			</div>

				
					<form >
						<div id="contact">
							<h3>Convocatoria Jugador</h3>


							<table width="700" align="center" class="table table-hover">
                <thead>
                <tr>
                    <th>Numero de Convocatoria.</th>
                    <th>Identificador Equipo</th>
                    <th>Nombre Equipo</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="r in ctrl.userDto ">
                    <td><span ng-bind="r.idConvocatoria"></span></td>
                    <td><span ng-bind="r.idEquipo"></span></td>
                    <td >
                        <span ng-bind="r.nombreEquipo"></span>
                    </td>
               
                </tr>
                </tbody>
            </table>
						
						</div>

					</form>
			
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/app.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/service/mostrar_service.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/controller/mostrar_controller.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/ingreso.js"></script>
</body>

</html>