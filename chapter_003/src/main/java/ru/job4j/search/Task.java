package ru.job4j.search;
/**
 * Task with priority
 * @author Andrei Pashchenko.
 * @version 1
 * @since 07.03.2019
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }
    /**
     * Getting the task description.
     * @return Description.
     */
    public String getDesc() {
        return desc;
    }
    /**
     * Getting the task priority.
     * @return Priority.
     */
    public int getPriority() {
        return priority;
    }
}
