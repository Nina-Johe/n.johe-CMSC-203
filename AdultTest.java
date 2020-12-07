import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdultTest {
	
	Adult a1, a2, a3, a4, a5, a6;

	@BeforeEach
	void setUp() throws Exception {
		//Evening movie (after 6 pm)
		a1 = new Adult("Return of the Jedi", "PG-13", 5,19,"NONE");
		//Matinee (before 6 pm)
		a2 = new Adult("Elf", "PG", 2,12,"NONE");
		//Evening IMAX movie
		a3 = new Adult("ScarFace", "R", 3,20,"IMAX");
		//Matinee IMAX
		a4 = new Adult("Frozen", "G", 1,13,"IMAX");
		//Evening 3D
		a5 = new Adult("The Prisoner of Azkaban", "PG", 3,21,"3D");
		//Matinee 3D
		a6 = new Adult("The Empire Strikes Back", "PG-13", 2,14,"3D");
	}

	@AfterEach
	void tearDown() throws Exception {
		a1=a2=a3=a4=a5=a6;
	}

	@Test
	void test() {
		assertEquals(14.79,a1.calculateTicketPrice(),.01);
		assertEquals(11.50,a2.calculateTicketPrice(),.01);
		assertEquals(18.08,a3.calculateTicketPrice(),.01);
		assertEquals(14.79,a4.calculateTicketPrice(),.01);
		assertEquals(17.53,a5.calculateTicketPrice(),.01);
		assertEquals(14.24,a6.calculateTicketPrice(),.01);
	}

}
