package ru.artem.lab1.exceptions;

public class AuthorCreationException extends Lab1Exception {

    public AuthorCreationException() {
        super("author's names are not present");
    }
}
