import java.util.Scanner;

public class WiFiDiagnosis {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		final String PROMPT_USER = "Did that fix the problem? (yes or no?)";
		
		System.out.println("First Step: Reboot your computer and try to connect again.");
		System.out.println(PROMPT_USER);
		String connected = input.nextLine();
		
		 if(connected.equalsIgnoreCase("yes")) {
			 System.exit(0);
		 }
		
		 System.out.println("Second Step: Reboot your router and try to connect again.");
		 System.out.println(PROMPT_USER);
		 connected = input.nextLine();
		 

		 if(connected.equalsIgnoreCase("yes")) {
			 System.exit(0);
		 }
		 
		 System.out.println("Third Step: Make sure cables are firmly connected and power is getting to the router.");
		 System.out.println(PROMPT_USER);
		 connected = input.nextLine();
		 
		 if(connected.equalsIgnoreCase("yes")) {
			 System.exit(0);
		 }
		 
		 System.out.println("Fourth Step: Move the computer closer to the router and try to connect.");
		 System.out.println(PROMPT_USER);
		 connected = input.nextLine();
		 
		 if(connected.equalsIgnoreCase("yes")) {
			 System.exit(0);
		 }
		 else if(connected.equalsIgnoreCase("no")) {
			 System.out.println("Contact your ISP, make sure your ISP is hooked up to your router.");
		 }
		 
		 
		 
		
		
		
		

	}

}
