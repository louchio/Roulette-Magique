package IHM;



import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;





@SuppressWarnings("serial")
public class Fenetre extends JFrame
{
	
	public static NouvellePartie p;
	public static Partie c;
	private ArrayList<String> liste_couleur ;
	private ArrayList<String> liste_taille;
	private ArrayList<String> liste_vitesse;
	public Fenetre()
	{
		setTitle("La roulette magique");
		setBounds(0, 0, 1000, 600);	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setFocusable(true);
		
		EcouteurNouvellePartie e1 = new EcouteurNouvellePartie(this);
		EcouteurQuitter e2 = new EcouteurQuitter();
		
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
		JMenuItem regle = new JMenuItem("Règle du jeu");
		JMenuItem apropos = new JMenuItem("A propos");
	
		m2.add(regle);
		m2.add(apropos);
		mb.add(m2);
		
		setJMenuBar(mb);

		p = new NouvellePartie(this);
		add(p);
//		 liste_couleur = new ArrayList<String>();
//		 liste_taille = new ArrayList<String>();
//		 liste_vitesse = new ArrayList<String>();
//		 liste_couleur.add("Bleu");
//		 liste_couleur.add("Bleu");
//		 liste_taille.add("moyenne");
//		 liste_taille.add("grande");
//		 liste_vitesse.add("v");
//		 liste_vitesse.add("er");
//		 c = new Partie(liste_couleur, liste_taille, liste_vitesse, this);
//		 add(c);
		setVisible(true);
	}
	

}
