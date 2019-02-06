package ru.job4j.converter;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Andrei Pashchenko
 * @version 1
 * @since 06.02.2019
 */
public class ConverterTest {
	/**
	 * Test Ruble -> Dollar
	 */
	@Test
	public void when60RubleToDollarThen1() {
		Converter converter = new Converter();
		int result = converter.rubleToDollar(60);
		assertThat(result, is(1));
	}
	/**
	 * Test Ruble -> Euro
	 */
	@Test
	public void when70RubleToEuroThen1() {
		Converter converter = new Converter();
		int result = converter.rubleToEuro(70);
		assertThat(result, is(1));
	}
	/**
	 * Test Euro -> Ruble
	 */
	@Test
	public void when1EuroToRubleThen70() {
		Converter converter = new Converter();
		int result = converter.euroToRuble(1);
		assertThat(result, is(70));
	}
	/**
	 * Test Dollar -> Ruble
	 */
	@Test
	public void when1DollarToRubleThen60() {
		Converter converter = new Converter();
		int result = converter.dollarToRuble(1);
		assertThat(result, is(60));
	}
}

