package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fin_Partie extends JFrame {
	
	private Fin_Partie fin1;
	
	public Fin_Partie(final Fenetre f){
		fin1 = this;
		setTitle("Fin de Partie");
		setBounds(0, 0, 500, 300);	
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		JPanel p = new JPanel();
		p.setBackground(new Color(17, 53, 100));
		p.setLayout(new GridBagLayout());
		JLabel texte = new JLabel("Partie Terminee, votre credit est epuise");
		texte.setForeground(Color.white);
		p.add(texte, positionnement(0, 0, 2, 1));
	
		EcouteurQuitter e = new EcouteurQuitter();
		
		JButton nouvel = new JButton("Nouvelle Partie");
		JButton quit = new JButton("Quiiter le jeu");
		nouvel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NouvellePartie p = new NouvellePartie(f);
				f.getContentPane().setVisible(false);
				f.getContentPane().removeAll();
				f.getContentPane().add(p);
				f.getContentPane().setVisible(true);
				fin1.setVisible(false);
				fin1.dispose();
				
			}
		});
		quit.addActionListener(e);
		p.add(nouvel, positionnement(1, 0, 1, 1));
		p.add(quit, positionnement(1, 1, 1, 1));
		
		add(p);
	
		setVisible(true);
	}
	
	public GridBagConstraints positionnement(int y, int x, int largeur, int hauteur){
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = y;
		c.gridx = x;
		c.gridwidth = largeur;
		c.gridheight = hauteur;
		c.insets = new Insets(10, 10, 10, 10);
		return c;
	}
	

}
