package IHM;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ChoixBilles extends JPanel{

	
	private ArrayList<String> liste_couleur;
	private ArrayList<String> liste_taille;
	private ArrayList<String> liste_vitesse;
	
	private JPanel tab = new JPanel();
	
	private Partie commencer_partie;
			
	public ChoixBilles(int nb_billes, final Fenetre f1) {
		
		setLayout(new BorderLayout());
		
		JPanel container = new JPanel(new GridBagLayout());
		GridBagConstraints X = new GridBagConstraints();
		X.gridx = 0;
		X.insets = new Insets(0, 0, 100, 0);
		GridBagConstraints X2 = new GridBagConstraints();
		X2.gridx = 0;
		
		liste_couleur = new ArrayList<String>();
		liste_taille = new ArrayList<String>();
		liste_vitesse = new ArrayList<String>();
		
/*____________________________________________________________________________________________
						Tableau 
_____________________________________________________________________________________________*/		

		
		tab.setLayout(new GridBagLayout());
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = 0;
		c1.anchor = GridBagConstraints.LINE_START;
		c1.insets = new Insets(10, 10, 10, 10);
		tab.add(new JLabel(" "),c1);
		tab.add(new JLabel("Couleur : "),c1);
		tab.add(new JLabel("Taille : "),c1);
		tab.add(new JLabel("Vitese : "),c1);
		
		for(int i=1; i<=nb_billes; i++){
			choix_billes(i);
		}
		
		container.add(tab,X);
		
/*____________________________________________________________________________________________
					Bouton du bas
_____________________________________________________________________________________________*/		

		
		JPanel bas = new JPanel( new GridBagLayout());
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.insets = new Insets(10, 10, 10, 10);
		
		JButton retour = new JButton("Retour");
		EcouteurNouvellePartie e1 = new EcouteurNouvellePartie(f1);
		retour.addActionListener(e1);
		bas.add(retour,c2);
		
		JButton commencer = new JButton("Commencer la partie");
		commencer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				commencer_partie = new Partie(liste_couleur, liste_taille, liste_vitesse, f1);
				f1.getContentPane().setVisible(false);
				f1.getContentPane().removeAll();
				f1.getContentPane().add(commencer_partie);
				f1.getContentPane().setVisible(true);
				
			}
		});
		bas.add(commencer,c2);
		
		
		container.add(bas, X2);
		
		add(container, BorderLayout.CENTER);
				
	}
	
	public void choix_billes(final int num_bille){
		
		liste_couleur.add(num_bille-1, "Bleu");
		liste_taille.add(num_bille-1, "Petite");
		liste_vitesse.add(num_bille-1, "Lente");
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = num_bille;
		c.insets = new Insets(10, 10, 10, 10);
		
		JLabel nom_bille = new JLabel("Bille " + num_bille);
		tab.add(nom_bille,c);
		
		final JComboBox couleur = new JComboBox(new String[] {"Bleu","Rouge","Vert","Jaune"});
		couleur.setEditable(false);
		couleur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				liste_couleur.set(num_bille-1, (String) couleur.getSelectedItem());
			}
		});
		tab.add(couleur,c);
		
		final JComboBox taille = new JComboBox(new String[] {"Petite","Moyenne","Grande"});
		taille.setEditable(false);
		taille.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				liste_taille.set(num_bille-1, (String) taille.getSelectedItem());
			}
		});
		tab.add(taille, c);
			
		final JComboBox vitesse = new JComboBox(new String[] {"Lente","Moyenne","Rapide"});
		vitesse.setEditable(false);
		vitesse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				liste_vitesse.set(num_bille-1, (String) vitesse.getSelectedItem());
			}
		});
		tab.add(vitesse,c);
	
	}
	
	public void afficher(){
		String couleur = "Couleur : ";
		for(int i=0; i < liste_couleur.size(); i++){
			couleur=couleur + i + ":" + liste_couleur.get(i);
		}
		System.out.println(couleur);
		
		String taille = "Taille : ";
		for(int i=0; i < liste_taille.size(); i++){
			taille=taille + i + ":" + liste_taille.get(i);
		}
		System.out.println(taille);
		
		String vitesse = "Vitesse : ";
		for(int i=0; i < liste_vitesse.size(); i++){
			vitesse=vitesse + i + ":" + liste_vitesse.get(i);
		}
		System.out.println(vitesse);
	}
	
}
