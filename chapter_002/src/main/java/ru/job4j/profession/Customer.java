package ru.job4j.profession;

import java.util.Date;

public class Customer extends Profession {
    private Date deadLine;
    private String nameOrganization;

    public Customer(String name, String surname, Date deadLine, String organization) {
        super(name, surname);
        this.deadLine = deadLine;
        nameOrganization = organization;
    }
}
