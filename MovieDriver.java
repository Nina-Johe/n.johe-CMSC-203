import java.util.Scanner;
public class MovieDriver {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String repeat;
		
		do {
		
		System.out.println("Enter title of a movie: ");
		String movieTitle = input.nextLine();
		
		
		System.out.println("Enter the movie rating: ");
		String rating = input.nextLine();
		
		 
		 System.out.println("how many tickets were sold? ");
		int tickets = input.nextInt();
		
		Movie m1 = new Movie(movieTitle, rating, tickets);
		
		System.out.println(m1.toString());
		
		System.out.println();
		
		System.out.println("do you want to enter another? (y or n)");
		
		repeat = input.next();
		
		String projectHint = input.nextLine();
		
		} while(repeat.equals("y"));
		
		System.out.println("Goodbye.");
		
	
		
		

	}

}
