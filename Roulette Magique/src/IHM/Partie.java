package IHM;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import POO.Jeu;

@SuppressWarnings("serial")
public class Partie extends JPanel{
	
	//Attributs
	private int nb_billes;
	private ArrayList<Integer> liste_somme = new ArrayList<Integer>();
	private ArrayList<Integer> liste_bille = new ArrayList<Integer>();
	private ArrayList<Integer> liste_num1 = new ArrayList<Integer>();
	private ArrayList<Integer> liste_num2 = new ArrayList<Integer>();
	private ArrayList<Integer> liste_num3 = new ArrayList<Integer>();
	private ArrayList<Integer> liste_num4 = new ArrayList<Integer>();
	private ArrayList<String> liste_mise = new ArrayList<String>();
	private Integer[] liste_numero = new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
	private JPanel tab = new JPanel();
	private final JPanel chance_multiple = new JPanel();
	private JLabel mise;
	private Jeu partie;
	private JRadioButton numero_button = new JRadioButton("Num้ro");
	private JRadioButton cheval_button = new JRadioButton("Cheval");
	private JRadioButton transversale_button = new JRadioButton("Transversale");
	private JRadioButton carre_button = new JRadioButton("Carr้");
	private JRadioButton sizain_button = new JRadioButton("Sizain");
	private JRadioButton douzaine_button = new JRadioButton("Douzaine");
	private JRadioButton colonne_button = new JRadioButton("Colonne");
	private JRadioButton pair_button = new JRadioButton("Pair");
	private JRadioButton impair_button = new JRadioButton("Impair");
	private JRadioButton manque_button = new JRadioButton("Manque");
	private JRadioButton passe_button = new JRadioButton("Passe");
	private JComboBox numero_selector = new JComboBox(liste_numero);
	private JComboBox numero_cheval_selector_1 = new JComboBox(liste_numero);
	private JComboBox numero_cheval_selector_2 = new JComboBox(liste_numero);
	private JComboBox transversale_selector = new JComboBox(new String[]{"1,2,3","4,5,6","7,8,9","10,11,12","13,14,15","16,17,18","19,20,21","22,23,24","25,26,27","28,29,30","31,32,33","34,35,36"});
	private JComboBox numero_carre_selector_1 = new JComboBox(liste_numero);
	private JComboBox numero_carre_selector_2 = new JComboBox(liste_numero);
	private JComboBox numero_carre_selector_3 = new JComboBox(liste_numero);
	private JComboBox numero_carre_selector_4 = new JComboBox(liste_numero);
	private JComboBox sizain_selector = new JComboBox(new String[] {"1-6","7-12","13-18","19-24","25-30","31-36"});
	private JComboBox douzaine_selector = new JComboBox(new String[] {"1-12","13-24","26-36"});
	private JComboBox colonne_selector = new JComboBox(new String[] {"Colonne 1", "Colonne 2", "Colonne 3"});
	private JComboBox num_bille_selector = new JComboBox();
	private DefaultListModel listmodel = new DefaultListModel();
	private JList list = new JList(listmodel);
	private JLabel solde;
	private JPopupMenu supprimer_menu;
	private JMenuItem supprimer;
	public JLabel num_tombe_bille1 = new JLabel("0");
	public JLabel num_tombe_bille2 = new JLabel("0");
	public JLabel num_tombe_bille3 = new JLabel("0");
	public JLabel num_tombe_bille4 = new JLabel("0");
	JLabel gain = new JLabel("0");
	
