/**
 * Validando o login
 */
 
 function validar(){
	
	let nome = frmContato.nome.value
	let telefone = frmContato.fone.value
	let email = frmContato.email.value
	
	
	if(nome === ""){
		alert("Preencha o campo nome!")
		formLogar.nome.focus()
		return false
	}else if(telefone === ""){
		alert("Preencha o campo Telefone!")
		formLogar.telefone.focus()
		return false
	}else if(email === ""){
		alert("Preencha o campo Email!")
		formLogar.email.focus()
		return false
	}else{
		document.forms["frmContato"].submit()
	}	
}