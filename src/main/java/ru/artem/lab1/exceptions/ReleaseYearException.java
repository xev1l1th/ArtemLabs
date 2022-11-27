package ru.artem.lab1.exceptions;

public class ReleaseYearException extends Lab1Exception {

    public ReleaseYearException() {
        super("release year in null or empty");
    }
}
