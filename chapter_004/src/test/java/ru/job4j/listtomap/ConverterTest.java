package ru.job4j.listtomap;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
/**
 * Test
 * @author Andrei Pashchenko
 * @version 1
 * @since 21.03.2019
 */
public class ConverterTest {
    private Student first = new Student("Ivanov", 1);
    private Student second = new Student("Petrov", 5);
    /**
     * Converting list of students to map( key: Surname, value: object - student)
     */
    @Test
    public void whenListOfTwoStudentsThenMapOfTwo() {
        List<Student> input = Arrays.asList(this.first, this.second);
        Map<String, Student> result = new Converter().convertToMap(input);
        assertThat(result.size(), is(2));
        assertThat(result, hasEntry(this.first.getSurname(), this.first));
        assertThat(result, hasEntry(this.second.getSurname(), this.second));
        System.out.println(result.toString());
    }
}
