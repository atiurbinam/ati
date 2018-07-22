
function recargar(){
	
	$('.bborrar').click(function() {
		let parentLi = this.parentNode;
		let id = this.getAttribute("data-id");
		console.log("Hola", id);

		$.ajax({
			url : `./amigo?id=${id}`,
			type : "POST",
			accepts : "application/json"
		}).done(function(data) {
			console.log("data:", data);
			if (data.result) {
				parentLi.parentNode.removeChild(parentLi);
			}
		}).fail(function(err) {
			console.log("err:", err);
		});

	});
	
	
	$('.bpuntua').click(function() {
		let parentDiv = this.parentNode;
		let idamigo = this.getAttribute("data-id");
		let idpuntuacion = this.getAttribute('data-value');
		console.log("Id Amigo", idamigo, ":", idpuntuacion);
		let elInput=this;

		$.ajax({
			url : `./puntuacion?&idamigo=${idamigo}&idpuntuacion=${idpuntuacion}`,
			type : "POST",
			accepts : "application/json"
		}).done(function(data) {
			console.log("data:", data);
			if (data.result) {
				parentDiv.querySelectorAll('input').forEach(function(aInput) {
					aInput.removeAttribute('checked');
				});
				elInput.setAttribute("checked",true);
			}
		}).fail(function(err) {
			console.log("err:", err);

		});

	});
}

recargar();

$('.bagregar').click(function(event) {
	event.preventDefault();
	console.log("Nombre:", $("#formAmigo").serialize());

	$.ajax({
		url : `./amigo`,
		type : "POST",
		accepts : "application/json",
		data:($("#formAmigo").serialize())
	}).done(function(data) {
		console.log("data:", data);
		if (data.result) {
			let unAmigo=data.amigo;
			
			$('#lista-amigos').append(
				`<li>
					<button class="bborrar" data-id="${unAmigo.id}">Delete</button> <img
					src="img/luis.jpg"> <span>${unAmigo.nombre}</span>
					<div class="lista-estrellas">
						<p class="clasificacion">
							<input id="radio1${unAmigo.id}" type="radio"
								data-id="${unAmigo.id}" class='bpuntua' name="estrellas"
								data-value="5" ${unAmigo.puntuacion==5?"checked":""}> <label
								for="radio1${unAmigo.id}">&#9733</label> <input
								id="radio2${unAmigo.id}" type="radio" data-id="${unAmigo.id}"
								class='bpuntua' name="estrellas" data-value="4"
								${unAmigo.puntuacion==4?"checked":""}> <label
								for="radio2${unAmigo.id}">&#9733</label> <input
								id="radio3${unAmigo.id}" type="radio" data-id="${unAmigo.id}"
								class='bpuntua' name="estrellas" data-value="3"
								${unAmigo.puntuacion==3?"checked":""}> <label
								for="radio3${unAmigo.id}">&#9733</label> <input
								id="radio4${unAmigo.id}" type="radio" data-id="${unAmigo.id}"
								class='bpuntua' name="estrellas" data-value="2"
								${unAmigo.puntuacion==2?"checked":""}> <label
								for="radio4${unAmigo.id}">&#9733</label> <input
								id="radio5${unAmigo.id}" type="radio" data-id="${unAmigo.id}"
								class='bpuntua' name="estrellas" data-value="1"
								${unAmigo.puntuacion==1?"checked":""}> <label
								for="radio5${unAmigo.id}">&#9733</label>
						</p>
					</div>
				</li>`
					);
			recargar();
			
		}
	}).fail(function(err) {
		console.log("err:", err);
	});

});