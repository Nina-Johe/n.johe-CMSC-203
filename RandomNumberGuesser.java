import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		//Print my name
		System.out.println("Program by Nina Johe.");
		
		//Scanner object to get user input
		Scanner input = new Scanner(System.in);
		
		//Create RNG object to initialize the no-arg constructor
		RNG r1 = new RNG();
		
		//Call static method rand() to get the random number and assign it to number
		int randNum = RNG.rand();
		
		//Print out the random number for easy testing
		System.out.println("The secret number is " + randNum);
		System.out.println();
		
		//Variables to hold user input
		int nextGuess = 0;
		String tryAgain = null;
		
		//do-while loop to repeat the guessing process until the guess matches the random number
		do {
		
		//Statement to prompt user into entering guess for random number
		System.out.print("Enter a random number: ");
		 nextGuess = input.nextInt();
		
		 //Statement that shows number of guesses
		System.out.println("Number of guesses is " + RNG.getCount());
		
		/*Decision structure (if-else statement) prints out results 
		 * for the guess using methods from RNG class
			and gives user another guess*/
		if(nextGuess > randNum) {
			System.out.println("Your guess is too high.");
			RNG.inputValidation(nextGuess, 0, nextGuess);
		}
		else if(nextGuess < randNum) {
			System.out.println("Your guess is too low.");
			RNG.inputValidation(nextGuess, nextGuess, 100);
		}
		else {
			System.out.println("You guessed correctly!");
			System.out.println("Try again? (yes or no) ");
			tryAgain = input.next();
		}
	
		
		}while(nextGuess != randNum);
		
		//call playAgain method if user wants to play again
		if(tryAgain.equals("yes")) {
			playAgain(nextGuess, tryAgain);
		}
		
	
		
		System.out.print("Thanks for playing.");
		
		
		}
	
	//this method repeats the game if the user wants to play again
	public static void playAgain(int guess, String again) {
		Scanner input = new Scanner(System.in);
		int randNum = RNG.rand();
		RNG.resetCount();
		RNG r2 = new RNG();
		
		System.out.println();
		System.out.println("new secret number is " + randNum);
		System.out.println();
		
		while(again.equals("yes")) {
			
			System.out.print("Enter a random number: ");
			 guess = input.nextInt();
			
			System.out.println("Number of guesses is " + RNG.getCount());
			
			
			if(guess > randNum) {
				System.out.println("Your guess is too high.");
				RNG.inputValidation(guess, 0, guess);
			}
			else if(guess < randNum) {
				System.out.println("Your guess is too low.");
				RNG.inputValidation(guess, guess, 100);
			}
			else {
				System.out.println("You guessed correctly!");
				System.out.println("Try again? (yes or no) ");
				again = input.next();
			}
			
		}
		
	}

}
