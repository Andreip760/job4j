package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Strategy for finding items by name
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class FindByName extends BaseAction {
    public FindByName(int key, String info) {
        super(key, info);
    }
    /**
     * Finding items by name
     * @param input Input interface
     * @param output Output interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Consumer<String> output, Tracker tracker) {
        output.accept("------------ Поиск заявки по имени --------------");
        String name = input.ask("Введите имя ");
        for (Item item : tracker.findByName(name)) {
            output.accept(String.format("%s %s %s", item.getId(), item.getName(), item.getDesc()));
        }
        output.accept("-------------------------------------------------");
    }
}
