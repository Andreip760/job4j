package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 07.03.2019
 */
public class PriorityQueueTest {
    /**
     * Random input tasks' priorities. Yield - ordered by priority.
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
    /**
     * Tasks with the same priorities. Yield - ordered as is.
     */
    @Test
    public void whenSamePriorityThenCorrectOrder() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middle1", 3));
        queue.put(new Task("middle2", 3));
        queue.put(new Task("middle3", 3));
        assertThat(queue.take().getDesc(), is("middle1"));
        assertThat(queue.take().getDesc(), is("middle2"));
    }
}