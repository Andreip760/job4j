package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Strategy for showing all items in the tracker
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class ShowAllItems extends BaseAction {
    public ShowAllItems(int key, String info) {
        super(key, info);
    }
    /**
     * Showing all items in the tracker
     * @param input Input interface
     * @param output Output interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Consumer<String> output, Tracker tracker) {
        output.accept("------------ Все заявки --------------");
        for (Item item : tracker.findAll()) {
            output.accept(String.format("%s %s %s", item.getId(), item.getName(), item.getDesc()));
        }
        output.accept("--------------------------------------");
    }
}
