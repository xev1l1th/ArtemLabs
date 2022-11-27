package ru.artem.lab1.exceptions;

public class BookNameException extends Lab1Exception {

    public BookNameException() {
        super("Book name is null or empty");
    }
}
