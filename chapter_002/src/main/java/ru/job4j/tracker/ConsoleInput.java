package ru.job4j.tracker;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Class providing console interface.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 18.02.2019
 */
public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);
    private final Consumer<String> output;

    public ConsoleInput(Consumer<String> output) {
        this.output = output;
    }

    /**
     * Asks user and receive answer
     *
     * @param question Question
     * @return Answer
     */
    @Override
    public String ask(String question) {
        this.output.accept(question);
        return scanner.nextLine();
    }
    /**
     * Asks user and receive answer.
     * Checks that the taken value is in range.
     * @param question Question
     * @param range Menu range
     * @return Answer
     * @throws MenuOutException (If answer is out of range)
     */
    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int answer = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int val : range) {
            if (val == answer) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Answer is out of menu range");
        }
        return answer;
    }
}