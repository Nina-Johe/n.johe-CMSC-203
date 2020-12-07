/**
 * 
 * @author ninajohe
 * subclass of Ticket
 * Calculates price of ticket dependant on conditions
 */
public class MoviePass extends Ticket{
	private double pass = 0.0;
	private boolean alreadyScene;
	private int moviePerDay;
	private int numVisits;
	private String type;
	
	public MoviePass() {		
	}
	
	/**
	 * initializes fields
	 * @param movieName
	 * @param rating
	 * @param day
	 * @param time
	 * @param format
	 * @param id
	 * @param numVisits
	 * @param alreadyScene
	 * @param moviePerDay
	 */
	public MoviePass(String movieName, String rating, int day, int time, String format, int id, int numVisits, boolean alreadyScene, int moviePerDay) {
		
		super(movieName, rating, day, time, format, id);

		this.moviePerDay = moviePerDay;
		this.alreadyScene = alreadyScene;
		this.numVisits = numVisits;
		moviePerDay = 0;
		type = "MoviePass";
	}
	
	/**
	 * calculates the price of a ticket depending on conditions
	 * @return price of the ticket
	 */
	@Override
	public double calculateTicketPrice() {
		if(numVisits == 0) {
			pass = 9.99;
		}
		
		else if(super.getFormat().equals("NONE") && alreadyScene == false && moviePerDay == 0){
			pass = 0.0;
		}
		
		else {

			if(super.getTime() >= 18 && super.getTime()<= 23) {
					pass = 13.50;
			 }
			else if(super.getTime() < 18 && super.getTime() >= 8) {
				pass = 10.50;
			}
		}
		
		
		return pass;
	}
	
	/**
	 * getter method
	 * @return the customer id
	 */

	@Override
	public int getId() {
		
		return super.idNumber;
	}
	
	/**
	 * getter method
	 * @return if a specified movie has already been seen
	 */

	public boolean isAlreadyScene() {
		return alreadyScene;
	}
	/**
	 * getter method
	 * @return the amount of movies seen per day by a specified customer
	 */
	public int getMoviePerDay() {
		return moviePerDay;
	}
	
	@Override
	public String getType() {
		
		return type;
		
	}


	

}
