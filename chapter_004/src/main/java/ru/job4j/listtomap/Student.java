package ru.job4j.listtomap;

import java.util.Objects;

/**
 * Class for student.
 * @author Andrei Pashchenko
 * @version 1
 * @since 20.03.2019
 */
public class Student {
    private String surname;
    private int score;

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }
    /**
     * Getting student's surname.
     * @return Surname.
     */
    public String getSurname() {
        return this.surname;
    }
    /**
     * Get student's score.
     * @return score.
     */
    public int getScore() {
        return this.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return this.score == student.getScore() && this.surname.equals(student.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.surname, this.score);
    }
}
