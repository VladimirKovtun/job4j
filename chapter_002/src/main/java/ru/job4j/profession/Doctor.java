package ru.job4j.profession;

public class Doctor extends Profession {
    private Pacient pacient;
    private Diagnose diagnose;

    protected Doctor(Pacient pacient, Diagnose desc) {
        this.pacient = pacient;
        diagnose = desc;
    }

    public Diagnose heal(Pacient pacient) {
        return null;
    }
}
