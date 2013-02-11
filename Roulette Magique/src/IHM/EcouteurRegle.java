package IHM;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class EcouteurRegle implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

//		Desktop desktop = Desktop.getDesktop();
//		try {
//			URL resource = Thread.currentThread().getContextClassLoader().getResource("src/index.html");
//			desktop.open(new File(resource.getPath()));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
		InputStream pdfDansLArchive = getClass().getClassLoader().getResourceAsStream("index.html");
	     
	    try {
	        File pdfCree = new File("index.html");
	        // Extraction du PDF qui se situe dans l'archive
	        FileOutputStream fos = new FileOutputStream(pdfCree);
	        while (pdfDansLArchive.available() > 0) {
	              fos.write(pdfDansLArchive.read());
	        }   // while (pdfInJar.available() > 0)
	        fos.close();
	        // Ouverture du PDF
	        Desktop.getDesktop().open(pdfCree);
	    }   // try
	     
	    catch (IOException e1) {
	        System.out.println("erreur : " + e1);
	    }   // catch (IOException e)
	
	}

}
