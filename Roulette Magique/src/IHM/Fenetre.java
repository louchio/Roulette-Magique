package IHM;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	public static NouvellePartie p;
	public static Partie c;
	public Image image;

	public Fenetre() {
		setTitle("La roulette magique");
		setBounds(0, 0, 1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setFocusable(true);

		try {
			image = ImageIO.read(getClass().getResource("favicon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIconImage(image);

		EcouteurNouvellePartie e1 = new EcouteurNouvellePartie(this);
		EcouteurQuitter e2 = new EcouteurQuitter();
		EcouterAPropos e3 = new EcouterAPropos();
		EcouteurRegle e4 = new EcouteurRegle();

		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Fichier");
		JMenuItem nouvelle = new JMenuItem("Nouvelle Partie");
		nouvelle.addActionListener(e1);
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(e2);

		m.add(nouvelle);
		m.add(quitter);
		mb.add(m);

		JMenu m2 = new JMenu("Aide");
		JMenuItem regle = new JMenuItem("Regle du jeu");
		regle.addActionListener(e4);
		JMenuItem apropos = new JMenuItem("A propos");
		apropos.addActionListener(e3);

		m2.add(regle);
		m2.add(apropos);
		mb.add(m2);

		setJMenuBar(mb);

		p = new NouvellePartie(this);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(p);

		add(pane);
		setVisible(true);
	}

}
