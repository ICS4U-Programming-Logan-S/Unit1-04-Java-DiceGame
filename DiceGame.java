import java.util.Scanner;

/**
* This program generates a random number and
* asks the user to guess it. If they guess
* incorrectly, it adds to the amount of total
* guesses it took them to get it.
*
* @author Logan S
* @version 1.0
*
* @since   2023-02-28
*/

public final class DiceGame {

    /**
    * This is a private constructor.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Declare constants: these are lowercase for the linter.
        final int min = 1;
        final int max = 6;

        // Declare variables
        String userStr = " ";
        int guesses = 1;
        int userInt = 0;
        int randomDice = 1;

        // Create a new scanner
        final Scanner scanner = new Scanner(System.in);
        // Generate random number between 1 & 6
        randomDice = (int) Math.floor(Math.random()
            * (max - min + 1) + min);
        loop: {
            while (true) {
                // Ask user for guess
                System.out.print("Guess an integer from 1 to 6: ");
                userStr = scanner.nextLine();

                try {
                    // Try guess for integer
                    userInt = Integer.parseInt(userStr);

                    // Check if guess is within range
                    if (userInt > max || userInt < min) {
                        // Invalid Input if guess isn't between 1 & 6
                        System.out.println("Must be between 1 and 6."
                            + " Try again!");
                    } else {
                        while (true) {
                            // Check for correct guess
                            if (userInt == randomDice) {
                                if (guesses == 1) {
                                    // Congratulate if guessed right first try
                                    System.out.println("You got it right! It "
                                        + "only took " + guesses + " try!");
                                    break loop;
                                } else {
                                    // Congratulate once guessed correctly
                                    System.out.println("You got it! It "
                                        + "took you " + guesses + " tries!");
                                    break loop;
                                }
                            } else if (userInt < randomDice) {
                                // If input is lower than generated number
                                System.out.println("Too low, Try again!.");
                                // Increase guess amount by 1
                                guesses++;
                                break;
                            } else {
                                // If input is higher than generated number
                                System.out.println("Too high, Try again!.");
                                // Increase guess amount by 1
                                guesses++;
                                break;
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    // Invalid input error
                    System.out.print("Please enter an integer.\n");
                }
            }
        }
        scanner.close();
    }
}
