package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 24.02.2019
 */
public class ValidateInputTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Redirecting output
     */
    @Before
    public void setOutput() {
        System.setOut(new PrintStream(this.out));
    }
    /**
     * Redirecting output back
     */
    @After
    public void backOutput() {
        System.setOut(new PrintStream(this.stdout));
    }
    /**
     * Entered value is not a number
     */
    @Test
    public void whenNotNumberInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.out.toString(),
                is(
                        String.format("Enter a number%s", System.lineSeparator())
                )
        );
    }
}
