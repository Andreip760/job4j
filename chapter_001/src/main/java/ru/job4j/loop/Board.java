package ru.job4j.loop;

/**
 * Class generates checkmate board
 * @author Andrei Pashchenko
 * @version 1
 * @since 08.02.2019
 */
public class Board {
    /**
     * Assembly a string representation of a checkmate board
     * @param width Board width
     * @param height Board height
     * @return Checkmate board
     */
    public String paint(int width, int height) {
        StringBuilder stringBuilder = new StringBuilder();
        String ln = System.getProperty("line.separator");

        for (int i = 0; i < height; i++) {
            for (int k = 0; k < width; k++) {
                if ((i + k) % 2 == 0) {
                    stringBuilder.append('x');
                } else {
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append(ln);
        }
        return stringBuilder.toString();
    }
}
