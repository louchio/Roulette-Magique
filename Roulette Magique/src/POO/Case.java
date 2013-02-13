package POO;

public abstract class Case {

	// Attributs
	private int CoefMultiplicateur;
	private int Mise;

	/**
	 * Constructeur de la classe Case, affecte le coefficient multiplicateur de
	 * la case et initialise sa mide de départ à zéro
	 * 
	 * @param coef
	 */
	public Case(int coef) {
		setMise(0);
		setCoefMultiplicateur(coef);
	}

	public int getCoefMultiplicateur() {
		return CoefMultiplicateur;
	}

	public void setCoefMultiplicateur(int coefMultiplicateur) {
		CoefMultiplicateur = coefMultiplicateur;
	}

	public int getMise() {
		return Mise;
	}

	public void setMise(int mise) {
		Mise = mise;
	}
}
