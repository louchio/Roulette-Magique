package IHM;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Partie extends JPanel{
	
	private ArrayList<String> liste_couleur;
	private ArrayList<String> liste_taille;
	private ArrayList<String> liste_vitesse;
	
	private JPanel tab = new JPanel();
	
	public Partie(ArrayList<String> liste_couleur, ArrayList<String> liste_taille, ArrayList<String> liste_vitesse, Fenetre f1){
		
		this.liste_couleur = liste_couleur;
		this.liste_taille = liste_taille;
		this.liste_vitesse = liste_vitesse;
		
		setLayout(new BorderLayout());
		
		tab.setLayout(new GridBagLayout());
			
		for(int i=0; i<liste_couleur.size(); i++){
			afficher_billes(i);
		}
		
		add(tab, BorderLayout.CENTER);
	}

public void afficher_billes(final int num_bille){
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = num_bille;
		c.insets = new Insets(10, 10, 10, 10);
		
		JLabel nom_bille = new JLabel("Bille " + (num_bille+1));
		tab.add(nom_bille,c);
		
		JLabel couleur = new JLabel(liste_couleur.get(num_bille));
		tab.add(couleur,c);
		
		JLabel taille = new JLabel(liste_taille.get(num_bille));
		tab.add(taille, c);
			
		JLabel vitesse = new JLabel(liste_vitesse.get(num_bille));
		tab.add(vitesse,c);
	
	}
}
