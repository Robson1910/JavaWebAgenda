package io.github.robson.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/home")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nomeUserSession");
		String id = request.getParameter("idUserSession");

		
		try {

			String actionName = request.getParameter("page");
			
			if(actionName == null|| actionName == "") {
				response.sendRedirect("login.html");
			} else {
				
				String packageName = "io.github.robson.controller.";
				
				Class<?> page = Class.forName(packageName + actionName);
				@SuppressWarnings("deprecation")
				Action action = (Action) page.newInstance();

				String nextPage = action.execute(request, response);
				
				request.setAttribute("nomeUserSession", nome);
				request.setAttribute("idUserSession", id);
				
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response);	
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
	}
}
