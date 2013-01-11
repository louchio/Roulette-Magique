package POO;
import java.util.ArrayList;


public class Tapis {

	//Attributs 
	private int nb_case; 
	private Case [] tab;
	private ArrayList<Integer> num_mise;
	
	//Constructeur
	public Tapis(int nb_case, int nb_billes){
		this.nb_case =nb_case;
		tab = new Case [nb_case];
		for(int i=0; i<nb_case; i++){
			tab[i] = new Numero(35/nb_billes, i);
		}
		num_mise = new ArrayList<Integer>();
		
	}
	
	//Fonctions
	public String toString(){
		String affiche = "";
		for(int i = 0; i<nb_case; i++){
			affiche = affiche + tab[i].toString() + " ; ";
		}
		return affiche;		
	}
	
	public void MiserCase(int somme, int num){
		tab[num].setMise(somme);
		num_mise.add(num);
	}
	
	public int CalculerGainCase(int num_tombe) {
		int gain = 0;
		for(int i = 0; i < num_mise.size(); i++){
			if(num_mise.get(i) == num_tombe){
			gain = gain + ((tab[num_mise.get(i)].getMise()*tab[num_mise.get(i)].getCoefMultiplicateur())+tab[num_mise.get(i)].getMise());
			}
		}
		return gain;
	}
}
