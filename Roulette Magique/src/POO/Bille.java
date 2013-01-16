package POO;

public class Bille {

	//Attributs
	private String couleur;
	private String	taille;
	private String vitesse;
	private int num_bille;
	
	//Constructeur
	public Bille(int num_bille, String couleur, String taille, String vitesse){
		this.setNum_bille(num_bille);
		this.setCouleur(couleur);
		this.setTaille(taille); 
		this.setVitesse(vitesse);
		
	}
	
	//Fonctions
	public int LancerBille(){
		java.util.Random rand = new java.util.Random();
	    int leNombreAleatoire = rand.nextInt(36);
	    System.out.println("Bille " + num_bille +" = " + leNombreAleatoire);
	    return leNombreAleatoire;
	}
	
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getVitesse() {
		return vitesse;
	}

	public void setVitesse(String vitesse) {
		this.vitesse = vitesse;
	}

	public int getNum_bille() {
		return num_bille;
	}

	public void setNum_bille(int num_bille) {
		this.num_bille = num_bille;
	}
	
}
