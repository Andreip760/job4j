package ru.job4j.tracker;
/**
 * Strategy for finding item by its' id
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class FindById implements UserAction {
    private final int key;
    private final String info;

    public FindById(int key, String info) {
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
     * Finding an item by its' id
     * @param input Input interface
     * @param tracker Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по Id ------------");
        String id = input.ask("Введите Id заявки");
        Item found = tracker.findById(id);
        if (found != null) {
            System.out.printf("%s %s %s%s", found.getId(), found.getName(), found.getDesc(), System.lineSeparator());
        } else {
            System.out.printf("Заявка Id: %s не найдена%s", id, System.lineSeparator());
        }
        System.out.println("-------------------------------------------");
    }
    /**
     * @return Action information
     */
    @Override
    public String info() {
        return this.info;
    }
}
