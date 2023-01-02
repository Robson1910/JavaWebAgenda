package io.github.robson.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.robson.connection.UsuarioDAO;
import io.github.robson.model.UsuarioEntities;

public class Access implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuarioEntities login = new UsuarioEntities();
		login.setLogin(request.getParameter("login"));
		login.setSenha(request.getParameter("password"));
		
		UsuarioDAO usuario = new UsuarioDAO();
		
		if(usuario.login(login)) {		
			return "/WEB-INF/view/index.jsp?nomeUserSession=" + login.getNome() +"&idUserSession=" + login.getIduser() ;
		}else {
			return "/WEB-INF/view/error.html";
		}
	}
}
