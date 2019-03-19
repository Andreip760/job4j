package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Strategy for finding item by its' id
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class FindById extends BaseAction {
    public FindById(int key, String info) {
        super(key, info);
    }
    /**
     * Finding an item by its' id
     * @param input Input interface
     * @param output Output interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Consumer<String> output, Tracker tracker) {
        output.accept("------------ Поиск заявки по Id ------------");
        String id = input.ask("Введите Id заявки");
        Item found = tracker.findById(id);
        if (found != null) {
            output.accept(String.format("%s %s %s", found.getId(), found.getName(), found.getDesc()));
        } else {
            output.accept(String.format("Заявка Id: %s не найдена", id));
        }
        output.accept("-------------------------------------------");
    }
}
