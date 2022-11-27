package ru.artem.repo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.artem.lab2.Reader;

@Service
public class InMemoryReaderRepo implements ReaderRepo{

    private final List<Reader> readerList = new ArrayList<>();

    @Override
    public List<Reader> getReaders() {
        return readerList;
    }

    @Override
    public void addReader(Reader reader){
        readerList.add(reader);
    }
}
