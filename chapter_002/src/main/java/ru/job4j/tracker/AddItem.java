package ru.job4j.tracker;
/**
 * Strategy for adding a new item to the tracker
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class AddItem implements UserAction {
    private final int key;
    private final String info;

    public AddItem(int key, String info) {
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
     * Adding new item to the tracker
     * @param input Input interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * @return Action information
     */
    @Override
    public String info() {
        return this.info;
    }
}
