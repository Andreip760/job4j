package ru.job4j.tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import java.util.function.Consumer;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 18.02.2019
 */
public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new PrintStream(out)::println;
    private Tracker tracker;
    private Item item;

    /**
     * Creating new tracker
     * Adding the first item to the tracker
     */
    @Before
    public void initialize() {
        this.tracker = new Tracker();
        this.item = this.tracker.add(new Item("name1", "desc1"));
    }
    /**
     * Adding new item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, this.output, this.tracker).init();
        assertThat(this.tracker.findAll().get(1).getName(), is("test name"));
    }
    /**
     * Updating existing item
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"2", this.item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, this.output, this.tracker).init();
        assertThat(this.tracker.findById(this.item.getId()).getName(), is("test replace"));
    }
    /**
     * Deleting item
     */
    @Test
    public void whenDeleteThenTrackerHasItemsWithoutDeleted() {
        Item second = this.tracker.add(new Item("second", "desc"));
        Input input = new StubInput(new String[] {"3", this.item.getId(), "6"});
        new StartUI(input, this.output, this.tracker).init();
        assertThat(this.tracker.findAll().get(0), is(second));
    }
    /**
     * Showing main menu.
     */
    @Test
    public void whenStartUIThenPrintMenu() {
        Input input = new StubInput(new String[] {"6"});
        new StartUI(input, this.output, this.tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("Меню.")
                                .add("0. Add new item")
                                .add("1. Show all items")
                                .add("2. Edit item")
                                .add("3. Delete item")
                                .add("4. Find item by Id")
                                .add("5. Find items by name")
                                .add("6. Exit Program").toString()
                )
        );
    }
    /**
     * Showing all items.
     */
    @Test
    public void whenShowAllThenPrintAllItems() {
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, this.output, this.tracker).init();
        assertThat(
                this.cutConsole(this.out.toString()),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("------------ Все заявки --------------")
                                .add(this.getItemString(this.item))
                                .add("--------------------------------------")
                                .toString()
                )
        );
    }
    /**
     * Finding item by id.
     */
    @Test
    public void whenFindByIdThenPrintFoundItem() {
        Input input = new StubInput(new String[] {"4", this.item.getId(), "6"});
        new StartUI(input, this.output, this.tracker).init();
        assertThat(
                this.cutConsole(this.out.toString()),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("------------ Поиск заявки по Id ------------")
                                .add(this.getItemString(this.item))
                                .add("-------------------------------------------")
                                .toString()
                )
        );
    }
    /**
     * Finding item by name
     */
    @Test
    public void whenFindByNameThenPrintFoundItem() {
        Input input = new StubInput(new String[] {"5", this.item.getName(), "6"});
        new StartUI(input, this.output, this.tracker).init();
        assertThat(
                this.cutConsole(this.out.toString()),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("------------ Поиск заявки по имени --------------")
                                .add(this.getItemString(this.item))
                                .add("-------------------------------------------------")
                                .toString()
                )
        );
    }
    /**
     * String representation of item.
     * @param item Item.
     * @return String (id name desc).
     */
    private String getItemString(Item item) {
        return new StringJoiner(" ")
                .add(item.getId())
                .add(item.getName())
                .add(item.getDesc())
                .toString();
    }
    /**
     * Cutting results from the console string.
     * @param console String from console.
     * @return results.
     */
    private String cutConsole(String console) {
        return console.substring(console.indexOf("-"), console.lastIndexOf("-") + 1) + System.lineSeparator();
    }
}
