package ru.job4j.tracker;

import java.util.function.Consumer;

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
     * Output interface.
     */
    private final Consumer<String> output;
    /**
     * Applications storage.
     */
    private final Tracker tracker;
    /**
     * Class's fields initializer (constructor)
     * @param input Input interface.
     * @param output Output interface.
     * @param tracker Tracker.
     */
    public StartUI(Input input, Consumer<String> output, Tracker tracker) {
        this.input = input;
        this.output = output;
        this.tracker = tracker;
    }
    /**
     * Main loop.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.output, this.tracker);
        menu.fillActions();
        final int[] range = new int[menu.getActionsLength()];
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range[i] = i;
        }
        while (true) {
            this.output.accept("Меню.");
            menu.show();
            int answer = this.input.ask("select:", range);
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
        new StartUI(
                new ValidateInput(
                        new ConsoleInput(System.out::println),
                        System.out::println
                ),
                System.out::println,
                new Tracker()
        ).init();
    }
}
