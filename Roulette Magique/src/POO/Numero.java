package POO;

public class Numero extends Case {

	// Attributs
	protected int num;

	/**
	 * Constructeur d'une Case Numéro, affecte son numéro et son coef
	 * multiplicateur
	 * 
	 * @param coef
	 * @param num1
	 */
	public Numero(int coef, int num1) {
		super(coef);
		num = num1;
	}

}
