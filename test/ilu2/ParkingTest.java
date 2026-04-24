package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingTest {
	
	Parking p ;

	@BeforeEach
	void setUp() throws Exception {
		p = new Parking(10);
	}

	@Test
	void testIter0() {
		assertNotNull(p);
	}

	@Test
	void testIter1() {
		assertEquals(10,p.getNombrePlacesLibres());
	}
}
