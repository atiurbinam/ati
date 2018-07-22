package com.ati.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ati.db.Database;




@WebServlet("/puntuacion")
public class puntuacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idAmigo=Integer.parseInt(request.getParameter("idamigo"));
		int idPuntuacion=Integer.parseInt(request.getParameter("idpuntuacion"));
		boolean isOk=Database.getInstance().getActualizaPuntuacion(idAmigo, idPuntuacion);
		
		response.setContentType("application/json");
		response.getWriter().append("{\"result\":"+isOk+"}").flush();
		
		//response.getWriter().append("{\"result\":true}").flush();
		//doGet(request, response);
	}

}
