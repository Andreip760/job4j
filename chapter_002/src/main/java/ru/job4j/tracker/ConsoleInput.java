package ru.job4j.tracker;
import java.util.Scanner;
/**
 * Class providing console interface.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 18.02.2019
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    /**
     * Asks user and receive answer
     * @param question Question
     * @return Answer
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
