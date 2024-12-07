package test;

import java.util.ArrayList;

public class Monstre{
	
	public String nom;
	
	// statistiques actuelles du monstre
	protected double attaque; protected double special;
	protected double defense; protected double vitesse;
	// diff�rence entre la stat maximum et la stat actuelles
	protected int pvMax; protected int pvNow;				
	protected int peMax; protected int peNow;
	
	// statistiques de Base de l'espece
	protected double attaqueB; protected double specialB;
	protected double defenseB; protected double vitesseB;
	protected int pvB; protected int peB;
	
	protected int niveau; 
	protected int tauxCapture;
	// next_niveau_xp est le nombre de points d'xp qu'il faut pour passer au niveau suivant.
	protected double xpNow; protected double next_niveau_xp;
	
	//Malus ou Bonus sur la statistique
	protected double coefAttaque = 1.0;	protected double coefSpecial = 1.0;
	protected double coefDefense = 1.0;	protected double coefVitesse = 1.0;
	
	//Les attaques du monstre
	protected ArrayList<Capacite> moveSet = new ArrayList<Capacite>(); //contient les attaques quand elles seront d�finies
	protected Capacite move1; protected Capacite move2;
	protected Capacite move3; protected Capacite move4;
	
	public Monstre(String nom, int pvB, int peB, double attaqueB, double specialB, double defenseB, double vitesseB, int tauxCapture) {
		this.nom = nom;
		niveau = 1;
		// stat init = (2*baseStat)*(niveau/100)+S
		//	Si PV, PE alors S = niveau + 10
		//  Si autres S = 5
		this.pvMax = (2*pvB)*(niveau/100)+niveau+10;
		this.peMax = (2*peB)*(niveau/100)+niveau+10;
		this.attaque = (2*attaqueB)*(niveau/100)+5;
		this.special = (2*specialB)*(niveau/100)+5;
		this.defense = (2*defenseB)*(niveau/100)+5;
		this.vitesse = (2*vitesseB)*(niveau/100)+5;
		this.tauxCapture = tauxCapture;
		
		this.pvB = pvB;	this.peB = peB;
		this.attaqueB = attaqueB; this.specialB = specialB;
		this.defenseB = defenseB; this.vitesseB = vitesseB;
		
		next_niveau_xp = (Math.pow((niveau+1),3))*0.8; // experience(niveau) = ((niveau)^3)*0.8
		pvNow = this.pvMax;
		peNow = this.peMax;
	}

	public String getNom() {
		return nom;
	}
	public int getPvMax() {
		return pvMax;
	}
	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}
    public int getPvNow() {
		return pvNow;
	}
	public void setPvNow(int pvNow) {
		this.pvNow = pvNow;
	}
    public int getPeNow() {
		return peNow;
	}
	public void setPeNow(int peNow) {
		this.peNow = peNow;
	}
	public double getAttaque() {
		return attaque;
	}
	public double getSpecial() {
		return special;
	}
	public double getDefense() {
		return defense;
	}
	public double getVitesse() {
		return vitesse;
	}
	public double getTauxCapture() {
		return tauxCapture;
	}
	public double getCoefAttaque() {
		return coefAttaque;
	}
	public void setCoefAttaque(double coefAttaque) {
		this.coefAttaque = coefAttaque;
	}
	public double getCoefSpecial() {
		return coefSpecial;
	}
	public void setCoefSpecial(double coefSpecial) {
		this.coefSpecial = coefSpecial;
	}
	public double getCoefDefense() {
		return coefDefense;
	}
	public void setCoefDefense(double coefDefense) {
		this.coefDefense = coefDefense;
	}
	public double getCoefVitesse() {
		return coefVitesse;
	}
	public void setCoefVitesse(double coefVitesse) {
		this.coefVitesse = coefVitesse;
	}

	private void gain_xp(int gain) {
		xpNow += gain;
		while (xpNow >= next_niveau_xp) {
			xpNow = xpNow - next_niveau_xp;
			niveau++;
			next_niveau_xp = (Math.pow((niveau+1),3))*0.8;; // experience(niveau) = ((niveau)^3)*0.8
			
			double mult = 1/50;
			pvMax = (2*pvB)*(niveau/100)+niveau+10;
			pvNow = pvMax;	//Regagne toutes ses pv au passage de niveau 
			peMax = (2*peB)*(niveau/100)+niveau+10;
			pvNow = peMax;	//Regagne aussi ses pe
			attaque += mult*attaqueB;
			special += mult*specialB;
			defense += mult*defenseB;
			vitesse += mult*vitesseB;
			
			System.out.println( nom + " est d�sormais niveau " + this.niveau + ", ses statistiques ont augment�es");
		}
	}
	
	// calcul des dommages :
	// pvPerdus =(int) ((((niveau*0.5+2)*(attaqueAttaquant*coefboost)*puissanceCapacite)/(defenseCible*coefBoost))/50)
	public void Attaquer(Capacite capacite, Monstre cible) {
		if (Combat.random(1, 100) <= capacite.getPrecision()) { //chance de r�ussir l'attaque
			
			if (capacite.getCout()== 0) {	//Si la capacit� est d'attaque
				int pvPerdus = (int) ((((this.niveau*0.5+2)*(this.attaque*this.coefAttaque)*capacite.getPuissance())/(cible.getDefense()*cible.getCoefDefense()))/50);
				cible.setPvNow(cible.getPvNow() - pvPerdus); //gestion de la mort dans Combat
				System.out.println("L'ennemis a perdu " + pvPerdus);
				
			} else {
				if (this.getPeNow() >= capacite.getCout()) { // Si le monstre a assez d'�nergie pour utiliser la capacite
					
					if (capacite.getPuissance() == 0) { //Si statut
						
						if (capacite.getEffet()!= null) { //petite v�rif suppl�mentaire
							Capacite.Alteration(cible, capacite.getEffet());
						}
						this.setPeNow(this.peNow - capacite.getCout()); //retire le cout d'�nergie de la capacite
						
					} else {
						
						int pvPerdus = (int) ((((this.niveau*0.5+2)*(this.special*this.coefSpecial)*capacite.getPuissance())/(cible.getDefense()*cible.getCoefDefense()))/50);
						cible.setPvNow(cible.getPvNow()-pvPerdus);
						this.setPeNow(this.peNow - capacite.getCout());	//mettre le cout d'�nergie de la capacite
						System.out.println("L'ennemis a perdu " + pvPerdus);
					}
					
				} else {
					System.out.println(this.nom + " n'a pas assez d'�nergie pour lancer son attaque");
				}
			}
			
		} else {System.out.println("L'attaque a �chou�");}	
	}

	public void Denfendre() {
		//prioritaire +1
		//augment le coef de defense pendant CE TOUR UNIQUEMENT
		this.setCoefSpecial(this.coefDefense+0.3); //jsp combien augmenter le coef
		
		System.out.println(this.nom + " attend en position d�fensive");
	}

	public String InformationsRapides() {
		return nom + ", niveau: " + niveau
				+ "\nPV : " + pvNow + "/" + pvMax + " et PE :" + peNow + "/" + peMax;
	}
	
	public String toString() {
		return nom + "   niveau: " + niveau + ", Exp�rience actuelle=" + xpNow + "/" + next_niveau_xp
				+ "\nPV : " + pvNow + "/" + pvMax + "		PE :" + peNow + "/" + peMax
				+ "\n - Attaque: " + attaque
				+ ";\n - Sp�cial: " + special
				+ ";\n - D�fense: " + defense
				+ ";\n - Vitesse: " + vitesse + ";";
	}


}