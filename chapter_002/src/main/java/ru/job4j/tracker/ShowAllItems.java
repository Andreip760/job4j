package ru.job4j.tracker;
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
}
