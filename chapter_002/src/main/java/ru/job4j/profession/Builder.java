package ru.job4j.profession;

public class Builder extends Engineer {

    public Builder(Project project, Customer customer) {
        super(project, customer);
    }

    @Override
    public Project develop(Customer customer) {
        return super.develop(customer);
    }
}
