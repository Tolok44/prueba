package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenHtml {

	public void OpenHtml(String nombreTC) throws IOException {
		File objectfile = new File ("C:\\Users\\Training\\Desktop\\Prueba\\frameWorkBatch3\\src\\main\\java\\reports\\" + nombreTC + ".html");
		Desktop.getDesktop().open(objectfile);
	}
}
