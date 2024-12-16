package test;

import java.util.ArrayList;

public class Combat {
	
	private static ArrayList<Monstre> combattants = new ArrayList<Monstre>(); // liste des monstres participant au combat (en vie)
	private static ArrayList<Monstre> ordrePrio = null;
	
	public static int random(int min, int max) {	     
	    return ((int) (Math.random() * (max - min+1)) + min);
    }

	//d�finit l'ordre de priorit� au d�but de chaque tour
	@SuppressWarnings("unchecked") //?
	public static ArrayList<Monstre> ordonner() {
		
		ordrePrio = (ArrayList<Monstre>) combattants.clone(); //copie les valeurs et pas l'adresse	des valeurs	

		//Trie par vitesse effective
		ordrePrio.sort((m1,m2) -> 
			Double.compare(m2.getVitesse() * m2.getCoefVitesse(), m1.getVitesse() * m1.getCoefVitesse()));
		
		ordrePrio.forEach(System.out::println);

		return ordrePrio;
	}

	//Gestion de la liste des parcicipants aux combats
	public static void ajoutCombattant(Monstre monstre) { combattants.add(monstre); } //Ajoute un monstre � la liste des combattants
	
	public static void suppList(Monstre monstre) {
		for	(int i = 0; i < combattants.size(); i++) {
			if(monstre.getNom().equals(combattants.get(i).getNom())) {// A changer !!! pas avec le nom
				combattants.remove(i);
			}
		}
	}

	
	
}
