
public class Adult extends Ticket{
	
	private double adultTicket;
	private String type;
	
	public Adult() {}
	
	public Adult(String movieName, String rating, int day, int time, String format) {
		
		super(movieName, rating, day, time, format);
		adultTicket = 10.50;
		type = "Adult";
		
	}

	public double getAdultTicket() {
		return adultTicket;
	}

	public void setAdultTicket() {
	
		if(super.getTime() >= 18 && super.getTime()<= 23) {
				adultTicket = 13.50;
		 }
		else if(super.getTime() < 18 && super.getTime() >= 8) {
			adultTicket = 10.50;
		}
	}
	
	@Override
	public double calculateTicketPrice() {
		
		setAdultTicket();
		
		switch(super.getFormat()) {
		
		case "IMAX": adultTicket += 3.00;
		break;
		
		case "3D": adultTicket += 2.50;
		break;
		
		case "NONE": adultTicket += 0;
		break;
		
		default: adultTicket = 10.50;
	
		}
		
		return adultTicket += adultTicket * super.getTAX();
	}

	@Override
	public int getId() {
		
		return -1;
	}
	
	@Override
	public String getType() {
		
		return type;
	}

}
