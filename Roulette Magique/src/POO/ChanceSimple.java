package POO;

public class ChanceSimple extends Case {

	private String nom;

	/**
	 * Constructeur de la classe ChanceSimple (Pair, Impair, Manque, Passe) qui
	 * affecte le nom de la case et son coefficient multiplicateur
	 * 
	 * @param coef
	 * @param nom
	 */
	public ChanceSimple(int coef, String nom) {
		super(coef);
		this.nom = nom;

	}

	public String toString() {
		return nom;
	}

}
