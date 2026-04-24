package ilu2;

public class Parking {
	private float reduction = 1;
	private int tarifHoraire;
	private int nbPlacesLibre;
	private Vehicule[] vehicules;

	public Parking(int nbPlaces, int tarif) {
		nbPlacesLibre = nbPlaces;
		vehicules = new Vehicule[nbPlaces];
		tarifHoraire = tarif;
	}

	public Parking(int nbPlaces, int tarif, float reduc) {
		this(nbPlaces, tarif);
		reduction = reduc;
	}

	public int getNombrePlacesLibres() {
		return nbPlacesLibre;
	}

	public boolean ajouter(Vehicule v) {
		for (int i = 0; i < vehicules.length; i++) {
			if (vehicules[i] == null) {
				vehicules[i] = v;
				nbPlacesLibre--;
				return true;
			}
		}
		return false;
	}

	public float retirer(Vehicule v, int heures) throws IllegalArgumentException {
		if (!contient(v))
			throw new IllegalArgumentException();
		for (int i = 0; i < vehicules.length; i++) {
			if (vehicules[i] == v) {
				vehicules[i] = null;
				nbPlacesLibre++;
				break;
			}
		}
		float prix = heures * tarifHoraire;

		if (v.estAbonne(this) || v instanceof Ambulance)
			prix = prix * reduction;

		return prix;

	}

	public boolean contient(Vehicule v) {
		for (int i = 0; i < vehicules.length; i++) {
			if (vehicules[i] == v) {
				return true;
			}
		}
		return false;
	}

}
