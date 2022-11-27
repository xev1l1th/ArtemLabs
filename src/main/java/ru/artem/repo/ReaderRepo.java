package ru.artem.repo;

import java.util.List;
import ru.artem.lab2.Reader;

public interface ReaderRepo {

    List<Reader> getReaders();

    void addReader(Reader reader);

}
