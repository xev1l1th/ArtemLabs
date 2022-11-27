package ru.artem.services;

import java.util.List;
import ru.artem.lab2.Reader;

public interface ReaderService {

    List<Reader> getAllReaders();

    void addReader(Reader reader);

}
