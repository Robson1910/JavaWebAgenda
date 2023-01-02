package io.github.robson.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.robson.connection.ContatoDAO;
import io.github.robson.model.ContatoEntities;

public class Deletar implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ContatoEntities cadastro = new ContatoEntities();
		cadastro.setIdcon(request.getParameter("idCon"));
		
		ContatoDAO dao = new ContatoDAO();
		dao.delete(cadastro);
		
		return "/WEB-INF/view/index.jsp";
	}

}
