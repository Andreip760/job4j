package ru.job4j.tracker;
/**
 * Class extending console interface.
 * Provides validation of user's input.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 24.02.2019
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Asks user and receive answer
     * Checks that the taken value is a number & it is in range
     * @param question Question.
     * @param range Menu range.
     * @return Answer.
     */
    public int ask(String question, int[] range) {
        int answer = -1;
        boolean valid = false;
        while (!valid) {
            try {
                answer = super.ask(question, range);
                valid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number");
            } catch (MenuOutException uoe) {
                System.out.println("Enter a number from the menu range");
            }
        }
        return answer;
    }
}
