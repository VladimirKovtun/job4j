package ru.job4j.solidgame;

public interface Choosable<T extends IEvent> {

    T opponentEventReturner();
}
