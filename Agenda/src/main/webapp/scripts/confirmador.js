function confirmar(idcon) {
	let resp = confirm("Confirmar exclusao do contato?");

	if (resp === true) {
		window.location.href = "delete?idcon="+idcon;

	}
}