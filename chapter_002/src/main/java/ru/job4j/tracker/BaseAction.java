package ru.job4j.tracker;
/**
 * Parent class for all actions
 * @author Andrei Pashchenko.
 * @version 1
 * @since 25.02.2019
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String info;

    protected BaseAction(final int key, final String info) {
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
    /**
     * @return Action information
     */
    @Override
    public String info() {
        return this.info;
    }
}
