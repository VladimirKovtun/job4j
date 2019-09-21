package ru.job4j.profession;

public class Surgeon extends Doctor {

    public Surgeon(Pacient pacient, Diagnose desc) {
        super(pacient, desc);
    }

    @Override
    public Diagnose heal(Pacient pacient) {
        return super.heal(pacient);
    }
}
