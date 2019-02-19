package ru.job4j.pseudo;

import java.util.StringJoiner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 19.02.2019
 */
public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Redirecting output stream to byte array.
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(out));
    }
    /**
     * Redirecting output stream back to console.
     */
    @After
    public void backOutput() {
        System.setOut(stdout);
        System.out.println("execute after method");
    }
    /**
     * Drawing a square (considering last newline as result of println)
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("****")
                                .add("*  *")
                                .add("*  *")
                                .add("****")
                                .toString()
                )
        );
    }
    /**
     * Drawing a triangle (considering last newline as result of println)
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("*   ")
                                .add("**  ")
                                .add("*** ")
                                .add("****")
                                .toString()
                )
        );
    }
}
