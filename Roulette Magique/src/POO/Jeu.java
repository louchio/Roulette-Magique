package POO;
import java.util.ArrayList;

import IHM.Partie;


public class Jeu {

	// Attributs
	private Tapis[] tapis;
	private Joueur j1;
	private int nb_billes;
	private Roue r1;

	// Constructeur
	public Jeu(ArrayList<String> liste_couleur, ArrayList<String> liste_taille, ArrayList<String> liste_vitesse) {
		nb_billes = liste_couleur.size();
		tapis = new Tapis[nb_billes];
		for (int i = 0; i < nb_billes; i++) {
			tapis[i] = new Tapis();
		}
		j1 = new Joueur();
		r1 = new Roue(liste_couleur, liste_taille, liste_vitesse);
	}

	// Fonctions
	public String AfficherTapis() {
		String affiche = "";
		for (int i = 0; i < nb_billes; i++) {
			affiche = affiche + "Tapis " + i + " : " + tapis[i].toString() +  "\n";
		}
		return affiche;
	}

	public int solde_compte(){
		return j1.getCompte();
	}
	
	public void ajouter(int n){
		j1.Ajouter(n);
	}
	
	
	public void MiserNumero(int num_tapis, int somme, int num) {
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserCase(somme/nb_billes, num);
				j1.Retirer(somme/nb_billes);
			}
		}
		else
		{
			tapis[num_tapis - 1].MiserCase(somme, num);
			j1.Retirer(somme);
		}
	}
	
	public void MiserImpair(int num_tapis, int somme){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserCase(somme/nb_billes, 37);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserCase(somme, 37);
			j1.Retirer(somme);
		}
	}
	
	public void MiserPair(int num_tapis, int somme){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserCase(somme/nb_billes, 38);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserCase(somme, 38);
			j1.Retirer(somme);
		}
	}
		
	public void MiserManque(int num_tapis, int somme){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserCase(somme/nb_billes, 39);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserCase(somme, 39);
			j1.Retirer(somme);
		}
	}
	
	public void MiserPasse(int num_tapis, int somme){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserCase(somme/nb_billes, 40);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserCase(somme, 40);
			j1.Retirer(somme);
		}
	}
	
	public void MiserCheval(int num_tapis, int somme, int num1, int num2){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserCheval(somme/nb_billes, num1, num2);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserCheval(somme, num1, num2);
			j1.Retirer(somme);
		}
	}
	
	public void MiserTransversale(int num_tapis, int somme, int ligne){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserTransversale(somme/nb_billes, ligne);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserTransversale(somme, ligne);
			j1.Retirer(somme);
		}
	}
	
	public void MiserCarre(int num_tapis, int somme, int num1, int num2, int num3, int num4){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserCarre(somme/nb_billes, num1, num2, num3, num4);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserCarre(somme, num1, num2, num3, num4);
			j1.Retirer(somme);
		}
	}
	
	public void MiserSizain(int num_tapis, int somme, int ligne){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserSizain(somme/nb_billes, ligne);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserSizain(somme, ligne);
			j1.Retirer(somme);
		}
	}
	
	public void MiserDouzaine(int num_tapis, int somme, int ligne){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserDouzaine(somme/nb_billes, ligne);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserDouzaine(somme, ligne);
			j1.Retirer(somme);
		}
	}
	
	public void MiserColonne(int num_tapis, int somme, int colonne){
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserColonne(somme/nb_billes, colonne);
				j1.Retirer(somme/nb_billes);
			}
		}
		else{
			tapis[num_tapis-1].MiserColonne(somme, colonne);
			j1.Retirer(somme);
		}	
	}

	public int CalculerGain(Partie p) {
		ArrayList<Integer> num_tombe = r1.TournerRoue();
		for(int i = 0; i< nb_billes; i++){
			for(int j=0; j< nb_billes; j++){
				if(i!=j){
					if(num_tombe.get(i)==num_tombe.get(j)){
						num_tombe.clear();
						num_tombe = r1.TournerRoue();}
				}
			}
		}
		int gain = 0;
		for (int j = 0; j < num_tombe.size(); j++){
				gain = gain + tapis[j].CalculerGainCase(num_tombe.get(j));
				gain = gain + tapis[j].CalculerGainCheval(num_tombe.get(j));
				gain = gain + tapis[j].CalculerGainTransversale(num_tombe.get(j));
				gain = gain + tapis[j].CalculerGainCarre(num_tombe.get(j));
				gain = gain + tapis[j].CalculerGainSizain(num_tombe.get(j));
				gain = gain + tapis[j].CalculerGainDouzaine(num_tombe.get(j));
				gain = gain + tapis[j].CalculerGainColonne(num_tombe.get(j));
				switch (j){
				case 0:
					p.num_tombe_bille1.setText(Integer.toString(num_tombe.get(j)));
				case 1:
					p.num_tombe_bille2.setText(Integer.toString(num_tombe.get(j)));
				case 2:
					p.num_tombe_bille3.setText(Integer.toString(num_tombe.get(j)));
				case 3:
					p.num_tombe_bille4.setText(Integer.toString(num_tombe.get(j)));
				}
		}
		j1.Ajouter(gain);
		return gain;
	}

	public void RemettreZero(){
		for(int i = 0; i < nb_billes; i++){
			tapis[i].remettre_a_zero();	
		}
	}
}
