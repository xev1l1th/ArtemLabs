package ru.artem.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.artem.lab2.Reader;
import ru.artem.services.ReaderService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "readers")
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping
    public List<Reader> getAllReaders(){
        return readerService.getAllReaders();
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addReader(@RequestBody Reader reader){
        readerService.addReader(reader);
    }

}
