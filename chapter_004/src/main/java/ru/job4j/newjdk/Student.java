package ru.job4j.newjdk;
/**
 * Class student.
 * @author Andrei Pashchenko
 * @version 1
 * @since 24.03.2019
 */
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    /**
     * Getting student's score.
     * @return Score.
     */
    public int getScore() {
        return this.score;
    }
    /**
     * Comparing students by score (reversed order)
     * @param o Student.
     * @return Comparison result.
     */
    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.score, this.score);
    }
}