	//Constructeurs
	public Partie(ArrayList<String> liste_couleur, ArrayList<String> liste_taille, ArrayList<String> liste_vitesse, Fenetre f1){
		
		nb_billes = liste_couleur.size();
		
		partie = new Jeu(liste_couleur, liste_taille, liste_vitesse);
		
		setLayout(new BorderLayout());
		
		tab.setLayout(new GridBagLayout());
				
		tab.add(new JLabel("Type de mise"), positionnement(0, 0, 7, 1));
				
		ButtonGroup groupe = new ButtonGroup();
		groupe.add(numero_button);
		groupe.add(cheval_button);
		groupe.add(transversale_button);
		groupe.add(carre_button);
		groupe.add(sizain_button);
		groupe.add(douzaine_button);
		groupe.add(colonne_button);
		groupe.add(pair_button);
		groupe.add(impair_button);
		groupe.add(manque_button);
		groupe.add(passe_button);
		
		JPanel chance_simple_panel = new JPanel();
		chance_simple_panel.setLayout(new BoxLayout(chance_simple_panel, BoxLayout.X_AXIS));
		chance_simple_panel.add(pair_button);
		chance_simple_panel.add(impair_button);
		chance_simple_panel.add(manque_button);
		chance_simple_panel.add(passe_button);
		tab.add(chance_simple_panel, positionnement(1, 0, 7, 1));
		
		tab.add(numero_button, positionnement(2, 0, 1, 1));
		tab.add(cheval_button, positionnement(2, 1, 1, 1));
		tab.add(transversale_button, positionnement(2, 2, 1, 1));
		tab.add(carre_button, positionnement(2, 3, 1, 1));
		tab.add(sizain_button, positionnement(2, 4, 1, 1));
		tab.add(douzaine_button, positionnement(2, 5, 1, 1));
		tab.add(colonne_button, positionnement(2, 6, 1, 1));

		chance_multiple.setLayout(new CardLayout());

		JPanel cheval_selector = new JPanel();
		cheval_selector.setLayout(new BoxLayout(cheval_selector, BoxLayout.X_AXIS));
		cheval_selector.add(numero_cheval_selector_1);
		cheval_selector.add(numero_cheval_selector_2);
		
		JPanel carre_selector = new JPanel();
		carre_selector.setLayout(new BoxLayout(carre_selector, BoxLayout.X_AXIS));
		carre_selector.add(numero_carre_selector_1);
		carre_selector.add(numero_carre_selector_2);
		carre_selector.add(numero_carre_selector_3);
		carre_selector.add(numero_carre_selector_4);
			
		chance_multiple.add("numero", numero_selector);
		chance_multiple.add("cheval", cheval_selector);
		chance_multiple.add("transversale", transversale_selector);
		chance_multiple.add("carre", carre_selector);
		chance_multiple.add("sizain", sizain_selector);
		chance_multiple.add("douzaine", douzaine_selector);
		chance_multiple.add("colonne", colonne_selector);
		
		tab.add(chance_multiple, positionnement(3, 0, 2, 1));
		
		
		pair_button.addActionListener(cardlayout_simple());
		impair_button.addActionListener(cardlayout_simple());
		passe_button.addActionListener(cardlayout_simple());
		manque_button.addActionListener(cardlayout_simple());
		numero_button.addActionListener(cardlayout("numero"));
		cheval_button.addActionListener(cardlayout("cheval"));
		transversale_button.addActionListener(cardlayout("transversale"));
		carre_button.addActionListener(cardlayout("carre"));
		sizain_button.addActionListener(cardlayout("sizain"));
		douzaine_button.addActionListener(cardlayout("douzaine"));
		colonne_button.addActionListener(cardlayout("colonne"));
		
		tab.add(new JLabel("Choix Bille :"), positionnement(3, 2, 1, 1));
		
		
		num_bille_selector.addItem("Toute les billes");
		for(int i=0; i<nb_billes; i++){
			num_bille_selector.addItem("Bille "+(i+1));
		}
		tab.add(num_bille_selector, positionnement(3, 3, 1, 1));
		
		JButton moins = new JButton("-");
		mise = new JLabel(Integer.toString(nb_billes*2));
		JButton plus = new JButton("+");
		
		moins.addActionListener(moins_listener());
		plus.addActionListener(plus_listener());
		
		tab.add(moins, positionnement(3, 4, 1, 1));
		tab.add(mise, positionnement(3, 5, 1, 1));
		tab.add(plus, positionnement(3, 6, 1, 1));
		
		JButton miser = new JButton("Miser");
		JButton tourner = new JButton("Tourner Roue");
		
		miser.addActionListener(miser_listener());
		tourner.addActionListener(tourner_listener());
		
		
		tab.add(miser, positionnement(4, 0, 2, 1));
		tab.add(tourner, positionnement(4, 3, 2, 1));
		
		JPanel solde_panel = new JPanel();
		solde_panel.setLayout(new BoxLayout(solde_panel, BoxLayout.X_AXIS));
		solde_panel.add(new JLabel("Solde : "));
		solde = new JLabel(Integer.toString(partie.solde_compte()));
		solde_panel.add(solde);
		tab.add(solde_panel, positionnement(0, 7, 1, 1));
		tab.add(list,positionnement(1, 7, 1, 4));
		
		supprimer_menu = new JPopupMenu();
		supprimer = new JMenuItem("Supprimer");
		supprimer_menu.add(supprimer);
		supprimer.addActionListener(supprimer_listener());

		list.addMouseListener(new MouseAdapter(){

	        public void mousePressed(MouseEvent e) {

	            if (SwingUtilities.isLeftMouseButton(e)) {

	                supprimer_menu.show(e.getComponent(), e.getX(), e.getY());

	            }

	        } 

	    }); 
		
		JLabel nom_bille1 = new JLabel("Bille 1");
		tab.add(nom_bille1,positionnement(5, 0, 1, 1));
		tab.add(num_tombe_bille1,positionnement(6, 0, 1, 1));
		
		JLabel nom_bille2 = new JLabel("Bille 2");
		if(nb_billes < 2){nom_bille2.setVisible(false);num_tombe_bille2.setVisible(false);}
		tab.add(nom_bille2,positionnement(5, 1, 1, 1));
		tab.add(num_tombe_bille2,positionnement(6, 1, 1, 1));
		
		JLabel nom_bille3 = new JLabel("Bille 3");
		if(nb_billes < 3){nom_bille3.setVisible(false);num_tombe_bille3.setVisible(false);}
		tab.add(nom_bille3,positionnement(5, 2, 1, 1));
		tab.add(num_tombe_bille3,positionnement(6, 2, 1, 1));
		
		JLabel nom_bille4 = new JLabel("Bille 4");
		if(nb_billes < 4){nom_bille4.setVisible(false);num_tombe_bille4.setVisible(false);}
		tab.add(nom_bille4,positionnement(5, 3, 1, 1));
		tab.add(num_tombe_bille4,positionnement(6, 3, 1, 1));
		
		JLabel gain_label = new JLabel("Gain : ");
		tab.add(gain_label,positionnement(5, 5, 1, 2));
		tab.add(gain,positionnement(5, 6, 1, 2));
		
		add(tab, BorderLayout.CENTER);
	}

