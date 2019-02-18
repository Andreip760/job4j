package ru.job4j.tracker;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 16.02.2019
 */
public class TrackerTest {
    /**
     * Find all existing items
     */
    @Test
    public void whenFindAllThenReturnAllExisting() {
        Tracker tracker = new Tracker();
        Item first = new Item("Test1", "description1");
        tracker.add(first);
        Item second = new Item("Test2", "description2");
        tracker.add(second);
        Item[] result = tracker.findAll();
        Item[] expect = {first, second};
        assertThat(result, is(expect));
    }
    /**
     * Add new item to the tracker
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    /**
     * Replace existing item with another one
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**
     * Delete item from tracker
     */
    @Test
    public void whenDeleteItemThenReturnWithoutItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        Item deletion = new Item("test2", "toDelete");
        tracker.add(deletion);
        Item third = new Item("test3", "testDescription3");
        tracker.add(third);
        tracker.delete(deletion.getId());
        Item[] expect = {first, third};
        assertThat(tracker.findAll(), is(expect));
    }
    /**
     * Find item by name
     */
    @Test
    public void whenFindByNameThenReturnFoundItemsArray() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        Item second = new Item("test2", "testDescription");
        tracker.add(second);
        Item third = new Item("test1", "testDescription3");
        tracker.add(third);
        Item[] result = tracker.findByName("test1");
        Item[] expect = {first, third};
        assertThat(result, is(expect));
    }
    /**
     * Find item by Id
     */
    @Test
    public void whenFindByIdThenReturnFoundItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        Item second = new Item("test2", "testDescription");
        tracker.add(second);
        Item third = new Item("test1", "testDescription3");
        tracker.add(third);
        Item result = tracker.findById(second.getId());
        assertThat(result, is(second));
    }
}
