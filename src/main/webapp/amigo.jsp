<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Amigo</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="./css/styles.css"/>
	<link href="./css/materialize.css" type="text/css" rel="stylesheet"
		media="screen,projection"/>
	<link href="./css/materialize.min.css" type="text/css" rel="stylesheet"
		media="screen,projection"/>
</head>
<body>
	
		<div class="container">
		<h1>Clasifica y Elimina</h1>
		<a href="./reset">Reset</a>
		<ul id="lista-amigos">
			<c:forEach items="${amigos}" var="unAmigo">
				<li>
					<button class="bborrar" data-id="${unAmigo.id}">Delete</button> 
					<img src="img"> 
					<span>${unAmigo.nombre}</span>
					<div class="lista-estrellas">
						<p class="clasificacion">
							<input id="radio1${unAmigo.id}" type="radio"
								data-id="${unAmigo.id}" class='bpuntua' name="estrellas"
								data-value="5" ${unAmigo.puntuacion==5?"checked":""}> 
								<label for="radio1${unAmigo.id}">&#9733</label> 
							<input id="radio2${unAmigo.id}" type="radio" 
							    data-id="${unAmigo.id}" class='bpuntua' name="estrellas" data-value="4"
								${unAmigo.puntuacion==4?"checked":""}> 
								<label for="radio2${unAmigo.id}">&#9733</label> 
							<input id="radio3${unAmigo.id}" type="radio" 
							    data-id="${unAmigo.id}" class='bpuntua' name="estrellas" data-value="3"
								${unAmigo.puntuacion==3?"checked":""}> 
								<label for="radio3${unAmigo.id}">&#9733</label> 
							<input id="radio4${unAmigo.id}" type="radio" 
								data-id="${unAmigo.id}" class='bpuntua' name="estrellas" data-value="2"
								${unAmigo.puntuacion==2?"checked":""}> 
								<label for="radio4${unAmigo.id}">&#9733</label> 
							<input id="radio5${unAmigo.id}" type="radio" 
								data-id="${unAmigo.id}" class='bpuntua' name="estrellas" data-value="1"
								${unAmigo.puntuacion==1?"checked":""}> 
								<label for="radio5${unAmigo.id}">&#9733</label>
						 </p>
					</div>
				</li>
			</c:forEach>
		</ul>
			<form action="" method="post" id="formAmigo">
				<input type="text" placeholder="nombre" name="nuevoAmigo"
					class="btn_nuevoAmigo" />
				<button class="bagregar">Enviar</button>
			</form>
	</div>
	
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="./script/script.js"></script>
</html>