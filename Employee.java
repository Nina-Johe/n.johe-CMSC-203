/**
 * 
 * @author ninajohe
 * subclass of Ticket
 * calculates ticket price for employees
 */
/**
 * @author ninajohe
 *
 */
public class Employee extends Ticket {
	
	private double employeeTicket;
	private int numVisits;
	private String type;
	
	public Employee() {}
	
	/**
	 * initializes fields
	 * @param movieName
	 * @param rating
	 * @param day
	 * @param time
	 * @param format
	 * @param id
	 * @param numVisits
	 */
	public Employee(String movieName, String rating, int day, int time, String format, int id, int numVisits) {
		
		super(movieName, rating, day, time, format, id);	
		this.numVisits = numVisits;
		employeeTicket = 0.0;
		type = "Employee";	
	}
	
	/**
	 * sets the ticket price for employees depending on number of visits
	 */
public void setTicketPrice() {
	
		if(numVisits < 2) {
			employeeTicket = 0.0;
		}
		else if(super.getTime() < 18 && super.getTime() >= 8) {
			employeeTicket = 10.50 / 2;
		}
		else if(super.getTime() >= 18 && super.getTime() <= 23){
			employeeTicket = 13.50 / 2;
		}
	}

	/**
	 * calculates the ticket prices depending on the format of the movie
	 * @return returns the price of the ticket
	 */
	@Override
	public double calculateTicketPrice() {
		setTicketPrice();
		
		if(employeeTicket != 0.0) {
			
		switch(super.getFormat()) {
		
		case "IMAX": employeeTicket += 3.00 / 2;
		break;
		
		case "3D": employeeTicket += 2.50 / 2;
		break;
		
		case "NONE": employeeTicket += 0;
		break;
		
		default: employeeTicket = 10.50 / 2;
		}
	}
		
		return employeeTicket += employeeTicket * super.getTAX();
	}

	/**
	 * getter method for customers id number
	 */
	@Override
	public int getId() {
		
		return super.idNumber;
	}
	
	@Override
	public String getType() {
		
		return type;
	}
	
	
}
