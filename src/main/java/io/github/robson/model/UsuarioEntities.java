package io.github.robson.model;

public class UsuarioEntities {
	
	private String iduser;
	private String nome;
	private String login;
	private String senha;
	
	public UsuarioEntities() {
	}

	public UsuarioEntities(String iduser, String nome, String login, String senha) {
		this.iduser = iduser;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
