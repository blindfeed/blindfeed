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
		System.out.println("servlet going to initiate......");
		
		/*get the servlet path */
		String userpath=request.getServletPath();
		
		/*which has the databse connection*/
		ParagraphDB p=new ParagraphDB();
		
		if(userpath.equals("/RecordServlet")){
			
		
			try {
				
			/*this has list of datarows but one of them take as paragraph*/
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
				
				/*store data in session which will use in jsp pages*/
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
			 
			/*this gets the stream which record jsp page send */
			InputStream stream=request.getInputStream();
			
			/*this find the recaudio folder in which store audio clips*/
			String mypath=request.getSession().getServletContext().getRealPath("/RecAudio");
			System.out.println(mypath);
			
			/*get the session and stored data */
			HttpSession session=request.getSession(false);
			//String bookname=session.getAttribute(arg0);
			
			String mybook="newbook";
			/*this class has algorithm to store audio clipse with naming.. */
			Services serv=new Services();
			String path=serv.SendToServer(stream, mypath, mybook);
			
			/*get the stored session data*/
			int bookid=(Integer)session.getAttribute("bookid");
			int paraid=(Integer)session.getAttribute("paragraphid");
			
		/*In here need to get UserId according to usr name otherwise updateparagraphrow cannot be used
		 * 
		 * */
			
			if(path != null){
				System.out.println(path);
				String fullpath="/RecAudio/"+path;
				System.out.println(fullpath);
				//p.updateParagraphRow(fullpath, userID, paraid, bookid);
			}
			
			
			
		}
		
		
	}

}
