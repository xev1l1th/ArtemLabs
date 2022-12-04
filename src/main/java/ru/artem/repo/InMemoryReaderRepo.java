package ru.artem.repo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.artem.lab1.exceptions.Lab1Exception;
import ru.artem.lab2.Reader;
import ru.artem.lab2.ScienceBook;

@Service
public class InMemoryReaderRepo implements ReaderRepo{

    private final List<Reader> readerList = new ArrayList<>();

    @Override
    public List<Reader> getReaders() {
        return readerList;
    }

    @Override
    public void addReader(Reader reader){
        if(readerList.contains(reader)){
            throw new Lab1Exception("reader already present");
        }
        readerList.add(reader);
    }

    @Override
    public void update(Reader reader) {
        if(!readerList.contains(reader)){
            throw new Lab1Exception("nu such reader in repo");
        }
        readerList.add(reader);
    }

    @Override
    public void delete(Reader reader) {
        if(!readerList.contains(reader)) {
            throw new Lab1Exception("nu such reader in repo");
        }

        readerList.remove(reader);
    }


}
