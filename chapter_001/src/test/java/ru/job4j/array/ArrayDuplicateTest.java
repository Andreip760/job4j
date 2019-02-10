package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 11.02.2019
 */
public class ArrayDuplicateTest {
    /**
     * Test some duplicates
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Мир", "Труд", "Труд", "Май", "Мир"};
        String[] expect = {"Мир", "Труд", "Май"};
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
    /**
     * Test all duplicates
     */
    @Test
    public void whenDuplicatingOneWordThenArrayOfOneWord() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Мир", "Мир", "Мир"};
        String[] expect = {"Мир"};
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
    /**
     * Test no duplicates
     */
    @Test
    public void whenNoDuplicatesThenArrayItself() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = {"Мир", "Труд", "Май"};
        String[] expect = {"Мир", "Труд", "Май"};
        String[] result = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
