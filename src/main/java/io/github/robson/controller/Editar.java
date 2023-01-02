package io.github.robson.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.robson.connection.ContatoDAO;
import io.github.robson.model.ContatoEntities;

public class Editar implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ContatoEntities contato = new ContatoEntities();
		contato.setIdcon(request.getParameter("Idcon"));
		contato.setEmail(request.getParameter("email"));
		contato.setFone(request.getParameter("fone"));
		contato.setNome(request.getParameter("nome"));
		
		ContatoDAO dao = new ContatoDAO();
		dao.update(contato);
		
		return "/WEB-INF/view/index.jsp";
	}
}
