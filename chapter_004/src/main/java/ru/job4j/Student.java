package ru.job4j;

public class Student {
    private String firstName;
    private String lastName;
    private int score;

    public Student(int score) {
        this.score = score;
    }

    public Student(int score, String firstName, String lastName) {
        this.score = score;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", score=" + score
                + '}';
    }
}
