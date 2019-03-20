package ru.job4j.students;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * Test
 * @author Andrei Pashchenko
 * @version 1
 * @since 20.03.2019
 */
public class SchoolTest {
    private List<Student> students = Arrays.asList(
            new Student(10),
            new Student(70),
            new Student(60),
            new Student(50),
            new Student(90)
    );
    /**
     * Searching for students that have score >= 70.
     */
    @Test
    public void whenPredictForClassAThenSecondAndFifth() {
        List result = new School().collect(students, student -> student.getScore() >= 70);
        assertThat(result, is(Arrays.asList(students.get(1), students.get(4))));
    }
    /**
     * Searching for students that have score >= 50 and < 70.
     */
    @Test
    public void whenPredictForClassBThenThirdAndFourth() {
        List result = new School().collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        assertThat(result, is(Arrays.asList(students.get(2), students.get(3))));
    }
    /**
     * Searching for students that have score < 50.
     */
    @Test
    public void whenPredictForClassCThenFirst() {
        List result = new School().collect(students, student -> student.getScore() < 50);
        assertThat(result, is(Arrays.asList(students.get(0))));
    }
}
