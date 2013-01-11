package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EcouteurQuitter implements ActionListener {

	private Fenetre f;
	
	public EcouteurQuitter(Fenetre f){
		this.f = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		f.setVisible(false);
		f.dispose();
		
	}

}
