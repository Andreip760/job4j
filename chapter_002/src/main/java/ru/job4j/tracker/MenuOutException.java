package ru.job4j.tracker;
/**
 * Exception for user's input validation
 * Called when the user tries to enter a value that is out the menu range.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 24.02.2019
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String message) {
        super(message);
    }
}
