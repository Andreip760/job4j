package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * User action interface.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public interface UserAction {
    /**
     * @return key assigned to the action
     */
    int key();
    /**
     * Executing the provided strategy
     * @param input Input interface
     * @param output Output interface
     * @param tracker Tracker
     */
    void execute(Input input, Consumer<String> output, Tracker tracker);
    /**
     * @return Action information (key and info)
     */
    String info();
}
