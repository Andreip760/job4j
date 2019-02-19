package ru.job4j.pseudo;

import java.util.StringJoiner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 19.02.2019
 */
public class PaintTest {
    /**
     * Drawing a square (considering last newline as result of println)
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        System.setOut(stdout);
    }
    /**
     * Drawing a triangle (considering last newline as result of println)
     */
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        System.setOut(stdout);
    }
}
