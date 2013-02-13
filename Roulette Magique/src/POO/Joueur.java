package POO;

public class Joueur {

	// Attributs
	private int compte;

	/**
	 * Constructeur de la classe Joueur, affecte le crédit initial du compte
	 * joueur (1000)
	 */
	public Joueur() {
		compte = 1000;
	}

	/**
	 * Ajoute un montant au compte joueur
	 * 
	 * @param montant
	 */
	public void Ajouter(int montant) {
		compte = compte + montant;
	}

	/**
	 * Retire un montant au compte joueur
	 * 
	 * @param montant
	 */
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
