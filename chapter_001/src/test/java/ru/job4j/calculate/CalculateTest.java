package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Andrei Pashchenko
 * @version $id$
 * @since 0.1
 */
public class CalculateTest {
	/**
	 * Test echo
	 */
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Andrei";
		String expect = "Echo, echo, echo : Andrei";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}
