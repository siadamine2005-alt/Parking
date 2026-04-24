package ilu2;

import java.util.Iterator;

public class Parking {
	private int tarifHoraire;
	private int nbPlacesLibre;
	private Vehicule[] vehicules;

	public Parking(int nbPlaces, int tarif) {
		nbPlacesLibre = nbPlaces;
		vehicules = new Vehicule[nbPlaces];
        tarifHoraire = tarif;
	}

	public int getNombrePlacesLibres() {
		return nbPlacesLibre;
	}

	public boolean ajouter(Vehicule v) {
		for (int i = 0; i < vehicules.length; i++) {
			if(vehicules[i] == null) {
				vehicules[i] = v;
				nbPlacesLibre--;
				return true;
			}
		}
		return false;
	}

	public int retirer(Vehicule v, int heures) {
		for (int i = 0; i < vehicules.length; i++) {
			if(vehicules[i] == v) {
				vehicules[i] = null;
				nbPlacesLibre++;
				break;
			}
		}
		return heures*tarifHoraire;
	}

}
