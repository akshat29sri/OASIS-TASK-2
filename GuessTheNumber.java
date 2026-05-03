import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;
    private static final int TOTAL_ROUNDS = 3;

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int totalScore = 0;
        int roundsWon = 0;

        JOptionPane.showMessageDialog(
                null,
                "Welcome to Guess the Number!\n\n"
                        + "I will choose a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".\n"
                        + "You get " + MAX_ATTEMPTS + " attempts per round.\n"
                        + "The faster you guess, the more points you earn.",
                "Guess the Number",
                JOptionPane.INFORMATION_MESSAGE);

        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            int secretNumber = RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attemptsUsed = playRound(round, secretNumber);

            if (attemptsUsed > 0) {
                int roundScore = calculateScore(attemptsUsed);
                totalScore += roundScore;
                roundsWon++;

                JOptionPane.showMessageDialog(
                        null,
                        "Correct!\n\n"
                                + "Round: " + round + " of " + TOTAL_ROUNDS + "\n"
                                + "Attempts used: " + attemptsUsed + "\n"
                                + "Points earned: " + roundScore + "\n"
                                + "Total score: " + totalScore,
                        "Round Complete",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Out of attempts!\n\n"
                                + "The correct number was " + secretNumber + ".\n"
                                + "Total score: " + totalScore,
                        "Round Over",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Game Over!\n\n"
                        + "Rounds won: " + roundsWon + " of " + TOTAL_ROUNDS + "\n"
                        + "Final score: " + totalScore,
                "Final Result",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static int playRound(int round, int secretNumber) {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Round " + round + " of " + TOTAL_ROUNDS + "\n"
                            + "Attempt " + attempt + " of " + MAX_ATTEMPTS + "\n\n"
                            + "Enter your guess between " + MIN_NUMBER + " and " + MAX_NUMBER + ":",
                    "Make a Guess",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(
                        null,
                        "Game cancelled.",
                        "Guess the Number",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            int guess;
            try {
                guess = Integer.parseInt(input.trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a valid whole number.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                attempt--;
                continue;
            }

            if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                JOptionPane.showMessageDialog(
                        null,
                        "Your guess must be between " + MIN_NUMBER + " and " + MAX_NUMBER + ".",
                        "Out of Range",
                        JOptionPane.ERROR_MESSAGE);
                attempt--;
                continue;
            }

            if (guess == secretNumber) {
                return attempt;
            }

            String hint = guess < secretNumber ? "Too low!" : "Too high!";
            JOptionPane.showMessageDialog(
                    null,
                    hint + "\nAttempts remaining: " + (MAX_ATTEMPTS - attempt),
                    "Hint",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        return 0;
    }

    private static int calculateScore(int attemptsUsed) {
        return (MAX_ATTEMPTS - attemptsUsed + 1) * 10;
    }
}
