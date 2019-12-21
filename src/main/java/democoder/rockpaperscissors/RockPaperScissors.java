/**
 * This is a classic rock-paper-scissors game.
 * 
 * To build: mvn instal
 * 
 * To run: java -jar target/rockpaperscissors-1.0.jar
 * 
 * To play: Enter 1 for ROCK, 2 for PAPER or 3 for scissors, or 0 to quit. Followed by enter.
 */

package democoder.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	final static int ROCK = 1;
	final static int PAPER = 2;
	final static int SCISSORS = 3;
	final static int QUIT = 0;
	static boolean playing = true;
	static int computerChoice = 0;
	static int playerScore = 0;
	static int computerScore = 0;
	static Random rand = new Random();

	/**
	 * Main loop of the game.
	 * 
	 * @param args No arguments
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the rock, paper and scissors game.");
		int choice = -1;
		while (playing) {
			System.out.println(
					"Please enter 1 for ROCK, 2 for PAPER or 3 for scissors, or 0 to quit. Followed by enter.");
			try {
				Scanner input = new Scanner(System.in);
				choice = input.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter a number.");
				continue;
			}
			System.out.println("You chose '" + choice + "'");
			switch (choice) {
			case ROCK:
			case PAPER:
			case SCISSORS:
				computerChoice = rand.nextInt(3) + 1;
				System.out.println("Computer chose '" + computerChoice + "'");
				RockPaperScissors.determineWinner(choice, computerChoice);
				break;
			case QUIT:
				System.out.println("Thank you for playing Rock, Paper, Scissors.");
				playing = false;
			}
		}
	}

	/**
	 * Determine which player wins by his choosing.
	 * 
	 * @param playerChoice
	 * @param computerCoice
	 */
	public static void determineWinner(int playerChoice, int computerCoice) {
		if (playerChoice == computerChoice) {
			System.out.println("It's a tie. Both selected " + playerChoice);
			return;
		}

		if (playerChoice == ROCK && computerChoice == SCISSORS) {
			System.out.println("You won! Rock beats scissors.");
			playerScore++;
		}

		if (playerChoice == ROCK && computerChoice == PAPER) {
			System.out.println("Computer won! Papers beat rock.");
			playerScore++;
		}

		if (playerChoice == PAPER && computerChoice == ROCK) {
			System.out.println("You won! Paper beats rock.");
			playerScore++;
		}

		if (playerChoice == PAPER && computerChoice == SCISSORS) {
			System.out.println("Computer won! Scissors beats paper.");
			computerScore++;
		}

		if (playerChoice == SCISSORS && computerChoice == PAPER) {
			System.out.println("You won! Scissors beats paper.");
			playerScore++;
		}

		if (playerChoice == SCISSORS && computerChoice == ROCK) {
			System.out.println("Computer won! Rock beats scissors.");
			computerScore++;
		}

		System.out.println("Score: Player " + playerScore + ", computer " + computerScore + ".");
	}
}
