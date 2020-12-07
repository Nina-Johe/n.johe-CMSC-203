/**
 * 
 * @author ninajohe
 * abstract class Ticket
 * Holds information common to all types of tickets
 */
public abstract class Ticket {
	private String movieName;
	private String rating;
	private int day;
	private int time;
	private double ticketPrice;
	protected int idNumber;
	private final double TAX = 0.096;
	enum Format {IMAX, THREE_D, NONE};
	private String format;
	protected String type;
	
	
	public Ticket() {}
	
	public Ticket(String movieName, String rating, int day, int time, String format) {
			 
		this.movieName = movieName;
		this.rating = rating;
		this.time = time;
		this.format = format;
		this.day = day;
		idNumber = 0;
		type = "";
	}
	
	public Ticket(String movieName, String rating, int day, int time, String format, int idNumber) {
		 
		this.movieName = movieName;
		this.rating = rating;
		this.time = time;
		this.format = format;
		this.idNumber = idNumber;
		this.day = day;
		type = "";
		
	}
	
	public int getDay() {
		return day;
	}

	public double getTAX() {
		return TAX;
	}

	public String getFormat() {
		return format;
	}


	public String getMovieName() {
		return movieName;
	}

	public String getRating() {
		return rating;
	}

	public int getTime() {
		return time;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public void setDay(int day) {
		this.day = day;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setTime(int time) {
		this.time = time;
	}


	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public abstract double calculateTicketPrice();
	
	public abstract int getId();
	
	public String toString() {
		
		String str = "Movie Name: " + getMovieName() + "\n" + "Rating: " + rating + " \n"  + "Day: " + getDay() + "\n" + "Time: " + getTime() + "\n" + 
	"Format: " + getFormat() + "\n" + "Type: " + getType() + "\n" + "Id: " + getId() + "\n";
		
	
		return str;
	}
	

}
