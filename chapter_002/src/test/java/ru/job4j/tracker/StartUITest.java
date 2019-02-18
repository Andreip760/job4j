package ru.job4j.tracker;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 18.02.2019
 */
public class StartUITest {
    /**
     * Adding new item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    /**
     * Updating existing item
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    /**
     * Deleting item
     */
    @Test
    public void whenDeleteThenTrackerHasItemsWithoutDeleted() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first", "delete"));
        Item second = tracker.add(new Item("second", "desc"));
        Input input = new StubInput(new String[] {"3", first.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(second));
    }
}
