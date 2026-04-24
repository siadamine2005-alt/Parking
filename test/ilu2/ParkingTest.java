package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingTest {
	
	Parking p ;
	Vehicule v;

	@BeforeEach
	void setUp() throws Exception {
		p = new Parking(10);
		v = new Vehicule("1");
	}

	@Test
	void testIter0() {
		assertNotNull(p);
		assertNotNull(v);
	}

	@Test
	void testIter1() {
		assertEquals(10,p.getNombrePlacesLibres());
	}
	
	@Test
	void testIter2() {
		assertEquals(10,p.getNombrePlacesLibres());
		p.ajouter(v);
		assertEquals(9,p.getNombrePlacesLibres());
	}
	
}
