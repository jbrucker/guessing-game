package game;

import java.util.Random;

/**
 * A model class for a guessing game.
 * Change this to be suitable for your game.
 * You need to modify the GameController to match.
 * 
 * @author Jim
 */
public class GameModel {
	// the secret number to guess
	private int secret;
	// the upper bound for secret. This determines how hard the game is.
	private int upperBound;
	// message for the player
	private String message = "";
	
	/**
	 * Since this is a general model, we should have a default contructor.
	 */
	public GameModel() {
		this(100);
	}
	
	/**
	 * Initialize a guessing game with given upper limit on the secret number.
	 * @param upperBound  the upper limit for the secret number. Must be positive.
	 */
	public GameModel(int upperBound) {
		this.upperBound = upperBound;
		final long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperBound) + 1;
		this.message = "I'm thinking of a number between 1 and "+upperBound;
	}
	
	public String getTitle() {
		return "Guessing Game";
	}
	
	public String getMessage() {
		return message;
	}
	
	/**
	 * Evaluate a user's input.
	 * Since this is a guessing game, I called it "guess".
	 * After evaluating the user's guess, prepare a message
	 * to display (call getMessage to get it).
	 * 
	 * @param value the user's input
	 * @return true if user guesses the secret number, false otherwise
	 */
	public boolean guess(String value) {
		int guess = 0;
		try {
			guess = Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			message = "Invalid input";
			return false;
		}
		if (guess < 1 || guess > upperBound) {
			message = "Impossible! The secret is 1 - "+upperBound;
			return false;
		}
		if (guess < secret) {
			message = guess + " is too small.";
			return false;
		}
		if (guess > secret) {
			message = guess + " is too large.";
			return false;
		}
		// only remaining case is correct
		message = "Right! You guessed it.";
		return true;
	}
	
	/**
	 * Get the upper bound for the secret.
	 * @return the upperbound on secret number
	 */
	public int getUpperBound() {
		return upperBound;
	}
}
