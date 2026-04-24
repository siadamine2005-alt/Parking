package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingTest {
	
	Parking p ,p1;
	Vehicule v,v1,v2;

	@BeforeEach
	void setUp() throws Exception {
		p = new Parking(10,3);
		v = new Vehicule("3");
		p1 = new Parking(2, 3);
		v1 = new Vehicule("1");
		v2 = new Vehicule("2");
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
	
	@Test
	void testIter3() {
		assertEquals(10,p.getNombrePlacesLibres());
		p.ajouter(v);
		assertEquals(9,p.getNombrePlacesLibres());
		p.retirer(v,5);
		assertEquals(10,p.getNombrePlacesLibres());
	}
	
	@Test
	void testIter4() {
		assertEquals(10,p.getNombrePlacesLibres());
		p.ajouter(v);
		assertEquals(9,p.getNombrePlacesLibres());
		assertEquals(15,p.retirer(v,5));
		assertEquals(10,p.getNombrePlacesLibres());
	}
	
	@Test
	void testIter5() {
		assertEquals(2,p1.getNombrePlacesLibres());
		assertTrue(p1.ajouter(v));
		assertEquals(1,p1.getNombrePlacesLibres());
		assertTrue(p1.ajouter(v1));
		assertEquals(0,p1.getNombrePlacesLibres());
		assertFalse(p1.ajouter(v2));

	}
	
	@Test
	void testIter6() {
		assertTrue(p.ajouter(v));
		assertTrue(p.contient(v));
		assertFalse(p.contient(v1));
	}
	
	@Test
	void testIter7() {
		assertFalse(p1.contient(v));
		assertThrows(IllegalArgumentException.class, () -> p1.retirer(v, 5));
		assertTrue(p.ajouter(v));
		assertTrue(p.contient(v));
		assertEquals(15,p.retirer(v,5));
		assertThrows(IllegalArgumentException.class, () -> p.retirer(v, 5));

	}
}
