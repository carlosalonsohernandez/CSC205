package W3.DesignStartup.src;

public class Rental {
	private Movie _movie; // composition
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		super();
		this._movie = movie;
		this._daysRented = daysRented;
	}

	public Movie getMovie() {
		return this._movie;
	}

	public void setMovie(Movie movie) {
		this._movie = movie;
	}

	public int getDaysRented() {
		return this._daysRented;
	}

	public void setDaysRented(int daysRented) {
		this._daysRented = daysRented;
	}
}
