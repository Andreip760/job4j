package ru.job4j.tracker;
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
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите Id заявки");
        String name = input.ask("Введите новое имя");
        String desc = input.ask("Введите новое описание");
        if (tracker.replace(id, new Item(name, desc))) {
            System.out.printf("Заявка Id: %s заменена%s", id, System.lineSeparator());
        } else {
            System.out.printf("Заявка Id: %s не найдена%s", id, System.lineSeparator());
        }
        System.out.println("-------------------------------------------------");
    }
}
