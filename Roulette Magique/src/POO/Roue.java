package POO;

import java.util.ArrayList;

public class Roue {

	// Attributs
	private static int nb_billes;
	private static Bille[] tab;

	/**
	 * Constructeur de la classe Roue, affecte le nombre de bille de la roue et
	 * crée les billes
	 * 
	 * @param nb_billes
	 */
	public Roue(int nb_billes) {
		Roue.nb_billes = nb_billes;
		tab = new Bille[nb_billes];
		for (int i = 0; i < nb_billes; i++) {
			tab[i] = new Bille(i);
		}
	}

	/**
	 * Permet de tourner la roue, en lancant chaque bille
	 * 
	 * @return ArrayList contenant les numéros de chaque bille
	 */
	public ArrayList<Integer> TournerRoue() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < nb_billes; i++) {
			l.add(tab[i].LancerBille());
		}
		return l;

	}

	public int getNb_billes() {
		return nb_billes;
	}

	public void setNb_billes(int nb_billes) {
		Roue.nb_billes = nb_billes;
	}
}
