package ilu2;

import java.util.Iterator;

public class Parking {
	private int nbPlacesLibre;
	private Vehicule[] vehicules;

	public Parking(int nbPlaces) {
		nbPlacesLibre = nbPlaces;
		vehicules = new Vehicule[nbPlaces];
	}

	public int getNombrePlacesLibres() {
		return nbPlacesLibre;
	}

	public void ajouter(Vehicule v) {
		for (int i = 0; i < vehicules.length; i++) {
			if(vehicules[i] == null) {
				vehicules[i] = v;
				nbPlacesLibre--;
				break;
			}
		}
	}

	public void retirer(Vehicule v) {
		for (int i = 0; i < vehicules.length; i++) {
			if(vehicules[i] == v) {
				vehicules[i] = null;
				nbPlacesLibre++;
				break;
			}
		}
	}

}
