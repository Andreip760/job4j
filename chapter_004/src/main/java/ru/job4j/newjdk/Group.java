package ru.job4j.newjdk;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Class contains method for selecting students by score.
 * @author Andrei Pashchenko
 * @version 1
 * @since 24.03.2019
 */
public class Group {
    /**
     * Selecting students by their's score (excluding nulls).
     * @param students List of students.
     * @param bound Minimum score level.
     * @return List
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}
