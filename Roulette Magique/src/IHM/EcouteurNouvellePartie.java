package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurNouvellePartie implements ActionListener {

	private Fenetre f;
	private NouvellePartie p;

	public EcouteurNouvellePartie(Fenetre f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		p = new NouvellePartie(f);
		f.getContentPane().setVisible(false);
		f.getContentPane().removeAll();
		f.getContentPane().add(p);
		f.getContentPane().setVisible(true);

	}
}