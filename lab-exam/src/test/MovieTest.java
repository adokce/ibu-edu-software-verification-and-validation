package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Movie;

class MovieTest {

	// 6. Create 2 unit tests for all the methods (one positive assertion and one
	// negative assertion).

	@Test
	void testGetRevenue1() {
		Movie movie = new Movie("Saw", "Horror", 1992, 60, 100, 4.8);

		assertTrue(movie.getRevenue() == 40);
	}

	@Test
	void testGetRevenue2() {
		Movie movie = new Movie("Saw", "Horror", 1992, 60, 100, 4.8);

		assertFalse(movie.getRevenue() == 1);
	}

	@Test
	void testIsFlop1() {
		Movie movie = new Movie("Adam Sandler Movie", "Comedy", 2006, 60, 44, 2.2);

		assertTrue(movie.isFlop() == true);

	}

	@Test
	void testIsFlop2() {
		Movie movie = new Movie("Saw", "Horror", 1992, 60, 100, 4.8);

		assertFalse(movie.isFlop() == true);
	}

	@Test
	void testIsCultClassic1() {
		Movie movie = new Movie("Saw", "Horror", 1992, 60, 100, 4.8);

		assertTrue(movie.isCultClassic() == true);
	}

	@Test
	void testIsCultClassic2() {
		Movie movie = new Movie("Adam Sandler Movie", "Comedy", 2006, 60, 44, 2.2);

		assertFalse(movie.isCultClassic() == true);

	}
}
