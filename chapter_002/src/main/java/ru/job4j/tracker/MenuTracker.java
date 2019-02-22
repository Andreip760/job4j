package ru.job4j.tracker;
import java.util.List;
import java.util.ArrayList;
/**
 * Class for prepare and show the user's menu, and execute selected actions
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.02.2019
 */
public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Filling the actions array by strategies
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new item"));
        this.actions.add(new ShowAllItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindById(4, "Find item by Id"));
        this.actions.add(new FindByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }
    /**
     * Executing selected action
     * @param key User's selection (actions' index)
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Showing all available actions (menu)
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(String.format("%s. %s", action.key(), action.info()));
            }
        }
    }
}
