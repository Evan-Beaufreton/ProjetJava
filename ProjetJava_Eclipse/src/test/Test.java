package test;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("UWU");
		
		// Cr�er 6 monstres random + ajout � la liste des combattants
        Monstre DDD = new Monstre("D/D/D", 100, 50, 140.0, 140.0, 50.0, 90.0, 30, null);
        Monstre Noko = new Monstre("Noko", 120, 60, 120.0, 80.0, 70.0, 90.0, 40, null);
        Monstre Magicarpe = new Monstre("Magicarpe", 60, 30, 80.0, 70.0, 140.0, 100.0, 50, null);
        Monstre Exodia = new Monstre("Exodia", 80, 130, 140.0, 110.0, 30.0, 110.0, 45, null);
        Monstre Atoupik = new Monstre("Atoupik", 110, 40, 110.0, 160.0, 45.0, 95.0, 35, null);
        Monstre ABZ = new Joueur("ABZ", 120, 120, 120.0, 120.0, 120.0, 120.0, 0, null);
        Combat.ajoutCombattant(DDD);Combat.ajoutCombattant(Noko);Combat.ajoutCombattant(Magicarpe);
        Combat.ajoutCombattant(Exodia);Combat.ajoutCombattant(Atoupik);Combat.ajoutCombattant(ABZ);
        
        // Cr�er 4 attaques
        Capacite Flamme = new Capacite("Flamme", 95, 95, 5, null, null);
        Capacite Morsure = new Capacite("Morsure", 60, 100, 0, null, null);
        Capacite Renforcement = new Capacite("Renforcement", 0, 100, 5, "BA5", null);
        Capacite Explosion = new Capacite("Explosion", 150, 100, 5, null, null);

        /*
        ABZ.Attaquer(Morsure, DDD);
        ABZ.Attaquer(Renforcement, ABZ);
        System.out.println("Coef d'attaque " + ABZ.getCoefAttaque()); 
        ABZ.Attaquer(Morsure, DDD);
        DDD.InformationsRapides();
        Exodia.Attaquer(Flamme, Atoupik);
        Magicarpe.Attaquer(Explosion, Noko);
        */
        
        
	}
	
}
