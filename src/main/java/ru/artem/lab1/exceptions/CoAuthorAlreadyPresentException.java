package ru.artem.lab1.exceptions;

public class CoAuthorAlreadyPresentException extends Lab1Exception {

    public CoAuthorAlreadyPresentException() {
        super("coauthor already present");
    }
}
