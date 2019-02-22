package ru.job4j.tracker;
/**
 * Strategy for showing all items in the tracker
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class ShowAllItems implements UserAction {
    private final int key;
    private final String info;

    public ShowAllItems(int key, String info) {
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
     * Showing all items in the tracker
     * @param input Input interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Все заявки --------------");
        for (Item item : tracker.findAll()) {
            System.out.printf("%s %s %s%s", item.getId(), item.getName(), item.getDesc(), System.lineSeparator());
        }
        System.out.println("--------------------------------------");
    }
    /**
     * @return Action information
     */
    @Override
    public String info() {
        return this.info;
    }
}
