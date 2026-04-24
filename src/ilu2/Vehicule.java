package ilu2;

public class Vehicule {
	private String immatriculation;
	private Parking[] abonnements = new Parking[10];
	private int nbAbonnement = 0;

	public Vehicule(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public boolean abonner(Parking p) {
		if (nbAbonnement == 10)
			return false;
		abonnements[nbAbonnement] = p;
		nbAbonnement++;
		return true;
	}

	public boolean estAbonne(Parking p) {
		for (int i = 0; i < abonnements.length; i++) {
			if (abonnements[i] == p)
				return true;
		}
		return false;
	}

}
