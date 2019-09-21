package ru.job4j.profession;

public class Dentist extends Doctor {

    public Dentist(Pacient pacient, Diagnose desc) {
        super(pacient, desc);
    }

    @Override
    public Diagnose heal(Pacient pacient) {
        return super.heal(pacient);
    }
}
