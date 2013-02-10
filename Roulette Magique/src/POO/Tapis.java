package POO;


public class Tapis {

	//Attributs 
	private int nb_case = 41;
	private Case [] tab;
	private Integer[][] tab_cheval;
	private Integer[] tab_transversale;
	private Integer[][][][] tab_carre;
	private Integer[] tab_sizain;
	private Integer[] tab_douzaine;
	private Integer[] tab_colonne;
	
	//Constructeur
	public Tapis(){
		tab = new Case [nb_case];
		for(int i=0; i<37; i++){
			tab[i] = new Numero(35, i);
		}
		tab[37] = new ChanceSimple(1, "Impair");
		tab[38] = new ChanceSimple(1, "Pair");
		tab[39] = new ChanceSimple(1, "Manque");
		tab[40] = new ChanceSimple(1, "Passe");
		tab_cheval = new Integer [37][37];
		tab_transversale = new Integer [13];
		tab_carre = new Integer [37][37][37][37];
		tab_sizain = new Integer [7];
		tab_douzaine = new Integer [4];
		tab_colonne = new Integer [4];
		remettre_a_zero();
		
	}
	
	//Fonctions
	public String toString(){
		String affiche = "";
		for(int i = 0; i<nb_case; i++){
			affiche = affiche + tab[i].toString() + " ; ";
		}
		return affiche;		
	}
	
	public void MiserCase(int somme, int num){
		tab[num].setMise(tab[num].getMise()+somme);
	}
	
	public void MiserCheval(int somme, int num1, int num2){
		tab_cheval[num1][num2] = tab_cheval[num1][num2] + somme;
	}
	
	public void MiserTransversale(int somme, int ligne){
		tab_transversale[ligne] = tab_transversale[ligne] + somme;
	}
	
	public void MiserCarre(int somme, int num1, int num2, int num3, int num4){
		tab_carre[num1][num2][num3][num4] = tab_carre[num1][num2][num3][num4] + somme;
	}
	
	public void MiserSizain(int somme, int ligne){
		tab_sizain[ligne] = tab_sizain[ligne] + somme;
	}
	
	public void MiserDouzaine(int somme, int ligne){
		tab_douzaine[ligne] = tab_douzaine[ligne] + somme;
	}
	
	public void MiserColonne(int somme, int colonne){
		tab_colonne[colonne] = tab_colonne[colonne] + somme;
	}
	
	public int CalculerGainCase(int num_tombe) {
		int gain = 0;
		
		if(tab[num_tombe].getMise() != 0){
			gain = gain + ((tab[num_tombe].getMise()*tab[num_tombe].getCoefMultiplicateur())+tab[num_tombe].getMise());
		}
		
		if(tab[37].getMise() != 0){
			if(num_tombe%2 == 1 && num_tombe != 0){
				gain = gain + ((tab[37].getMise()*tab[37].getCoefMultiplicateur())+tab[37].getMise());
			}
			else if(num_tombe == 0){
				gain = gain + tab[37].getMise()/2;
			}
		}
		if(tab[38].getMise() != 0){
			if(num_tombe%2 == 0 && num_tombe !=0){
				gain = gain + ((tab[38].getMise()*tab[38].getCoefMultiplicateur())+tab[38].getMise());
			}
			else if(num_tombe == 0){
				gain = gain + tab[38].getMise()/2;
			}
		}
		if(tab[39].getMise() !=0){
			if(num_tombe < 19 && num_tombe != 0){
				gain = gain + ((tab[39].getMise()*tab[39].getCoefMultiplicateur())+tab[39].getMise());
			}
			else if(num_tombe == 0){
				gain = gain + tab[39].getMise()/2;
			}
		}
		if(tab[40].getMise() !=0){
			if(num_tombe > 18){
				gain = gain + ((tab[39].getMise()*tab[39].getCoefMultiplicateur())+tab[39].getMise());
			}
			else if(num_tombe == 0){
				gain = gain + tab[40].getMise()/2;
			}
		}

		return gain;
	}
	
	public int CalculerGainCheval(int num_tombe){
		int gain = 0;
		
		for(int i=0; i<37; i++){
			for(int j=0; j<37; j++){
				if((num_tombe == i || num_tombe == j) && tab_cheval[i][j] != null){
					gain = gain + ((17 * tab_cheval[i][j]) + tab_cheval[i][j]);
				}
			}
		}
		return gain;
	}
	
	public int CalculerGainTransversale(int num_tombe){
		int gain = 0;

		
		switch (num_tombe){
			
		case 1: case 2: case 3:
			if(tab_transversale[1] != null){ gain = gain + ((11 * tab_transversale[1]) + tab_transversale[1]);}
			break;
		case 4: case 5: case 6:
			if(tab_transversale[2] != null){ gain = gain + ((11 * tab_transversale[2]) + tab_transversale[2]);}
			break;
		case 7: case 8: case 9:
			if(tab_transversale[3] != null){ gain = gain + ((11 * tab_transversale[3]) + tab_transversale[3]);}
			break;
		case 10: case 11: case 12:
			if(tab_transversale[4] != null){ gain = gain + ((11 * tab_transversale[4]) + tab_transversale[4]);}
			break;
		case 13: case 14: case 15:
			if(tab_transversale[5] != null){ gain = gain + ((11 * tab_transversale[5]) + tab_transversale[5]);}
			break;
		case 16: case 17: case 18:
			if(tab_transversale[6] != null){ gain = gain + ((11 * tab_transversale[6]) + tab_transversale[6]);}
			break;
		case 19: case 20: case 21:
			if(tab_transversale[7] != null){ gain = gain + ((11 * tab_transversale[7]) + tab_transversale[7]);}
			break;
		case 22: case 23: case 24:
			if(tab_transversale[8] != null){ gain = gain + ((11 * tab_transversale[8]) + tab_transversale[8]);}
			break;
		case 25: case 26: case 27:
			if(tab_transversale[9] != null){ gain = gain + ((11 * tab_transversale[9]) + tab_transversale[9]);}
			break;
		case 28: case 29: case 30:
			if(tab_transversale[10] != null){ gain = gain + ((11 * tab_transversale[10]) + tab_transversale[10]);}
			break;
		case 31: case 32: case 33:
			if(tab_transversale[11] != null){ gain = gain + ((11 * tab_transversale[11]) + tab_transversale[11]);}
			break;
		case 34: case 35: case 36:
			if(tab_transversale[12] != null){ gain = gain + ((11 * tab_transversale[12]) + tab_transversale[12]);}
			break;
		}
		
		return gain; 
	}
	
