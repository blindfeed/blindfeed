package org.picasso.controllers.record;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ParagraphDB {

	private DataSource dataSource;
	private Connection connection;
	private ResultSet result;
	private Statement statment;
	private Statement statmentUpdate;
	
	List<Paragraph> list;
	
	/*this method return list of paragrpah and its id and book id 
	 * one of them should be display for user reading
	 * always take first one not random
	 * */
	public List<Paragraph> getParagraphList() throws NamingException, SQLException{
		
		Context initContext=new InitialContext();
		Context envContext=(Context) initContext.lookup("java:/comp/env");
		dataSource=(DataSource) envContext.lookup("jdbc/dbpool");				
		connection=dataSource.getConnection();
		
	/*this query takes rows which audio flag is 0 it means paragrpah is not recorded*/
		String query="SELECT `Paragraph_ID`,`Para_text`,`Book_Book_ID` FROM `paragraph` WHERE `Audio_Flag`=0";
		
		statment=connection.createStatement();
		result=statment.executeQuery(query);
		
		list=new ArrayList<>();
		
		while(result.next()){
			Paragraph paragraph=new Paragraph();
			paragraph.setParagraphID(Integer.parseInt(result.getString("Paragraph_ID")));
			paragraph.setParagraphText(result.getString("Para_text"));
			paragraph.setBookID(Integer.parseInt(result.getString("Book_Book_ID")));
			//System.out.println(result.getString("Paragraph_ID")+" "+result.getString("Para_text")+" "+result.getString("Book_Book_ID"));
			list.add(paragraph);
		}
		return list;
		
	}
	
	public void updateParagraphRow(String location,int userID,int paragrpahID,int bookID) throws SQLException{
		String sql="update `paragraph` set `AudioPara_Location`= "+location+", `Audio_Flag`=1, `User_UserID`= "+userID+" where `Paragraph_ID`= "+paragrpahID+" and `Book_Book_ID`= "+bookID+"";
		statmentUpdate=connection.createStatement();
		statmentUpdate.execute(sql);
		statmentUpdate.close();
	}
	
}
