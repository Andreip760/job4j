package ru.job4j.condition;

/**
 * Class for calculating distance between points
 * @author Andrei Pashchenko
 * @version 1
 * @since 07.02.2019
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Calculating distance between points
     * @param that Point
     * @return Distance between points
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
    /**
     * Main method
     * @param args Arguments
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками A и B = " + result);
    }
}
