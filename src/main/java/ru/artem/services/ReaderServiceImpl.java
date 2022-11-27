package ru.artem.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.artem.lab2.Reader;
import ru.artem.repo.ReaderRepo;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService{

    private final ReaderRepo readerRepo;

    @Override
    public List<Reader> getAllReaders() {
        return readerRepo.getReaders();
    }

    @Override
    public void addReader(Reader reader){
        readerRepo.addReader(reader);
    }
}
