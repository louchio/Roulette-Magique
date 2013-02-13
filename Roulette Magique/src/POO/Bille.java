package POO;

public class Bille {

	// Attributs
	private int num_bille;

	/**
	 * Constructeur de la classe Bille : affecte le numéro de la bille
	 * 
	 * @param num_bille
	 */
	public Bille(int num_bille) {
		this.setNum_bille(num_bille);
	}

	/**
	 * Tirer aléatoirement le numéro sur lequel la bille tombe
	 * 
	 * @return int
	 */
	public int LancerBille() {
		java.util.Random rand = new java.util.Random();
		int leNombreAleatoire = rand.nextInt(36);
		return leNombreAleatoire;
	}

	/**
	 * Renvoie le numéro de la bille
	 * 
	 * @return int
	 */
	public int getNum_bille() {
		return num_bille;
	}

	/**
	 * Change le numéro de la bille
	 * 
	 * @param num_bille
	 */
	public void setNum_bille(int num_bille) {
		this.num_bille = num_bille;
	}

}
