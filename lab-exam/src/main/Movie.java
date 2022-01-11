package main;

public class Movie {
	public String name;
	public String genre;
	public int release_year;
	public int budget;
	public int total_earnings;
	public double average_rating;

	public Movie(String n, String g, int ry, int b, int te, double ar) {
		this.name = n;
		this.genre = g;
		this.release_year = ry;
		this.budget = b;
		this.total_earnings = te;
		this.average_rating = ar;
	}

	// 3. Create a method that will calculate the revenue of the movie (difference
	// between the
	// budget and total earnings)
	public int getRevenue() {
		return this.total_earnings - this.budget;
	}

	// 4. Create a method that checks if a movie is a “box-office flop”. Flops have
	// a non-positive
	// revenue and an average rating of less than 3.0.
	public boolean isFlop() {
		if (this.average_rating < 3.0) {
			return true;
		} else {
			return false;
		}
	}

	// 5. Write a method to check if the movie is a “cult classic”. Cult classics
	// are released before the
	// year 2000, and have an average rating of over 4.7.
	public boolean isCultClassic() {
		if (this.release_year >= 2000) {
			return false;
		}

		if (this.average_rating < 4.7) {
			return false;
		}

		return true;
	}
}
