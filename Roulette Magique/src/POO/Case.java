package POO;

public abstract class Case {
  
	
	//Attributs
	private int CoefMultiplicateur;
	private int Mise;
	
	//Constructeurs
	public Case(int coef){
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
