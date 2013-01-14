package POO;
import java.util.ArrayList;


public class Roue {

	//Attributs
	private int nb_billes;
	private Bille [] tab;
	
	//Constructeur
	public Roue(ArrayList<String> liste_couleur, ArrayList<String> liste_taille, ArrayList<String> liste_vitesse){
		nb_billes = liste_couleur.size();
		tab = new Bille [nb_billes];
		for(int i=0; i<nb_billes; i++){
			tab[i] = new Bille(i, liste_couleur.get(i), liste_taille.get(i), liste_vitesse.get(i));
		}
	}
	
	//Fonctions
	public ArrayList<Integer> Tourner_roue(){
		ArrayList<Integer> l = new ArrayList<Integer>();
//		for( int i = 0; i < nb_billes; i++){
//			l.add(tab[i].LancerBille());
//		}
		l.add(23);
		l.add(11);
//		l.add(0);
		return l;
	    
	}
	
	public int getNb_billes() {
		return nb_billes;
	}

	public void setNb_billes(int nb_billes) {
		this.nb_billes = nb_billes;
	}
}
