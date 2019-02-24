package ru.job4j.tracker;
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
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите Id заявки ");
        if (tracker.delete(id)) {
            System.out.printf("Заявка Id: %s удалена%s", id, System.lineSeparator());
        } else {
            System.out.printf("Заявка Id: %s не найдена%s", id, System.lineSeparator());
        }
        System.out.println("-------------------------------------------");
    }
}
