package ru.job4j.tracker;
/**
 * Strategy-Stub (Do nothing. Just for menu)
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class ExitProgram extends BaseAction {
    public ExitProgram(int key, String info) {
        super(key, info);
    }
    @Override
    public void execute(Input input, Tracker tracker) {

    }
}
