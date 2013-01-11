package POO;
import java.util.ArrayList;


public class Jeu {

	// Attributs
	private Tapis[] tapis;
	private Joueur j1;
	private int nb_billes;
	private Roue r1;

	// Constructeur
	public Jeu(int nb_billes) {
		this.nb_billes = nb_billes;
		tapis = new Tapis[nb_billes];
		for (int i = 0; i < nb_billes; i++) {
			tapis[i] = new Tapis(37, nb_billes);
		}
		j1 = new Joueur();
		r1 = new Roue(nb_billes);
	}

	// Fonctions
	public String AfficherTapis() {
		String affiche = "";
		for (int i = 0; i < nb_billes; i++) {
			affiche = affiche + "Tapis " + i + " : " + tapis[i].toString() +  "\n";
		}
		return affiche;
	}

	public void Miser(int num_tapis, int num, int somme) {
		if(num_tapis == 0){
			for(int i = 0; i < nb_billes; i++){
				tapis[i].MiserCase(somme, num);
				j1.Retirer(somme);
			}
		}
		else
		{
			tapis[num_tapis - 1].MiserCase(somme, num);
			j1.Retirer(somme);
		}
	}

	public int CalculerGain() {
		ArrayList<Integer> num_tombe = r1.Tourner_roue();
		int gain = 0;
		for (int j = 0; j < num_tombe.size(); j++){
				gain = gain + tapis[j].CalculerGainCase(num_tombe.get(j));
		}
		j1.Ajouter(gain);
		System.out.println("Solde j1 :" + j1.getCompte());
		return gain;
	}

}
