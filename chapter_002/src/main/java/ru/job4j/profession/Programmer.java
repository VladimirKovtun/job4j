package ru.job4j.profession;

public class Programmer extends Engineer {

    public Programmer(Project project, Customer customer) {
        super(project, customer);
    }

    @Override
    public Project develop(Customer customer) {
        return super.develop(customer);
    }
}
