package ru.job4j.students;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class for school operations.
 * @author Andrei Pashchenko
 * @version 1
 * @since 20.03.2019
 */
public class School {
    /**
     * Selecting students for classes (depends on student's score)
     * @param students List of students.
     * @param predict Predicate (Student's score)
     * @return Students that fit on predicate.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
       return students.stream().filter(predict).collect(Collectors.toList());
    }
}
