package ru.job4j.converter;

/**
 *Class for currency conversion
 *@author Andrei Pashchenko
 *@since 06.02.2019
 *@version 1
 */
public class Converter {
	private final int rubInEur = 70;
	private final int rubInDoll = 60;
	/**
	 * Converting Ruble to Euro
	 * @param value Ruble
	 * @return Euro
	 */
	public int rubleToEuro(int value) {
		return  value / rubInEur;
	}
	/**
	 * Converting Rouble to Dollar
	 * @param value Ruble
	 * @return Dollar
	 */
	public int rubleToDollar(int value) {
		return value / rubInDoll;
	}
	/**
	 * Converting Euro to Ruble
	 * @param value Euro
	 * @return Rouble
	 */
	public int euroToRuble(int value) {
		return  value * rubInEur;
	}
	/**
	 * Converting Dollar to Ruble
	 * @param value Dollar
	 * @return Rouble
	 */
	public int dollarToRuble(int value) {
		return value * rubInDoll;
	}
}
