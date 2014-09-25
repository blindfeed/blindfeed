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
	
	List<Paragraph> list;
	
	public List<Paragraph> getParagraphList() throws NamingException, SQLException{
		
		Context initContext=new InitialContext();
		Context envContext=(Context) initContext.lookup("java:/comp/env");
		dataSource=(DataSource) envContext.lookup("jdbc/dbpool");				
		connection=dataSource.getConnection();
		
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
	
}
