package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerXmls {
	static ArrayList<Step> TC = new ArrayList();
   static XSSFRow row;
   
   public ArrayList<Step> obtenObjetos(String name) throws IOException{
	   
	   FileInputStream fis = new FileInputStream(new File(name));
	      
	      XSSFWorkbook workbook = new XSSFWorkbook(fis);
	      XSSFSheet spreadsheet = workbook.getSheetAt(0);
	      
	      XSSFRow cell;       
	      
	      int rows = spreadsheet.getLastRowNum()+1;
	   
	      // Obtengo el número de columnas ocupadas en la hoja
	      int cols = 0;            
	    
	      // Cadena que usamos para almacenar la lectura de la celda
	      String Accion="",vAccion="",locator="",vLocator="";
	      double Step=0; 
	      double waitTime=0;
	      boolean screenshot=false;
	      
	      Step aux;
	      
	     
	      for (int r = 0; r < rows; r++) {
	    	  row = spreadsheet.getRow(r);
	    	 
	    	
	              for (int c = 0; c < (cols = row.getLastCellNum()); c++) {
	            	  if(row.getCell(c) == null) {
	            		 
	            	  }else {
	            	  if(r > 0) {
	            	  switch(c) {
	            	  
	            	  case 0: Step = row.getCell(c).getNumericCellValue();
	            	  break;
	            	  
	            	  case 1: Accion = row.getCell(c).getStringCellValue();
	            	  break;
	            	  case 2: vAccion = row.getCell(c).getStringCellValue();
	            	  break;
	            	  
	            	  case 3: locator = row.getCell(c).getStringCellValue();   	  
	            	  break;
	            	  
	            	  case 4: vLocator = row.getCell(c).getStringCellValue(); 
	            	  break;
	            	  
	            	  case 5: screenshot = row.getCell(c).getBooleanCellValue();
	            	  break;
	            	  
	            	  case 6: waitTime = row.getCell(c).getNumericCellValue();
	            	  break;
	            	  
	            	  
	            	  }
	            	  }
	            	 
	            	  }
	            	  
	            	  
	              }
	             aux = new Step(Step, Accion, vAccion, locator, vLocator,screenshot,waitTime);
	             TC.add(aux);
	             Accion="";
	            vAccion="";
	            locator="";
	            vLocator="";
	            
	                   
	      } 
	      
	      fis.close();
	   
	   
	   return TC;
	   
   }
   
   
}
   