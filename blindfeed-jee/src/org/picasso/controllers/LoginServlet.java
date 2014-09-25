package org.picasso.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

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
		
		/*initialize session when user log to account*/
		HttpSession session=request.getSession();
		
		/* this get the servelt path 
		 * as example www.example.lk/servlet1
		 * www.example.lk/servlet2
		 * servlet paths are servlet1,servlet2
		 * 
		 * */
		String usrpath=request.getServletPath();
		
		if(usrpath.equals("/loginProcess")){
			
			/*get the parameter which specified in html file */
			String userName=request.getParameter("EMail");
			String password=request.getParameter("Password");
			
			/*store username in above session this data can be retrieved in jsp page*/
			session.setAttribute("usr", userName);
			
			/*this class which responsible for checking valid login */
			LoginValidator login=new LoginValidator();
			
			try {
			/*this checks the login valid againt database result if 
			 * true login found then this redirect to account
			 * */
				if (login.validLogin(userName, password)) {
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/RegisterdUser/index.jsp");
				/*include means this request and response include to when use logged becouse every
				 * time request and response object are different becouse stateless
				 *  */
			        rd.include(request, response);
				}else{
				/*if user login is incorrect this redirect to the login page
				 * */
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/unreguser/");
			        rd.forward(request, response);
				}
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else if(usrpath.equals("/logoutProcess")){
			/*this destroy the session when user logout*/
			session.invalidate();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/unreguser/");
	        rd.forward(request, response);
	        
		}
		
			
	}

}
