package org.picasso.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jndi.toolkit.url.Uri;

/**
 * Servlet implementation class LoginServlet
 */
/*@WebServlet({"/LoginServlet","/Logout"})*/
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
		HttpSession session=request.getSession();
			
		
		String usrpath=request.getServletPath();
		
		if(usrpath.equals("/loginProcess")){
			System.out.println("hello");

			String userName=request.getParameter("EMail");
			String password=request.getParameter("Password");
			
			System.out.println(userName+" "+password);
					
			session.setAttribute("usr", userName);
			
			
			LoginValidator login=new LoginValidator();
			try {
				System.out.println(login.validLogin(userName, password));
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/RegisterdUser/index.jsp");
	        rd.include(request, response);*/
			
		}else if(usrpath.equals("/logoutProcess")){
			System.out.println("world");
			session.invalidate();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/unreguser/");
	        rd.forward(request, response);
	        
		}
		
			
	}

}