	//Fonctions
	public GridBagConstraints positionnement(int y, int x, int largeur, int hauteur){
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = y;
		c.gridx = x;
		c.gridwidth = largeur;
		c.gridheight = hauteur;
		c.insets = new Insets(10, 10, 10, 10);
		return c;
	}
	
	public ActionListener cardlayout(final String s1){
		ActionListener s = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chance_multiple.setVisible(true); 
				((CardLayout) chance_multiple.getLayout()).show(chance_multiple,s1); 
				
			}
		};
		return s;
	}
	
	public ActionListener cardlayout_simple(){
		ActionListener s = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chance_multiple.setVisible(false);
				
			}
		};
		return s;
	}
	
	public ActionListener plus_listener(){
		ActionListener s = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp = Integer.parseInt(mise.getText());
				if(temp+2 <= partie.solde_compte()){
					temp = temp + 2;
					mise.setText(Integer.toString(temp));
				}
			}
		};
		return s;
	}
	
	public ActionListener moins_listener(){
		ActionListener s = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp = Integer.parseInt(mise.getText());
				if(temp-2 >= nb_billes*2){
					temp = temp - 2;
					mise.setText(Integer.toString(temp));
				}
				
			}
		};
		return s;
	}
	
	public ActionListener miser_listener(){
		ActionListener s = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(mise.getText()) <= partie.solde_compte()){
					if(pair_button.isSelected()){
						partie.MiserPair(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()));
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur Pair");
						liste_mise.add("pair");
						liste_num1.add(-1);
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(impair_button.isSelected()){
						partie.MiserImpair(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()));
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur Impair");
						liste_mise.add("impair");
						liste_num1.add(-1);
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(manque_button.isSelected()){
						partie.MiserImpair(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()));
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur Manque");
						liste_mise.add("manque");
						liste_num1.add(-1);
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(passe_button.isSelected()){
						partie.MiserImpair(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()));
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur Passe");
						liste_mise.add("passe");
						liste_num1.add(-1);
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(numero_button.isSelected()){
						partie.MiserNumero(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()), num_bille_selector.getSelectedIndex());
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur " + numero_selector.getSelectedIndex());
						liste_mise.add("numero");
						liste_num1.add(num_bille_selector.getSelectedIndex());
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(cheval_button.isSelected()){
						partie.MiserCheval(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()), numero_cheval_selector_1.getSelectedIndex(), numero_cheval_selector_2.getSelectedIndex());
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur " + numero_cheval_selector_1.getSelectedIndex() + "," + numero_cheval_selector_2.getSelectedIndex());
						liste_mise.add("cheval");
						liste_num1.add(numero_cheval_selector_1.getSelectedIndex());
						liste_num2.add(numero_cheval_selector_2.getSelectedIndex());
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(transversale_button.isSelected()){
						partie.MiserTransversale(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()), transversale_selector.getSelectedIndex()+1);
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur " + transversale_selector.getSelectedItem());
						liste_mise.add("transversale");
						liste_num1.add(transversale_selector.getSelectedIndex()+1);
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(carre_button.isSelected()){
						partie.MiserCarre(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()), numero_carre_selector_1.getSelectedIndex(), numero_carre_selector_2.getSelectedIndex(), numero_carre_selector_3.getSelectedIndex(), numero_carre_selector_4.getSelectedIndex());
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur " + numero_carre_selector_1.getSelectedIndex() + "," + numero_carre_selector_2.getSelectedIndex() + "," + numero_carre_selector_3.getSelectedIndex() + "," + numero_carre_selector_4.getSelectedIndex());
						liste_mise.add("carre");
						liste_num1.add(numero_carre_selector_1.getSelectedIndex());
						liste_num2.add(numero_carre_selector_2.getSelectedIndex());
						liste_num3.add(numero_carre_selector_3.getSelectedIndex());
						liste_num4.add(numero_carre_selector_4.getSelectedIndex());
					}
					if(sizain_button.isSelected()){
						partie.MiserSizain(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()), sizain_selector.getSelectedIndex()+1);
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur " + sizain_selector.getSelectedItem());
						liste_mise.add("sizain");
						liste_num1.add(sizain_selector.getSelectedIndex()+1);
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(douzaine_button.isSelected()){
						partie.MiserDouzaine(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()), douzaine_selector.getSelectedIndex()+1);
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur " + douzaine_selector.getSelectedItem());
						liste_mise.add("douzaine");
						liste_num1.add(douzaine_selector.getSelectedIndex()+1);
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					if(colonne_button.isSelected()){
						partie.MiserColonne(num_bille_selector.getSelectedIndex(), Integer.parseInt(mise.getText()), colonne_selector.getSelectedIndex()+1);
						listmodel.addElement(num_bille_selector.getSelectedItem() + " "   + mise.getText() + " sur " + colonne_selector.getSelectedItem());
						liste_mise.add("colonne");
						liste_num1.add(colonne_selector.getSelectedIndex()+1);
						liste_num2.add(-1);
						liste_num3.add(-1);
						liste_num4.add(-1);
					}
					solde.setText(Integer.toString(partie.solde_compte()));
					liste_somme.add(Integer.parseInt(mise.getText()));
					liste_bille.add(num_bille_selector.getSelectedIndex());
				}
				
			}
		};
		return s;
	}
	
	public ActionListener supprimer_listener(){
		ActionListener s = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				if(liste_mise.get(i) == "pair")partie.MiserPair(liste_bille.get(i), 0);
				if(liste_mise.get(i) == "impair")partie.MiserImpair(liste_bille.get(i), 0);
				if(liste_mise.get(i) == "passe")partie.MiserPasse(liste_bille.get(i), 0);
				if(liste_mise.get(i) == "manque")partie.MiserManque(liste_bille.get(i), 0);
				if(liste_mise.get(i) == "numero")partie.MiserNumero(liste_bille.get(i), 0, liste_num1.get(i));
				if(liste_mise.get(i) == "transversale")partie.MiserTransversale(liste_bille.get(i), 0, liste_num1.get(i));
				if(liste_mise.get(i) == "cheval")partie.MiserCheval(liste_bille.get(i), 0, liste_num1.get(i), liste_num2.get(i));
				if(liste_mise.get(i) == "transversale")partie.MiserTransversale(liste_bille.get(i), 0, liste_num1.get(i));
				if(liste_mise.get(i) == "carre")partie.MiserCarre(liste_bille.get(i), 0, liste_num1.get(i), liste_num2.get(i), liste_num3.get(i), liste_num4.get(i));
				if(liste_mise.get(i) == "sizain")partie.MiserSizain(liste_bille.get(i), 0, liste_num1.get(i));
				if(liste_mise.get(i) == "douzaine")partie.MiserDouzaine(liste_bille.get(i), 0, liste_num1.get(i));
				if(liste_mise.get(i) == "colonne")partie.MiserColonne(liste_bille.get(i), 0, liste_num1.get(i));
				
				partie.ajouter(liste_somme.get(i));
				solde.setText(Integer.toString(partie.solde_compte()));
				liste_somme.remove(i);
				listmodel.remove(i);
				liste_mise.remove(i);
				liste_bille.remove(i);
				liste_num1.remove(i);
				liste_num2.remove(i);
				liste_num3.remove(i);
				liste_num4.remove(i);
			}
		};
		return s;
	}
	
	public ActionListener tourner_listener(){
		ActionListener s = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gain.setText(Integer.toString(partie.CalculerGain(Partie.this))) ;
				solde.setText(Integer.toString(partie.solde_compte()));
				listmodel.removeAllElements();
				partie.RemettreZero();
				
			}
		};
		return s;
	}
}
