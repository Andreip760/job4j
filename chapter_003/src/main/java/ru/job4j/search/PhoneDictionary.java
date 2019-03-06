package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
/**
 * Class phone book (contains persons).
 * @author Andrei Pashchenko.
 * @version 1
 * @since 04.03.2019
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Find person by key-phrase (all fields)
     * @param key Key-phrase.
     * @return Person
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.getAddress().contains(key)
                    || person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
            ) {
                result.add(person);
            }
        }
        return result;
    }
}