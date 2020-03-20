package Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class reportMethod {
	//Initialize FileWrite and PrintWriter to write HTML
	FileWriter filewriter = null;
	 PrintWriter printw = null;
	 //We create a method to create a report
	public void reportMaker(ArrayList<Step> stepList) {
		String tcname="";
		tcname=stepList.get(2).getTcName();
	try{
	     filewriter = new FileWriter("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\src\\main\\java\\reports\\"+tcname+".html");//declarar el archivo
		     //Create a print object to write the html code
		     printw = new PrintWriter(filewriter);
		     //Initialize the html doc 
		     printw.println("<html>");
		     printw.println("<head><title>Reporte "+tcname+"</title> "
		     		+"<link rel=\"icon\" href=\"../img/Thanos.png\" />" + 
		     		"<link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">" + 
		     		"<link rel=\"stylesheet\" href=\"../css/estilos.css\">" + 
		     		"<script src=\"../js/jquery-3.4.1.min.js\"></script>" + 
		     		"<script src=\"../js/bootstrap.min.js\"></script>"
		     		+ "</head>");    
		     printw.println("<body>");
		    
		     //navigation bar creation
		     printw.println("<nav class=\"navbar-custom\">" + 
		     		"    <a class=\"navbar-brand\" href=\"#\">" + 
		     		"      <img src=\"../img/iconfinder_JD-27_2624867.png\" width=\"40\" height=\"40\" class=\"d-inline-block align-top\">" + 
		     		"      Thanos Framework" + 
		     		"    </a>" + 
		     		"  </nav>");
	
		     //A table and their headers are created.
		     printw.println(" <div>" + 
		     		"    <table class=\"table table-hover\">" + 
		     		"        <thead>" + 
		     		"          <tr>" + 
		     		"            <th scope=\"col\">Test Case Name</th>" + 
		     		"            <th scope=\"col\">No. Step</th>" + 
		     		"            <th scope=\"col\">Description</th>" + 
		     		"            <th>Action</th>" + 
		     		"            <th>Value</th>" + 
		     		"            <th scope=\"col\">Status</a></th>" + 
		     		"            <th scope=\"col\">Screenshots</th>" + 
		     		"            <th scope=\"col\">TimeStamp</th>" + 
		     		"          </tr>" + 
		     		"        </thead>"
		     		);
		     //All the steps from their respective test cases are printed by a for cycle
		     for(int i = 0; i < stepList.size(); i++)
		     {
		    	 printw.println("<tbody>" + "<tr>");
		    	 printw.println("<th scope=\"row\">" + stepList.get(i).tcName + "</th>"+ 
		    			 "<th scope=\"row\">" + stepList.get(i).step + "</th>"+ 
		    	 		"<td>" + stepList.get(i).description + "</td>"+ 
		    	 		"<td>" + stepList.get(i).accion + "</td>" + 
		    	 		"<td>" + stepList.get(i).valueAccion + "</td>");
		    	 //here verifies if an step passed or not 
		    	 if(stepList.get(i).isPass() == true) {
		    		 printw.println("<td><span><img src=\"../img/pass-icon.png\" height=\"30\" width=\"30\"></span></td>");
		    	 }else {
		    		 printw.println("<td><span><img src=\"../img/failed-icon.png\" height=\"30\" width=\"30\"></span></td>");
		    	 }
		    	 		
		    	 	printw.println("<td><a href=\"C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\Screenshots\\"+stepList.get(i).getTcName()+"\\Step "+ stepList.get(i).step+" "+stepList.get(i).accion +".png\"> Screenshot</a></td>"+
		    	 	"<td> " + stepList.get(i).getTime() + "</td>"+ 
		    	 	"</tr> </div>");
		     }
		     //we close the html code.
		     printw.println("</body>");
		     printw.println("</html>");
		     printw.close();//we close the print object.
		     System.out.println("Reporte generado exitosamente");//If everything success will send a console message.
	}catch(IOException e){ //If it fails will send a message with the exception.
		e.getMessage();
	}
	}
}
