package ru.job4j.listtomap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Class for converting a list of students to the map.
 * @author Andrei Pashchenko
 * @version 1
 * @since 21.03.2019
 */
public class Converter {
    /**
     * Converting a list of students to the map.
     * @param students List of students.
     * @return Map
     */
    public Map<String, Student> convertToMap(List<Student> students) {
        return students.stream().collect(
                Collectors.toMap(
                        Student::getSurname,
                        student -> student
                )
        );
    }
}
