package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class NouvellePartie extends JPanel {

	private int nb_billes_select = 1;
	private Partie c;
	private JPanel tab = new JPanel();

	public NouvellePartie(final Fenetre f1) {

		setLayout(new BorderLayout());
		tab.setLayout(new GridBagLayout());
		tab.setBackground(new Color(17, 53, 100));

		/*
		 * ____________________________________________________________________________________________
		 * Nouvelle Partie
		 * _____________________________________________________________________________________________
		 */
		JLabel lab = new JLabel(new ImageIcon(getClass().getResource(
				"accueil.png")));
		tab.add(lab, positionnement(0, 0, 1, 1));

		/*
		 * ____________________________________________________________________________________________
		 * Choisir le nombre de billes
		 * _____________________________________________________________________________________________
		 */

		JPanel choix_nb_billes = new JPanel();
		choix_nb_billes.setBackground(new Color(17, 53, 100));
		choix_nb_billes.setLayout(new BoxLayout(choix_nb_billes,
				BoxLayout.X_AXIS));
		JLabel choisir_label = new JLabel("Choisir le nombre de billes : ");
		choisir_label.setFont(new Font("Arial", Font.PLAIN, 24));
		choisir_label.setForeground(Color.WHITE);
		choix_nb_billes.add(choisir_label);

		final JComboBox nb_billes_selector = new JComboBox(new Integer[] { 1,
				2, 3, 4 });
		nb_billes_selector.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nb_billes_select = (Integer) nb_billes_selector
						.getSelectedItem();

			}
		});
		choix_nb_billes.add(nb_billes_selector);

		tab.add(choix_nb_billes, positionnement(2, 0, 1, 1));

		/*
		 * ____________________________________________________________________________________________
		 * Commencer partie
		 * _____________________________________________________________________________________________
		 */

		GridBagConstraints c4 = new GridBagConstraints();
		c4.gridy = 2;
		c4.insets = new Insets(10, 10, 10, 10);
		c4.gridwidth = 2;

		JButton bouton_commencer = new JButton("Commencer la partie");
		bouton_commencer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c = new Partie(nb_billes_select, f1);
				JScrollPane pane = new JScrollPane();
				pane.setViewportView(c);
				f1.getContentPane().setVisible(false);
				f1.getContentPane().removeAll();
				f1.getContentPane().add(pane);
				f1.getContentPane().setVisible(true);

			}
		});
		tab.add(bouton_commencer, positionnement(3, 0, 1, 1));
		add(tab, BorderLayout.CENTER);

	}

	/*
	 * ____________________________________________________________________________________________
	 * Fonction de positionnement
	 * _____________________________________________________________________________________________
	 */
	public GridBagConstraints positionnement(int y, int x, int largeur,
			int hauteur) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = y;
		c.gridx = x;
		c.gridwidth = largeur;
		c.gridheight = hauteur;
		c.insets = new Insets(10, 10, 10, 10);
		return c;
	}

}
