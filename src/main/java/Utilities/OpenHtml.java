package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
/**this class opens the test reports file */
public class OpenHtml {
/**this method opens the file depending of the test case name*/
	public void OpenHtml(String nombreTC) throws IOException {
		File objectfile = new File("src/main/java/reports/" + nombreTC + ".html");
		Desktop.getDesktop().open(objectfile);
	}
}
