import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoviePassTest {
	
	MoviePass m1, m2, m3, m4, m5, m6;

	@BeforeEach
	void setUp() throws Exception {
		//only used movie pass 1 time, pass was used 0 times today
		m1 = new MoviePass("Deadpool", "NR", 5,19,"NONE",12345, 0, false, 0);
		//pass has never been used before, pass was used 0 times today
		m2 = new MoviePass("Action Point", "NR", 2,12,"NONE",23456,0, false, 0);
		//pass has been used 1 time, movie has already been scene
		m3 = new MoviePass("Adrift", "PG13", 3,20,"NONE",34567, 1 , true, 0);
		//pass used 3 times, 0 times today
		m4 = new MoviePass("Book Club", "PG13", 1,13,"NONE",45678, 3 , false, 0);
		//passed used 1 time and scene 1 movie today already
		m5 = new MoviePass("Life of the Party", "PG13", 3,21,"NONE", 56789,1, false, 1);
		//pass used 2 times, no movies scnene today
		m6 = new MoviePass("Overboard", "PG13", 2,14,"NONE",67890, 2 , false, 0);
	}

	@AfterEach
	void tearDown() throws Exception {
		m1 = m2 = m3 = m4 = m5 = m6 = null;
	}

	@Test
	void test() {
		//fail("Not yet implemented");
		
		assertEquals(9.99,m1.calculateTicketPrice(),.01);
		assertEquals(9.99,m2.calculateTicketPrice(),.01);
		assertEquals(13.50,m3.calculateTicketPrice(),.01);
		assertEquals(0.0,m4.calculateTicketPrice(),.01);
		assertEquals(13.50,m5.calculateTicketPrice(),.01);
		assertEquals(0.0,m6.calculateTicketPrice(),.01);
	}

}
