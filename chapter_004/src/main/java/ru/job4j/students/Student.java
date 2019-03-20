package ru.job4j.students;
/**
 * Class for student.
 * @author Andrei Pashchenko
 * @version 1
 * @since 20.03.2019
 */
public class Student {
    private int score;
    public Student(int score) {
        this.score = score;
    }
    /**
     * Get student's score.
     * @return score.
     */
    public int getScore() {
        return this.score;
    }
}
