package ru.job4j.profession;

import java.util.Date;

public class Profession {
    private String name;
    private String surName;
    private String education;
    private Date birthDay;

    public Profession() {

    }

    protected Profession(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEducation() {
        return education;
    }

    public Date getBirthDay() {
        return birthDay;
    }
}
