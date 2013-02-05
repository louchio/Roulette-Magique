package POO;

public class Bille {

	//Attributs
	private int num_bille;
	
	//Constructeur
	public Bille(int num_bille){
		this.setNum_bille(num_bille);
	}
	
	//Fonctions
	public int LancerBille(){
		java.util.Random rand = new java.util.Random();
	    int leNombreAleatoire = rand.nextInt(36);
	    return leNombreAleatoire;
	}
	
	public int getNum_bille() {
		return num_bille;
	}

	public void setNum_bille(int num_bille) {
		this.num_bille = num_bille;
	}
	
}
