/**
 * Confirmação de exclusão de contato
 */
 
 function confirmar(usuarioId){
	
	let resposta = confirm("Confirma a exclusão desse contato?")
	if(resposta === true){
		window.location.href = "home?page=Deletar&idCon=" + usuarioId
	}
}