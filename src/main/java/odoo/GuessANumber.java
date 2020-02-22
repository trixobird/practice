package odoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * Solve the game "Guess a number", find a secret integer between 1 and 1000000
 * in less than 50 guesses. Write a function that solves the game without user input and returns the
 * solution by using the function verify() which is defined with the following
 * specification:
 * function verify(guess: integer) -> integer
 * Argument:
 *      guess (integer) the number to verify
 * Returns:
 *      0 if the guess is the solution, your program won
 *      -1 if the solution is smaller than the guess parameter
 *      1  if the solution is bigger than the guess parameter
 *
 * Warning: You are not allowed to call verify() more that 50 times or you loose.
 */
public class GuessANumber {

    private static final int MAX = 1000000;
    private static final int MAX_GUESSES = 50;
    private final int secretNumber;
    private int timesVerifyCalled = 0;
    private static Logger logger = LoggerFactory.getLogger(GuessANumber.class);

    public GuessANumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public static void main(String[] args) {
        GuessANumber guessANumber = new GuessANumber(10);
        String format = MessageFormat.format("Number: {0}, Guesses: {1}", guessANumber.solve(), guessANumber.timesVerifyCalled);
        logger.info(format);
        solveTest();
    }

    private int solve() {
        return innerSolve(0, MAX);
    }

    private int innerSolve(int from, int to) {
        int seed = (from + to) / 2;
        int verify = verify(seed);
        if (verify == 0) {
            return seed;
        }
        if (verify == -1) {
            return innerSolve(from, seed - 1);
        }
        return innerSolve(seed + 1, to);
    }

    private int verify(int guess) {
        timesVerifyCalled++;
        return Integer.compare(secretNumber, guess);
    }

    private static void solveTest() {
        for (int i = 1; i <= MAX; i++) {
            GuessANumber guessANumber = new GuessANumber(i);
            int number = guessANumber.solve();
            if (guessANumber.timesVerifyCalled > MAX_GUESSES || number != i) {
                throw new IllegalStateException("verify was called too many times or solution incorrect");
            }
        }
    }
}
