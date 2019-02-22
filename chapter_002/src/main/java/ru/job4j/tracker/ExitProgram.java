package ru.job4j.tracker;
/**
 * Strategy-Stub (Do nothing. Just for menu)
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class ExitProgram implements UserAction {
    private final int key;
    private final String info;

    public ExitProgram(int key, String info) {
        this.key = key;
        this.info = info;
    }
    /**
     * @return key assigned to the action
     */
    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }
    /**
     * @return Action information
     */
    @Override
    public String info() {
        return this.info;
    }
}
