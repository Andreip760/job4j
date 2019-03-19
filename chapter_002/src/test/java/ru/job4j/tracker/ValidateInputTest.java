package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 24.02.2019
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new PrintStream(out)::println;

    /**
     * Entered value is valid
     */
    @Test
    public void whenValidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"1"}),
                output
        );
        input.ask("Enter", new int[]{1});
        assertThat(this.out.toString(), is(""));
    }
    /**
     * Entered value is not a number
     */
    @Test
    public void whenNotNumberInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"}),
                output
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.out.toString(),
                is(
                        String.format("Enter a number%s", System.lineSeparator())
                )
        );
    }
    /**
     * Entered value is out of range
     */
    @Test
    public void whenNotInRangeInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"2", "1"}),
                output
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.out.toString(),
                is(
                        String.format("Enter a number from the menu range%s", System.lineSeparator())
                )
        );
    }
}
