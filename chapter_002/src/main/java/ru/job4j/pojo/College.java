package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setName("Ivan");
        ivan.setMiddleName("Petrovich");
        ivan.setSurName("Sidorov");
        ivan.setGroupID("363-4");
        ivan.setDateAdmission(LocalDate.of(2009, 9, 1));
        System.out.printf("Student info: %s %s %s%nGroup Id: %s%nDate of admission: %d.%d.%d",
                ivan.getName(), ivan.getMiddleName(), ivan.getSurName(), ivan.getGroupID(),
                ivan.getDateAdmission().getDayOfMonth(), ivan.getDateAdmission().getMonthValue(),
                ivan.getDateAdmission().getYear());
    }
}
