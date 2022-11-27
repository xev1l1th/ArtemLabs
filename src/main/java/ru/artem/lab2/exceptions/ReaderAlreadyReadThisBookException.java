package ru.artem.lab2.exceptions;

import ru.artem.lab1.exceptions.Lab1Exception;

public class ReaderAlreadyReadThisBookException extends Lab1Exception {

    public ReaderAlreadyReadThisBookException() {
        super("123");
    }
}
