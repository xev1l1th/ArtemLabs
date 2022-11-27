package ru.artem.lab1.exceptions;

public class CirculationException extends Lab1Exception {

    public CirculationException() {
        super("circulation is null or empty");
    }
}
