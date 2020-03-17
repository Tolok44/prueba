package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenHtml {
	public File objectfile = new File ("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\src\\main\\java\\reports\\reporte.html");
	public void OpenHtml() throws IOException {
		 Desktop.getDesktop().open(objectfile);
	}
}
