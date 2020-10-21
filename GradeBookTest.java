import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook g1, g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(95.2);
		g1.addScore(87.4);
		g1.addScore(57.0);
		
		g2.addScore(93.0);
		g2.addScore(68.1);
		g2.addScore(75.8);
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = null;
	}

	@Test
	void testAddScore() {
		//fail("Not yet implemented");
		//System.out.print(g1.toString());
		assertTrue(g1.toString().equals("95.2 87.4 57.0 "));
		assertTrue(g2.toString().equals("93.0 68.1 75.8 "));
		assertEquals(3, g1.getScoreSize(), .001);
		assertEquals(3, g2.getScoreSize(), .001);
		
	}

	@Test
	void testSum() {
		//fail("Not yet implemented");
		assertEquals(239.6, g1.sum(), .0001);
		assertEquals(236.9, g2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		//fail("Not yet implemented");
		assertEquals(57.0, g1.minimum(), .01);
		assertEquals(68.1, g2.minimum(), .01);
	}

	@Test
	void testFinalScore() {
		//fail("Not yet implemented");
		assertEquals(182.6, g1.finalScore(), .01);
		assertEquals(168.8, g2.finalScore(), .01);
	}

	@Test
	void testGetScoreSize() {
		//fail("Not yet implemented");
		assertEquals(3, g1.getScoreSize(), .001);
		assertEquals(3, g2.getScoreSize(), .001);
	}

	@Test
	void testToString() {
		//fail("Not yet implemented");
		assertEquals("95.2 87.4 57.0 ", g1.toString());
		assertEquals("93.0 68.1 75.8 ", g2.toString());
	}

}
