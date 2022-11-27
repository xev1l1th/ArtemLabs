package ru.artem.lab2.exceptions;

import ru.artem.lab1.exceptions.Lab1Exception;

public class FavouriteAuthorAlreadyPresentException extends Lab1Exception {

    public FavouriteAuthorAlreadyPresentException() {
        super("favourite author already present exception");
    }
}
