package test;

import java.util.ArrayList;

public class Combat {
	
	private static ArrayList<Monstre> Combattants; // liste des monstres participant au combat
	
	public static int random(int min, int max) {	     
	    return ((int) (Math.random() * (max - min+1)) + min);
    }

	//d�finit l'ordre de priorit� du tour pour ne pas �tre affect� par les changements
	private static ArrayList<Monstre> ordonner() {
		
		//Si les monstres sont ajouter au lancement du combat juste apr�s leur cr�ation dans la liste,
		//ils seront d�j� dans la liste mais l'ordre doit �tre fait � chaque tour
		ArrayList<Monstre> ordrePrio = new ArrayList<Monstre>();	//pas un tab car les morts changent le nb de monstres
		
		ArrayList<Monstre> tampon =  Combattants; //copie les infos ou les adresses ??
		Monstre rapidite = tampon.get(0);
		for (int i = 1; i < tampon.size(); i ++) {
			// .sort() ne fonctionne pas !?	
			// cr�er sa propre comparaison tkt
		}
		//remplie la liste par ordre de vitesse d�croissante / les actions se fait en lisant la list dans l'ordre
		// vitesseEffective = .getVitesse() * .getCoefVitesse()
		return null;
	}
	
	//Gestion de l'array list
	private void ajoutList(Monstre monstre) { Combattants.add(monstre); } //Ajoute un monstre � la liste des combattants
	
	private void suppList(Monstre monstre) {
		for	(int i = 0; i < Combattants.size(); i++) {
			if(monstre.getNom().equals(Combattants.get(i).getNom())) {//Si il y a 2 fois le m�me monstre ? ou on connait sa 'position' comme alli�1, alli�2 ou ennemi1
				Combattants.remove(i);
			}
		}
	}

	
	
}
