package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class A_propos extends JFrame {

	public A_propos() {

		setTitle("A propos");
		setBounds(0, 0, 250, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setFocusable(true);

		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		p.setBackground(new Color(17, 53, 100));

		JLabel l1 = new JLabel("La Roulette Magique");
		JLabel l2 = new JLabel("Projet POO - Polytech 2013 - IRM4");
		JLabel l3 = new JLabel("Sébastien DEMECH - Ali NAJEM");
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.WHITE);
		p.add(l1, positionnement(0, 0, 1, 1));
		p.add(l2, positionnement(1, 0, 1, 1));
		p.add(l3, positionnement(2, 0, 1, 1));

		add(p, BorderLayout.CENTER);
		setVisible(true);

	}

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
