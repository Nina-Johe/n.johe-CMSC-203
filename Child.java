/**
 * 
 * @author ninajohe
 * determines the price of a ticket for a child customer
 */

public class Child extends Ticket{
	
	private double childTicket;
	private String type;
	
	public Child() {}
	
	/**
	 * initializes fields
	 * @param movieName
	 * @param rating
	 * @param day
	 * @param time
	 * @param format
	 */
	public Child(String movieName, String rating, int day, int time, String format) {
		
		super(movieName, rating, day, time, format);
		childTicket = 0.0;
		type = "Child";
	}
	
	/**
	 * sets the ticket price depending on the time
	 */
	public void setTicketPrice() {
		
		if(super.getTime() < 18 && super.getTime() >= 8) {
			childTicket = 5.75;
		}
		else if(super.getTime() >= 18 && super.getTime() <= 23){
			childTicket = 10.75;
		}
	}

	/**
	 * calculates price of the ticket depending on the format of the movie
	 * @return price of the ticket
	 */
	@Override
	public double calculateTicketPrice() {
		
		setTicketPrice();
		
		switch(super.getFormat()) {
		
		case "IMAX": childTicket += 2.00;
		break;
		
		case "3D": childTicket += 1.50;
		break;
		
		case "NONE": childTicket += 0;
		break;
		
		default: childTicket = 5.75;
		}
		
		return childTicket += childTicket * super.getTAX();
	}

	/**
	 * getter method for customer id
	 */
	@Override
	public int getId() {
		
		return -1;
	}
	
	@Override
	public String getType() {
		return type;
	}
	
	

}
