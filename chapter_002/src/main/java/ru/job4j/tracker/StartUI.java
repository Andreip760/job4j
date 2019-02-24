package ru.job4j.tracker;
/**
 * Class serving interaction with user.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 18.02.2019
 */
public class StartUI {
    /**
     * Input interface.
     */
    private final Input input;
    /**
     * Applications storage.
     */
    private final Tracker tracker;
    /**
     * Class's fields initializer (constructor)
     * @param input Input interface.
     * @param tracker Tracker.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Main loop.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        final int[] range = new int[menu.getActionsLength()];
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range[i] = i;
        }
        while (true) {
            System.out.println("Меню.");
            menu.show();
            int answer = input.ask("select:", range);
            if (answer == 6) {
                break;
            }
            menu.select(answer);
        }
    }
    /**
     * Entry point.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
