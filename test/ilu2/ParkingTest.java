package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingTest {
	
	Parking p ,p1,p2,p3;
	Vehicule v,v1,v2;
	Parking[] ps;
	
	Ambulance a ;

	@BeforeEach
	void setUp() throws Exception {
		p = new Parking(10,3);
		v = new Vehicule("3");
		p1 = new Parking(2, 3);
		v1 = new Vehicule("1");
		v2 = new Vehicule("2");
		ps = new Parking[10];
		p2 = new Parking(10, 10,(float )0.5);
		a = new Ambulance("233","H1");
		p3 =new Parking(10, 20,(float )0.5);
	}

	@Test
	void testIter0() {
		assertNotNull(p);
		assertNotNull(v);
		assertNotNull(p2);
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
	
	@Test
	void testIter8() {
		for (int i = 0; i < 10; i++) {
			assertTrue(v.abonner(ps[i]));
		}
		assertFalse(v.abonner(p));
		assertTrue(v.estAbonne(ps[0]));
		assertFalse(v.estAbonne(p));
		assertFalse(v.estAbonne(p1));
	}
	
	@Test
	void testIter9() {
		v.abonner(p2);
		p2.ajouter(v);
		p2.ajouter(v1);
		assertEquals(15, p2.retirer(v, 3));
		assertEquals(30, p2.retirer(v1, 3));
	}
	
	@Test
	void testIter10() {
		a.abonner(p2);
		p2.ajouter(a);
		p3.ajouter(a);
		assertEquals(15, p2.retirer(a, 3));
		assertEquals(30, p3.retirer(a, 3));
	}
	
}
