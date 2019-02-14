package ru.job4j.calculator;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Andrei Pashchenko
 * @version 1
 * @since 06.02.2019
 */
public class CalculatorTest {
    /**
     * Test adding
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calculator = new Calculator();
        calculator.add(1D, 1D);
        double result = calculator.getResult();
        double expect = 2D;
        assertThat(result, is(expect));
    }
    /**
     * Test subtraction
     */
    @Test
    public void whenSubOneFromOneThenZero() {
        Calculator calculator = new Calculator();
        calculator.sub(1D, 1D);
        double result = calculator.getResult();
        double expect = 0D;
        assertThat(result, is(expect));
    }
    /**
     * Test multiplication
     */
    @Test
    public void whenMultTwoOnTwoThenFour() {
        Calculator calculator = new Calculator();
        calculator.mult(2D, 2D);
        double result = calculator.getResult();
        double expect = 4D;
        assertThat(result, is(expect));
    }
    /**
     * Test division
     */
    @Test
    public void whenDivFourByTwoThenTwo() {
        Calculator calculator = new Calculator();
        calculator.div(4D, 2D);
        double result = calculator.getResult();
        double expect = 2D;
        assertThat(result, is(expect));
    }

}