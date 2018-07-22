package com.ati.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ati.db.Database;
import com.ati.model.Amigo;

/**
 * Servlet implementation class ListaServlet
 */
@WebServlet("/amigo")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
			
			List<Amigo> amigos = Database.getInstance().getAmigo(unAmigo);
			
			request.setAttribute("amigos", amigos);
		
			request.getRequestDispatcher("amigo.jsp").forward(request, response);
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			int idUsuario=Integer.parseInt(request.getParameter("id"));
			boolean idborrar=Database.getInstance().deleteAmigo(idUsuario);
			
			String NombreAmigo=request.getParameter("nuevoAmigo");
			int idAmigo=Database.getInstance().ultimoId();
			idAmigo++;
			
			response.setContentType("application/json");
			response.getWriter().append("{\"result\":"+idborrar+"}").flush();
			
			
	}

}
