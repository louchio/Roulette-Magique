package IHM;



import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;





@SuppressWarnings("serial")
public class Fenetre extends JFrame
{
	
	public static NouvellePartie p;
	public static Partie c;

	public Fenetre()
	{
		setTitle("La roulette magique");
		setBounds(0, 0, 1000, 800);	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setFocusable(true);
		
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
		add(p);
//		
//		Roue_dynamique r = new Roue_dynamique();
//		add(r);
		setVisible(true);
	}
	

}
