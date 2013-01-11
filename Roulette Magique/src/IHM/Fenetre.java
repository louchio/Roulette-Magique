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
	
	public Fenetre()
	{
		setTitle("La roulette magique");
		setBounds(0, 0, 800, 600);	
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setFocusable(true);
//		setResizable(false);
		
		EcouteurNouvellePartie e1 = new EcouteurNouvellePartie(this);
		EcouteurQuitter e2 = new EcouteurQuitter(this);
		
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
		setVisible(true);
	}
	
	public void Frame_ChoixBilles(ChoixBilles c){
		
	}
}
