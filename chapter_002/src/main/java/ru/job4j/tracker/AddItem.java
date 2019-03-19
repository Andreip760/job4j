package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Strategy for adding a new item to the tracker
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class AddItem extends BaseAction {
    public AddItem(int key, String info) {
        super(key, info);
    }
    /**
     * Adding new item to the tracker
     * @param input Input interface
     * @param output Output interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Consumer<String> output, Tracker tracker) {
        output.accept("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.add(item);
        output.accept("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
}
