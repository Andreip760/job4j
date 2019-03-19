package ru.job4j.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Class using stream API.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 20.03.2019
 */
public class StreamUsage {
    /**
     * Internal class represents a task
     */
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{name='" + name + "', spent=" + spent + '}';
        }
    }
    /**
     * Selecting tasks (entire / partial) using stream API.
     * 1. Filtering tasks by name (using stream filter).
     * 2. Selecting all names from tasks (using stream map).
     * 3. Calculating spent for all tasks (using stream map).
     * 4. Calculating spent for "Bug" tasks (using stream filter & map).
     * @param args Arguments.
     */
    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        List<Task> bugs = tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .collect(Collectors.toList());
        bugs.forEach(System.out::println);

        List<String> names = tasks.stream()
                .map(task -> task.name)
                .collect(Collectors.toList());
        names.forEach(System.out::println);

        Long spent = tasks.stream()
                .map(task -> task.spent)
                .reduce(0L, Long::sum);
        System.out.println("Total " + spent);

        Long spentBugs = tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .map(task -> task.spent)
                .reduce(0L, Long::sum);
        System.out.println("Bugs " + spentBugs);
    }
}
