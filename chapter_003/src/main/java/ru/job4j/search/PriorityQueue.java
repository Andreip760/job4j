package ru.job4j.search;
import java.util.LinkedList;
/**
 * Tasks' queue with priority
 * @author Andrei Pashchenko.
 * @version 1
 * @since 07.03.2019
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Inserting the task considering its priority.
     * @param task Task.
     */
    public void put(Task task) {
        var inserted = false;
        for (var i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority() > task.getPriority()) {
                tasks.add(i, task);
                inserted = true;
                break;
            }
        }
        if (!inserted) {
            tasks.add(task);
        }
    }
    /**
     * Pulling a task from the queue.
     * @return Task
     */
    public Task take() {
        return this.tasks.poll();
    }
}
