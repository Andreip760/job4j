package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Strategy for deleting existing item from tracker
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class DeleteItem extends BaseAction {
    public DeleteItem(int key, String info) {
        super(key, info);
    }
     /**
     * Deleting existing item
     * @param input Input interface
     * @param output Output interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Consumer<String> output, Tracker tracker) {
        output.accept("------------ Удаление заявки --------------");
        String id = input.ask("Введите Id заявки ");
        if (tracker.delete(id)) {
            output.accept(String.format("Заявка Id: %s удалена", id));
        } else {
            output.accept(String.format("Заявка Id: %s не найдена", id));
        }
        output.accept("-------------------------------------------");
    }
}
