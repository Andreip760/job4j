package ru.job4j.tracker;
/**
 * Strategy for finding items by name
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class FindByName implements UserAction {
    private final int key;
    private final String info;

    public FindByName(int key, String info) {
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
     * Finding items by name
     * @param input Input interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = input.ask("Введите имя ");
        for (Item item : tracker.findByName(name)) {
            System.out.printf("%s %s %s%s", item.getId(), item.getName(), item.getDesc(), System.lineSeparator());
        }
        System.out.println("-------------------------------------------------");
    }
    /**
     * @return Action information
     */
    @Override
    public String info() {
        return this.info;
    }
}
