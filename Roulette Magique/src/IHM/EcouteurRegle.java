package IHM;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class EcouteurRegle implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(new File("src/index.html"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
