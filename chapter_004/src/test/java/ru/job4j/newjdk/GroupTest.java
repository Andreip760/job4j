package ru.job4j.newjdk;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
/**
 * Test
 * @author Andrei Pashchenko
 * @version 1
 * @since 24.03.2019
 */
public class GroupTest {
    /**
     * Selecting students that have score more than 10.
     * List of 4 students including nulls.
     */
    @Test
    public void when4StudentsAndNullsBound10Then2Students() {
        Student first = new Student("student1", 10);
        Student second = new Student("student2", 20);
        Student third = new Student("student3", 15);
        Student fourth = new Student("student4", 9);
        List<Student> input = Arrays.asList(first, null, second, third, null, fourth);
        List<Student> result = new Group().levelOf(input, 10);
        assertThat(result, is(List.of(second, third)));
    }
}
