package ru.job4j.condition;

/**
 * Class for calculating area of a triangle.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 07.02.2019
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Calculation of semi-perimeter.
     * @param ab Length of ab segment.
     * @param ac Length of ac segment.
     * @param bc Length of bc segment.
     * @return Semi-perimeter.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Calculation of area.
     * @return Area of the triangle. Or -1 if the triangle does not exist.
     */
    public double area() {
        double rsl = -1D;
        double ab = this.a.distanceTo(b);
        double ac = this.a.distanceTo(c);
        double bc = this.b.distanceTo(c);
        double p = this.period(ab, ac, bc);

        if (exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
    /**
     * Check for existence of the triangle.
     * @param ab Length of ab segment.
     * @param ac Length of ac segment.
     * @param bc Length of bc segment.
     * @return True if the triangle exists.
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab != 0 && ac != 0 && bc != 0;
    }
}
