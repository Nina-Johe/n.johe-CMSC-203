import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class implements the MovieTicketManager interface
 * @author ninajohe
 *
 */
public class MovieTicketManager implements MovieTicketManagerInterface{
	
	ArrayList<Ticket>ticketList = new ArrayList<Ticket>();
	
	
	public MovieTicketManager() {}
	
	/**
	 * determines the number of visits made by a customer.
	 * only applies to employees and movie pass users.
	 * @param employee or movie pass id
	 * @return the number of times a customer visits in a month.
	 */
	@Override
	public int numVisits(int id) {
		int count = 0;
		
		for(int i = 0; i < ticketList.size(); i++) {
			if(ticketList.get(i).idNumber == id) {
				count++;
			}
		}
		return count;
	}
	
	
	/**
	 * counts the number of times a customer has seen a specific movie.
	 * @param customer id and movie name
	 * @return number of times a specific movie was seen
	 */
	@Override
	public int numThisMovie(int id, String movie) {
		int timesScene = 0;
		
		for(int i = 0; i < ticketList.size(); i++) {
			if(ticketList.get(i).idNumber == id && ticketList.get(i).getMovieName().equals(movie)) {
				timesScene++;
			}
				
		}
		
		
		return timesScene;
	}
	
	/**
	 * counts the number of times a customer has seen a specific movie in one day
	 * @param customer id and the date
	 * @return the number of times a customer has seen a specific movie in a day
	 */
	@Override
	public int numMoviesToday(int id, int date) {
		int moviesToday = 0;
		
		for(int i = 0; i < ticketList.size(); i++) {
	
			if(ticketList.get(i).idNumber == id && ticketList.get(i).getDay() == date) {
				moviesToday++;
			
			}
		}
		return moviesToday;
	}
	/**
	 * adds tickets to an array list
	 * @param movie name, rating, date, time, format, type of customer, id
	 * @return price of the ticket
	 */
	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		boolean seen;
		if(numThisMovie(id, movieN) > 0){
			seen = true;
		}
		else {
			seen = false;
		}
		
		if(type.equals("Employee")) {
			Ticket customer1 = new Employee(movieN, rating, d, t, f, id, numVisits(id));
			ticketList.add(customer1);
			return customer1.calculateTicketPrice();
		}
		else if(type.equals("Adult")) {
			Ticket customer2 = new Adult(movieN, rating, d, t, f);
			ticketList.add(customer2);
			return customer2.calculateTicketPrice();
		}
		else if(type.equals("Child")) {
			Ticket customer3 = new Child(movieN, rating, d, t, f);
			ticketList.add(customer3);
			return customer3.calculateTicketPrice();
		}
		else if(type.equals("MoviePass")) {
			Ticket customer4 =  new MoviePass(movieN, rating, d, t, f, id, numVisits(id), seen, numMoviesToday(id, d));
			ticketList.add(customer4);
			return customer4.calculateTicketPrice();
		}
		else {
			return -1;
		}
		
	
	}

	@Override
	public double totalSalesMonth() {
		double total = 0;
		
		for(int i = 0; i < ticketList.size(); i++) {
			total += ticketList.get(i).calculateTicketPrice();
			
		}
	
		return total;
	}

	@Override
	public String monthlySalesReport() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * adds all the 3d tickets into an array list of Strings by chronological order of the date
	 * @return array list of 3d tickets
	 */
	@Override
	public ArrayList<String> get3DTickets() {
		ArrayList<String>threeDlist = new ArrayList<String>();
		
		sortByDay();
		
		for(int i = 0; i < ticketList.size(); i++) {
			if(ticketList.get(i).getFormat().equals("3D")) {
				threeDlist.add(ticketList.get(i).toString());
			}
			
		}
		
		return threeDlist;
	}
	
	/**
	 * stores all the tickets in an array list of Strings by chronological order of date
	 * @return an arraylist of Strings of all the tickets
	 */
	@Override
	public ArrayList<String> getAllTickets() {
		ArrayList<String>allTickets = new ArrayList<String>();
		
		sortByDay();
		for(int i = 0; i < ticketList.size(); i++) {
			allTickets.add(ticketList.get(i).toString());
		}
		
		
		return allTickets;
	}

	@Override
	public ArrayList<String> getMoviePassTickets() {
		
		ArrayList<String> moviePassTickets = new ArrayList<String>();
		
		sortById();
		
		for(int i = 0; i < ticketList.size(); i++) {
			
			if(ticketList.get(i).getFormat().equals("MoviePass")){
				
				moviePassTickets.add(ticketList.get(i).toString());
			}
			
		}
		
		return moviePassTickets;
	}
	
	/**
	 * reads from a file and adds ticket objects into an arrayList
	 * @param a file to read from
	 * 
	 */
	@Override
	public void readFile(File file) throws FileNotFoundException {
		
		ArrayList<String>list=new ArrayList<String>();
		
	Scanner scan = new Scanner(file);
	
		while(scan.hasNextLine()) {
		
			list.add(scan.nextLine());		
		}
		
		for(int i = 0; i < list.size(); i++) {
			
			String[] str = list.get(i).split(":");
			
			addTicket(str[0], str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]), str[4], str[5], Integer.parseInt(str[6]));
		}
	
	}
	
	/**
	 * sorts the arrayList of ticket objects by chronological order of date
	 */
	
	public void sortByDay() {
		
		Ticket temp;
		for(int i = 1; i < ticketList.size(); i++) {
			for(int j = i; j > 0; j--) {
				if(ticketList.get(j).getDay() < ticketList.get(j-1).getDay()) {
					
					temp = ticketList.get(j);
					ticketList.set(j, ticketList.get(j-1));
					ticketList.set(j-1, temp);
					
				}
				
			}
			
		}
		
	}
	
	
	public void sortById() {
		
		Ticket temp;
		for(int i = 1; i < ticketList.size(); i++) {
			for(int j = i; j > 0; j--) {
				if(ticketList.get(j).getId() < ticketList.get(j-1).getId()) {
					
					temp = ticketList.get(j);
					ticketList.set(j, ticketList.get(j-1));
					ticketList.set(j-1, temp);
				}
				
			}
			
		}
		
	}
	

	
}
