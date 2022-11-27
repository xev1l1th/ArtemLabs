package ru.artem.lab2.exceptions;

import ru.artem.lab1.exceptions.Lab1Exception;

public class BookReadAlreadyPresentException extends Lab1Exception {


    public BookReadAlreadyPresentException() {
        super("book present");
    }
}
