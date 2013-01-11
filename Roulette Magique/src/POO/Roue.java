package POO;
import java.util.ArrayList;


public class Roue {

	//Attributs
	private int nb_billes;
	private Bille [] tab;
	
	//Constructeur
	public Roue(int nb_billes){
		this.nb_billes = nb_billes;
		tab = new Bille [nb_billes];
		for(int i=0; i<nb_billes; i++){
			tab[i] = new Bille(i);
		}
	}
	
	//Fonctions
	public ArrayList<Integer> Tourner_roue(){
		ArrayList<Integer> l = new ArrayList<Integer>();
//		for( int i = 0; i < nb_billes; i++){
//			l.add(tab[i].LancerBille());
//		}
		l.add(4);
		l.add(10);
		return l;
	    
	}
	
	public int getNb_billes() {
		return nb_billes;
	}

	public void setNb_billes(int nb_billes) {
		this.nb_billes = nb_billes;
	}
}
