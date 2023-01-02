package io.github.robson.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.robson.model.ContatoEntities;
import io.github.robson.connection.ContatoDAO;

public class Salvar implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ContatoEntities contato = new ContatoEntities();
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		ContatoDAO dao = new ContatoDAO();
		dao.insert(contato);
		
		return "/WEB-INF/view/index.jsp";
	}
}
