package ru.job4j.pseudo;
/**
 *Class for drawing shapes using strategies.
 *@author Andrei Pashchenko.
 *@version 1
 *@since 19.02.2019
 */
public class Paint {
    /**
     * Drawing a shape using a provided strategy.
     * @param shape Drawing strategy.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
    /**
     * Entry point.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        new Paint().draw(new Triangle());
        new Paint().draw(new Square());
    }
}
