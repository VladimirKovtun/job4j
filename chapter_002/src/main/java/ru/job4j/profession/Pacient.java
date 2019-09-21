package ru.job4j.profession;

public class Pacient extends Profession {
    private String adress;
    private String insurance;

    public Pacient(String name, String surname, String adress, String insurance) {
        super(name, surname);
        this.adress = adress;
        this.insurance = insurance;
    }
}

