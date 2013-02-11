package POO;

public class ChanceSimple extends Case {

	private String nom;

	public ChanceSimple(int coef, String nom) {
		super(coef);
		this.nom = nom;

	}

	public String toString() {
		return nom;
	}

}
