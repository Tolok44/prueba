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
		     LocalDateTime myObj = LocalDateTime.now();
		     DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		     String formattedDate = myObj.format(myFormatObj);
		     
		     printw.println("<html>");
		     printw.println("<head><title>Reporte</title> "
		     		+ "<link rel=\"icon\" href=\"../img/Thanos.png\" />\r\n" + 
		     		"<link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">\r\n" + 
		     		"<link rel=\"stylesheet\" href=\"../css/estilos.css\">\r\n" + 
		     		"<script src=\"../js/jquery-3.4.1.min.js\"></script>\r\n" + 
		     		"<script src=\"../js/bootstrap.min.js\"></script>"
		     		+ "</head>");    
		     //
		     printw.println("<body>");
		    
		     //Creacion de navbar
		     printw.println("<nav class=\"navbar-custom\">\r\n" + 
		     		"    <a class=\"navbar-brand\" href=\"#\">\r\n" + 
		     		"      <img src=\"../img/iconfinder_JD-27_2624867.png\" width=\"40\" height=\"40\" class=\"d-inline-block align-top\" alt=\"\">\r\n" + 
		     		"      Thanos Framework\r\n" + 
		     		"    </a>\r\n" + 
		     		"  </nav>");
	
			//Creacion de la tabla con sus headers y contenido
		     printw.println(" <div>\r\n" + 
		     		"    <table class=\"table table-hover\">\r\n" + 
		     		"        <thead>\r\n" + 
		     		"          <tr>\r\n" + 
		     		"            <th scope=\"col\">No. Step</th>\r\n" + 
		     		"            <th scope=\"col\">Description</th>\r\n" + 
		     		"            <th>Action</th>\r\n" + 
		     		"            <th>Value</th>\r\n" + 
		     		"            <th scope=\"col\">Status</a></th>\r\n" + 
		     		"            <th scope=\"col\">Screenshots</th>\r\n" + 
		     		"            <th scope=\"col\">TimeStamp</th>\r\n" + 
		     		"          </tr>\r\n" + 
		     		"        </thead>\r\n"
		     		);
		     for(int i = 0; i < stepList.size(); i++)
		     {
		    	 printw.println("<tbody>\r\n" + "<tr>\r\n");
		    	 printw.println("\"<th scope=\"row\">" + stepList.get(i).step + "</th>\r\n\" + \r\n" + 
		    	 		"\"<td>" + stepList.get(i).description + "</td>\r\n\" + \r\n" + 
		    	 		"\"<td>" + stepList.get(i).accion + "</td>\r\n\" + \r\n" + 
		    	 		"\"<td>" + stepList.get(i).valueAccion + "</td>\r\n\" + \r\n" + 
		    	 		"\"<td><span><img src=\"../img/pass-icon.png\" height=\"30\" width=\"30\"></span></td>\r\n\" + \r\n" + 
		    	 		"<td><a href=\"C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\Screenshots\\"+stepList.get(i).getTcName()+"\\Step "+ stepList.get(i).step+" "+stepList.get(i).accion +".png\"> Screenshot</a></td>\r\n"+
		    	 		"\"<td> " + formattedDate + "</td>\"+ \r\n" + 
		    	 		"\"</tr> </div>\"");
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
