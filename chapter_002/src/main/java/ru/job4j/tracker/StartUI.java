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
        while (true) {
            System.out.println("Меню.");
            menu.show();
            int answer = Integer.valueOf(input.ask("select:"));
            if (answer >= 6) {
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
