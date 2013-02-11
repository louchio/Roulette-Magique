package POO;

public class Numero extends Case {

	// Attributs
	protected int num;

	// Constructeur
	public Numero(int coef, int num1) {
		super(coef);
		num = num1;
	}

	// Fonction
	public String toString() {
		String affiche = "[" + num + "]";
		return affiche;
	}

}