	public int CalculerGainCarre(int num_tombe){
		int gain = 0;
		for(int i=0; i<37; i++){
			for(int j=0; j<37; j++){
				for(int k=0; k<37; k++){
					for(int l=0; l<37; l++){
						if((num_tombe == i || num_tombe == j || num_tombe == k || num_tombe == l) && tab_carre[i][j][k][l] != null){
							gain = gain + ((8 * tab_carre[i][j][k][l]) + tab_carre[i][j][k][l]);
						}
					}
				}
			}
		}
		return gain;
	}
	
	public int CalculerGainSizain(int num_tombe){
		int gain = 0;
		
		switch (num_tombe){
		
		case 1: case 2: case 3: case 4: case 5: case 6:
			if(tab_sizain[1] != null){ gain = gain + ((5 * tab_sizain[1]) + tab_sizain[1]);}
			break;
		case 7: case 8: case 9: case 10: case 11: case 12:
			if(tab_sizain[2] != null){ gain = gain + ((5 * tab_sizain[2]) + tab_sizain[2]);}
			break;
		case 13: case 14: case 15: case 16: case 17: case 18:
			if(tab_sizain[3] != null){ gain = gain + ((5 * tab_sizain[3]) + tab_sizain[3]);}
			break;
		case 19: case 20: case 21: case 22: case 23: case 24:
			if(tab_sizain[4] != null){ gain = gain + ((5 * tab_sizain[4]) + tab_sizain[4]);}
			break;
		case 25: case 26: case 27: case 28: case 29: case 30:
			if(tab_sizain[5] != null){ gain = gain + ((5 * tab_sizain[5]) + tab_sizain[5]);}
			break;
		case 31: case 32: case 33: case 34: case 35: case 36:
			if(tab_sizain[6] != null){ gain = gain + ((5 * tab_sizain[6]) + tab_sizain[6]);}
			break;
		}
		
		return gain;
	}
	
	public int CalculerGainDouzaine(int num_tombe){
		int gain = 0;
		
		switch (num_tombe){
		
		case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11: case 12:
			if(tab_douzaine[1] != null){ gain = gain + ((2 * tab_douzaine[1]) + tab_douzaine[1]);}
			break;
		case 13: case 14: case 15: case 16: case 17: case 18: case 19: case 20: case 21: case 22: case 23: case 24:
			if(tab_douzaine[2] != null){ gain = gain + ((2 * tab_douzaine[2]) + tab_douzaine[2]);}
			break;
		case 25: case 26: case 27: case 28: case 29: case 30: case 31: case 32: case 33: case 34: case 35: case 36:
			if(tab_douzaine[3] != null){ gain = gain + ((2 * tab_douzaine[3]) + tab_douzaine[3]);}
			break;
		}
		
		return gain;
	}
	
	public int CalculerGainColonne(int num_tombe){
		int gain = 0;
		
		switch (num_tombe){
		
		case 1: case 4: case 7: case 10: case 13: case 16: case 19: case 22: case 25: case 28: case 31: case 34:
			if(tab_colonne[1] != null){ gain = gain + ((2 * tab_colonne[1]) + tab_colonne[1]);}
			break;
		case 2: case 5: case 8: case 11: case 14: case 17: case 20: case 23: case 26: case 29: case 32: case 35:
			if(tab_colonne[2] != null){ gain = gain + ((2 * tab_colonne[2]) + tab_colonne[2]);}
			break;
		case 3: case 6: case 9: case 12: case 15: case 18: case 21: case 24: case 27: case 30: case 33: case 36:
			if(tab_colonne[3] != null){ gain = gain + ((2 * tab_colonne[3]) + tab_colonne[3]);}
			break;
		}
		
		return gain;
	}

	public void remettre_a_zero(){
		for(int i=0 ; i<41; i++){
			tab[i].setMise(0);
		}
		for(int i=0; i<37; i++){
			for(int j=0; j<37; j++){
					tab_cheval[i][j] = 0;
			}
		}
		for(int i=0 ; i<13; i++){
			tab_transversale[i] = 0;
		}
		for(int i=0; i<37; i++){
			for(int j=0; j<37; j++){
				for(int k=0; k<37; k++){
					for(int l=0; l<37; l++){
						tab_carre[i][j][k][l] = 0;
					}
				}
			}
		}
		for(int i=0 ; i<7; i++){
			tab_sizain[i] = 0;
		}
		for(int i=0 ; i<4; i++){
			tab_douzaine[i] = 0;
			tab_colonne[i] = 0;
		}
		
		
	
		
	}
	
}
