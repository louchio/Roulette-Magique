package IHM;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class NouvellePartie extends JPanel
{

	private int nb_billes_select = 1;
	private ChoixBilles c;
	private JPanel tab = new JPanel();
	
	public NouvellePartie(final Fenetre f1)
	{
		
		setLayout(new BorderLayout());
		tab.setLayout(new GridBagLayout());
		
		
/*____________________________________________________________________________________________
 								Nouvelle Partie
 _____________________________________________________________________________________________*/
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridy = 0;
		c1.insets = new Insets(10, 10, 100, 10);
		c1.gridwidth = 2;
		
		JLabel texte = new JLabel("Nouvelle Partie");
		texte.setFont(new Font(getName(), Font.BOLD, 48));
		tab.add(texte,c1);
		
		
/*____________________________________________________________________________________________
								Choisir le nombre de billes
_____________________________________________________________________________________________*/
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridy = 1;
		c2.insets = new Insets(10, 10, 100, 10);
		c2.anchor = GridBagConstraints.LINE_END;
	
		JLabel choisir = new JLabel("Choir le nombre de billes : ");
		tab.add(choisir,c2);
		
		
/*____________________________________________________________________________________________
									Selector
_____________________________________________________________________________________________*/		
		GridBagConstraints c3 = new GridBagConstraints();
		c3.gridy = 1;
		c3.insets = new Insets(10, 10, 100, 10);
//		c3.anchor = GridBagConstraints.LINE_START;
		
		final JComboBox<Integer> nb_billes_selector = new JComboBox<Integer>(new Integer[] {1,2,3,4});
		nb_billes_selector.setEditable(false);
		nb_billes_selector.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nb_billes_select =  (Integer) nb_billes_selector.getSelectedItem();
				
			}
		});
		tab.add(nb_billes_selector,c3);
					
/*____________________________________________________________________________________________
								Commencer partie
_____________________________________________________________________________________________*/		
		
		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridy = 2;
		c4.insets = new Insets(10, 10, 10, 10);
		c4.gridwidth = 2;
		
		JButton bouton_commencer = new JButton("Choisir les billes");
		bouton_commencer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c = new ChoixBilles(nb_billes_select, f1);
				f1.getContentPane().setVisible(false);
				f1.getContentPane().removeAll();
				f1.getContentPane().add(c);
				f1.getContentPane().setVisible(true);
				
			}
		});
		tab.add(bouton_commencer,c4);
		add(tab, BorderLayout.CENTER);
	
	}
}
