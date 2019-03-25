package ru.job4j.search;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 04.03.2019
 */
public class PhoneDictionaryTest {
    private PhoneDictionary phones;
    private final Person first = new Person("Vasya", "Pupkin", "534872", "Bryansk");

    /**
     * Creating the new phone book and adding the first record.
     */
    @Before
    public void init() {
        this.phones = new PhoneDictionary();
        this.phones.add(this.first);
    }
    /**
     * Finding person by name
     */
    @Test
    public void whenFindByName() {
        List<Person> persons = this.phones.find("Vasya");
        assertThat(persons.iterator().next().getSurname(), is("Pupkin"));
    }
    /**
     * Finding person by part of surname
     */
    @Test
    public void whenFindBySurName() {
        List<Person> persons = this.phones.find("Pupkin");
        assertThat(persons.iterator().next().getName(), is("Vasya"));
    }
    /**
     * Finding person by address
     */
    @Test
    public void whenFindByAddress() {
        List<Person> persons = this.phones.find("Bryansk");
        assertThat(persons.iterator().next().getName(), is("Vasya"));
    }
    /**
     * Finding person by partial keyword
     */
    @Test
    public void whenFindByPartialQuery() {
        List<Person> persons = this.phones.find("Brya");
        assertThat(persons.iterator().next().getPhone(), is("534872"));
    }
    /**
     * Finding person by partial keyword
     * Multiple records
     */
    @Test
    public void whenFindByPartialQueryThenTwoRecords() {
        Person second = new Person("Vasilisa", "Ivanova", "123456", "Msk");
        this.phones.add(second);
        List<Person> persons = this.phones.find("Vas");
        assertThat(persons, containsInAnyOrder(this.first, second));
    }
}
