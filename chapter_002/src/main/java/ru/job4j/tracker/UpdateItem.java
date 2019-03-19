package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Strategy for updating existing item in the tracker
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class UpdateItem extends BaseAction {
    public UpdateItem(int key, String info) {
        super(key, info);
    }
    /**
     * Replacing an existing item with another one
     * @param input Input interface
     * @param output Output interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Consumer<String> output, Tracker tracker) {
        output.accept("------------ Редактирование заявки --------------");
        String id = input.ask("Введите Id заявки");
        String name = input.ask("Введите новое имя");
        String desc = input.ask("Введите новое описание");
        if (tracker.replace(id, new Item(name, desc))) {
            output.accept(String.format("Заявка Id: %s заменена", id));
        } else {
            output.accept(String.format("Заявка Id: %s не найдена", id));
        }
        output.accept("-------------------------------------------------");
    }
}
