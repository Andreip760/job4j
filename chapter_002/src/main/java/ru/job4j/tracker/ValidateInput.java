package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Class extending console interface.
 * Provides validation of user's input.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 24.02.2019
 */
public class ValidateInput implements Input {
    private final Input input;
    private final Consumer<String> output;
    public ValidateInput(final Input input, Consumer<String> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

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
                answer = this.input.ask(question, range);
                valid = true;
            } catch (NumberFormatException nfe) {
                this.output.accept("Enter a number");
            } catch (MenuOutException uoe) {
                this.output.accept("Enter a number from the menu range");
            }
        }
        return answer;
    }
}
