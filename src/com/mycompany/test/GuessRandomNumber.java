package com.mycompany.test;

import java.util.Scanner;

/**
 * This Java program implements a number guessing game.
 * The user has to first input an upper limit. 
 * Based on the upper limit entered by the user, the program uses binary search
 * to guess the number.
 * Once the program guesses the number, the user has to type "yes" or "end" to finish the game
 */

public class GuessRandomNumber {

	public static void main(String[] args) {

		// Required variables
		int upperLimit = 0;
		int lowerLimit = 1;
		int guess = 0;
		String myAnswer = Messages.getString("GuessRandomNumber.myAnswer"); 
		
		// Scanner to read user input
	    Scanner in = new Scanner(System.in);
	    
	    // Is the user ready ?
	    System.out.println(Messages
				.getString("GuessRandomNumber.userReady"));
	    
	    
	    if (in.nextLine().equalsIgnoreCase("ready")) {
			// Get upper limit from the user first
			System.out.println(Messages
					.getString("GuessRandomNumber.upperLimit"));
			upperLimit = Integer.parseInt(in.nextLine());
			do {
				guess = (upperLimit + lowerLimit + 1) / 2;
				System.out.println(Messages
						.getString("GuessRandomNumber.guess")
						+ guess
						+ Messages.getString("GuessRandomNumber.questionMark"));
				myAnswer = in.nextLine();

				if (myAnswer.equalsIgnoreCase(Messages
						.getString("GuessRandomNumber.higher"))) { // number is higher 
					lowerLimit = guess + 1;
				} else if (myAnswer.equalsIgnoreCase(Messages
						.getString("GuessRandomNumber.lower"))) { // number is lower 
					upperLimit = guess - 1;
				}
			} while (!(myAnswer.equalsIgnoreCase(Messages
					.getString("GuessRandomNumber.yes")) || myAnswer
					.equalsIgnoreCase(Messages
							.getString("GuessRandomNumber.end"))));
			in.close();
		} else{
			System.out.println(Messages
					.getString("GuessRandomNumber.tryAgainLater"));
		}
		System.out.println(Messages.getString("GuessRandomNumber.thankyou")); 
	}

}
