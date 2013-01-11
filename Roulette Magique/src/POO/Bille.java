package POO;

public class Bille {

	//Attributs
	private String couleur;
	private int	taille;
	private int vitesse;
	private int num_bille;
	
	//Constructeur
	public Bille(int num_bille, String couleur, int taille, int vitesse){
		this.setNum_bille(num_bille);
		this.setCouleur(couleur);
		this.setTaille(taille); 
		this.setVitesse(vitesse);
	}
	
	public Bille(int num_bille){
		this.setNum_bille(num_bille);
		couleur = "bleu";
		taille = 1;
		vitesse = 1;
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

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getNum_bille() {
		return num_bille;
	}

	public void setNum_bille(int num_bille) {
		this.num_bille = num_bille;
	}
	
}
