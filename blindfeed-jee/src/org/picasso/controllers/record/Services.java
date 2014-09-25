package org.picasso.controllers.record;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class Services {
	

	String completepath;
	String normalpath;
	
	public String SendToServer(InputStream stream, String path,String bookname) throws IOException{
		
		byte[] buffer = new byte[8192];
	    int bytesRead;
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    while ((bytesRead = stream.read(buffer)) != -1)
	    {
	        output.write(buffer, 0, bytesRead);
	    }
	    
		
		path=path+"/"+bookname;
		File folder=new File(path);
		   
		    
	    if(folder.exists()){
	  
	    	System.out.println("audio resource folder exists ");
			File[] listOfFiles = folder.listFiles();
			int count=listOfFiles.length+1;
			//String realpath=path+"/"+"AudioClip"+count+".mp3";
			
			normalpath="AudioClip"+count+".mp3";
			
			completepath=path+"/"+normalpath;
			
			File someFile = new File(completepath);
			
			
		    FileOutputStream fos = new FileOutputStream(someFile);
		    System.out.println("====="+completepath+"=====");
		    System.out.println("====="+someFile.getAbsolutePath()+"======"); 
	
        fos.write(output.toByteArray());
        fos.flush();
        fos.close();
        
        normalpath=bookname+"/"+normalpath;
        
	    }else if(!(folder.exists())){
	    	
	    	System.out.println("audio resource folder not exists  but create");
	    	folder.mkdir();
	    	System.out.println(folder.getName());
			File[] listOfFiles = folder.listFiles();
			int count=listOfFiles.length+1;
			//String realpath=path+"/"+"AudioClip"+count+".mp3";
			
			normalpath="AudioClip"+count+".mp3";
			
			completepath=path+"/"+normalpath;
			
			File someFile = new File(completepath);
			
			
		    FileOutputStream fos = new FileOutputStream(someFile);
		    System.out.println("====="+completepath+"=====");
		    System.out.println("====="+someFile.getAbsolutePath()+"======"); 
		    
		    fos.write(output.toByteArray());
	        fos.flush();
	        fos.close();
	        
	        normalpath=bookname+"/"+normalpath;
	    }
		return normalpath;
	}
}
