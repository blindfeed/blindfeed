package org.picasso.controllers.record;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RecordServlet
 */
/*@WebServlet("/RecordServlet")*/
public class RecordServlet extends HttpServlet {
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
		System.out.println("hello world");
		
		String userpath=request.getServletPath();
		
		if(userpath.equals("/RecordServlet")){
			ParagraphDB p=new ParagraphDB();
			try {
				List<Paragraph> list=p.getParagraphList();
				
				if(list.size() > 0){
					System.out.println(list.get(0).getParagraphText());
					System.out.println(list.get(0).getBookID());
					System.out.println(list.get(0).getParagraphID());
				}
				
				
				HttpSession sesion =request.getSession(false);
				System.out.println(sesion.getAttribute("usr"));
				sesion.setAttribute("user",sesion.getAttribute("usr"));
				sesion.setAttribute("text",list.get(0).getParagraphText());
				sesion.setAttribute("bookid",list.get(0).getBookID());
				sesion.setAttribute("paragraphid",list.get(0).getParagraphID());
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/RegisterdUser/record.jsp");
		        rd.include(request, response);
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(userpath.equals("/record")){
			
			InputStream stream=request.getInputStream();
			
			String mypath=request.getSession().getServletContext().getRealPath("/RecAudio");
			System.out.println(mypath);
			
			Services serv=new Services();
			serv.SendToServer(stream, mypath, "gihan");
		}
		
		
	}

}
