package POO;

public class Joueur {

	// Attributs
	private int compte;

	// Constructeur
	public Joueur() {
		compte = 1000;
	}

	// Fonctions
	public void Ajouter(int montant) {
		compte = compte + montant;
	}

	public void Retirer(int montant) {
		compte = compte - montant;
	}

	public int getCompte() {
		return compte;
	}

	public void setCompte(int compte) {
		this.compte = compte;
	}
}
