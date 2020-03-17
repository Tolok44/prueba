package Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class reportMethod {
	FileWriter filewriter = null;
	 PrintWriter printw = null;
	 
	public void reportMaker(ArrayList<Step> stepList) {
		try{
		     filewriter = new FileWriter("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\src\\main\\java\\reports\\reporte.html");//declarar el archivo
		     printw = new PrintWriter(filewriter);//declarar un impresor
		     printw.println("<html>");
		     printw.println("<head><title>Reporte</title> "
		     		+"<link rel=\"icon\" href=\"../img/Thanos.png\" />" + 
		     		"<link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">" + 
		     		"<link rel=\"stylesheet\" href=\"../css/estilos.css\">" + 
		     		"<script src=\"../js/jquery-3.4.1.min.js\"></script>" + 
		     		"<script src=\"../js/bootstrap.min.js\"></script>"
		     		+ "</head>");    
		     //
		     printw.println("<body>");
		    
		     //Creacion de navbar
		     printw.println("<nav class=\"navbar-custom\">" + 
		     		"    <a class=\"navbar-brand\" href=\"#\">" + 
		     		"      <img src=\"../img/iconfinder_JD-27_2624867.png\" width=\"40\" height=\"40\" class=\"d-inline-block align-top\">" + 
		     		"      Thanos Framework" + 
		     		"    </a>" + 
		     		"  </nav>");
	
			//Creacion de la tabla con sus headers y contenido
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
		     for(int i = 0; i < stepList.size(); i++)
		     {
		    	 printw.println("<tbody>" + "<tr>");
		    	 printw.println("<th scope=\"row\">" + stepList.get(i).tcName + "</th>"+ 
		    			 "<th scope=\"row\">" + stepList.get(i).step + "</th>"+ 
		    	 		"<td>" + stepList.get(i).description + "</td>"+ 
		    	 		"<td>" + stepList.get(i).accion + "</td>" + 
		    	 		"<td>" + stepList.get(i).valueAccion + "</td>"+ 
		    	 		"<td><span><img src=\"../img/pass-icon.png\" height=\"30\" width=\"30\"></span></td>"+ 
		    	 		"<td><a href=\"C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\Screenshots\\"+stepList.get(i).getTcName()+"\\Step "+ stepList.get(i).step+" "+stepList.get(i).accion +".png\"> Screenshot</a></td>"+
		    	 		"<td> " + stepList.get(i).getTime() + "</td>"+ 
		    	 		"</tr> </div>");
		     }
		     printw.println("</body>");
		     printw.println("</html>");
		           
		     //no debemos olvidar cerrar el archivo para que su lectura sea correcta
		     printw.close();//cerramos el archivo
		     System.out.println("Reporte generado exitosamente");//si todo sale bien mostramos un mensaje de guardado exitoso
	}catch(IOException e){
		e.getMessage();
	}
	}
}
