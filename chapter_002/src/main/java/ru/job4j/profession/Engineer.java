package ru.job4j.profession;

public class Engineer extends Profession {
    private Project project;
    private Customer customer;

    protected Engineer(Project project, Customer customer) {
        this.project = project;
        this.customer = customer;
    }

    protected Project develop(Customer customer) {
        return null;
    }
}
