package ru.job4j.tracker;
/**
 * Input interface.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 18.02.2019
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
